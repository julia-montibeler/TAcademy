package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class LogProcessor implements Callable<Integer> {
    private String logFilePath;
    private String wordToCount;

    public LogProcessor(String logFilePath, String wordToCount) {
        this.logFilePath = logFilePath;
        this.wordToCount = wordToCount;
    }

    @Override
    public Integer call() throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrences(line, wordToCount);
            }
        }
        return count;
    }

    private int countOccurrences(String line, String word) {
        int count = 0;
        int index = 0;
        while ((index = line.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}

