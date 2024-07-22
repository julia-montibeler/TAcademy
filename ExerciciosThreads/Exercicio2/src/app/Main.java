package app;

import model.ParallelLogProcessor;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        List<String> logFiles = List.of("log1.txt", "log2.txt", "log3.txt");
        String wordToCount = "Error";

        ParallelLogProcessor parallelProcessor = new ParallelLogProcessor(3);

        try {
            int totalOccurrences = parallelProcessor.processLogs(logFiles, wordToCount);
            System.out.println("Total occurrences of the word '" + wordToCount + "': " + totalOccurrences);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            parallelProcessor.shutdown();
        }
    }
}
