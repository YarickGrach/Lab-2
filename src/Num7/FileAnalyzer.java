package Num7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileAnalyzer {

    public static class AnalysisResult {
        private int lineCount;
        private int wordCount;
        private int charCount;

        public AnalysisResult(int lineCount, int wordCount, int charCount) {
            this.lineCount = lineCount;
            this.wordCount = wordCount;
            this.charCount = charCount;
        }

        public int getLineCount() { return lineCount; }
        public int getWordCount() { return wordCount; }
        public int getCharCount() { return charCount; }

        @Override
        public String toString() {
            return String.format("Строк: %d\nСлов: %d\nСимволов: %d",
                    lineCount, wordCount, charCount);
        }
    }

    public AnalysisResult analyze(String filename) {
        try {
            Path filePath = Paths.get(filename);

            if (!Files.exists(filePath)) {
                System.out.println("Файл не найден!");
                return null;
            }

            List<String> lines = Files.readAllLines(filePath);

            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }

                for (char c : line.toCharArray()) {
                    if (c != ' ' && c != '\t' && c != '\n' && c != '\r') {
                        charCount++;
                    }
                }
            }

            return new AnalysisResult(lineCount, wordCount, charCount);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }

    public void analyzeAndPrint(String filename) {
        AnalysisResult result = analyze(filename);
        if (result != null) {
            System.out.println(result);
        }
    }
}
