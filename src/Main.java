import Num1.Butto;
import Num2.Balance;
import Num3.Bell;
import Num4.OddEvenSeparator;
import Num5.Table;
import Num6.exceptions.*;
import Num6.geometry2d.*;
import Num6.geometry3d.*;
import Num7.FileAnalyzer;
import Num8.StudentGrades;

public class Main{

    public static void main(String[] args) {
        System.out.println("Num1:\n");
        Butto but = new Butto();
        for (int i = 0; i < 4; i++) but.click();
        System.out.println();

        System.out.println("Num2:\n");
        Balance bal = new Balance();
        bal.addLeft(1);
        bal.result();
        bal.addRight(2);
        bal.result();
        bal.addLeft(1);
        bal.result();
        System.out.println();

        System.out.println("Num3:\n");
        Bell bell = new Bell();
        for (int i = 0; i < 4; i++) bell.sound();
        System.out.println();

        System.out.println("Num4:\n");
        OddEvenSeparator separator = new OddEvenSeparator();
        for (int i = 0; i <= 5; i++) separator.addNumber(i);
        separator.even();
        separator.odd();
        System.out.println();

        System.out.println("Num5:\n");
        Table matrix = new Table(2, 2);
        matrix.setValue(1,1,2);
        matrix.setValue(1,2,1);
        matrix.setValue(2,1,3);
        matrix.setValue(2,2,4);
        matrix.getValue(1,2);
        System.out.println("Rows: " + matrix.rows());
        System.out.println("Cols: " + matrix.cols());
        System.out.println("Averge: " + matrix.average());
        System.out.println(matrix.toString());
        System.out.println();

        System.out.println("Num6:\n");
        try {
            Circle circle = new Circle(5.0);
            Rectangle rectangle = new Rectangle(4.0, 6.0);

            System.out.println("2D Figures:");
            System.out.println(circle);
            System.out.println(rectangle);

            Cylinder cylinder1 = new Cylinder(circle, 10.0);
            Cylinder cylinder2 = new Cylinder(rectangle, 8.0);

            System.out.println("\n3D Figures:");
            System.out.println(cylinder1);
            System.out.println(cylinder2);

            try {
                Circle invalidCircle = new Circle(-5.0);
            } catch (InvalidGeometryException e) {
                System.out.println("\nCaught expected exception: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Num7:\n");
        FileAnalyzer analyzer = new FileAnalyzer();
        System.out.println("Анализ файла:");
        analyzer.analyzeAndPrint("src/test.txt");
        System.out.println("\nАнализ несуществующего файла:");
        analyzer.analyzeAndPrint("nonexistent.txt");
        System.out.println();

        System.out.println("Num8:");
        StudentGrades studanalyzer = new StudentGrades();
        studanalyzer.analyze("src/test.txt");
        System.out.println("\n=== Результаты ===");
        System.out.println("Лучший студент: " + studanalyzer.bestStudent());
        System.out.println("Худший студент: " + studanalyzer.worstStudent());
        System.out.println("\n=== Все студенты ===");
        studanalyzer.printAllStudents();
    }
}