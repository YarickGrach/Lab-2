package Num8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StudentGrades {

    public static class Student {
        private String name;
        private List<Integer> grades;
        private double average;

        public Student(String name, List<Integer> grades) {
            this.name = name;
            this.grades = new ArrayList<>(grades);
            this.average = calculateAverage();
        }

        private double calculateAverage() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        public String getName() { return name; }
        public List<Integer> getGrades() { return new ArrayList<>(grades); }
        public double getAverage() { return average; }

        @Override
        public String toString() {
            return String.format("%s: %.2f", name, average);
        }
    }

    private Map<String, Student> students;

    public StudentGrades() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> analyze(String filename) {
        students.clear();

        try {
            Path filePath = Paths.get(filename);

            if (!Files.exists(filePath)) {
                System.out.println("Файл не найден!");
                return Collections.emptyMap();
            }

            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                processStudentLine(line);
            }

            return new HashMap<>(students);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return Collections.emptyMap();
        }
    }

    private void processStudentLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return;
        }

        String[] parts = line.trim().split("\\s+");

        if (parts.length < 2) {
            System.out.println("Некорректная строка: " + line);
            return;
        }

        String name = parts[0];
        List<Integer> grades = new ArrayList<>();

        try {
            for (int i = 1; i < parts.length; i++) {
                int grade = Integer.parseInt(parts[i]);
                if (grade < 1 || grade > 5) {
                    System.out.println("Некорректная оценка у студента " + name + ": " + grade);
                    continue;
                }
                grades.add(grade);
            }

            if (!grades.isEmpty()) {
                students.put(name, new Student(name, grades));
            } else {
                System.out.println("У студента " + name + " нет валидных оценок");
            }

        } catch (NumberFormatException e) {
            System.out.println("Ошибка парсинга оценок у студента " + name);
        }
    }

    public String bestStudent() {
        if (students.isEmpty()) {
            return "Нет данных о студентах";
        }

        return students.values().stream()
                .max(Comparator.comparingDouble(Student::getAverage))
                .map(Student::getName)
                .orElse("Не найден");
    }

    public String worstStudent() {
        if (students.isEmpty()) {
            return "Нет данных о студентах";
        }

        return students.values().stream()
                .min(Comparator.comparingDouble(Student::getAverage))
                .map(Student::getName)
                .orElse("Не найден");
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Нет данных о студентах");
            return;
        }

        students.values().stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }
    }