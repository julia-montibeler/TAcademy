package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelLogProcessor {
    private ExecutorService executorService;

    public ParallelLogProcessor(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    public int processLogs(List<String> logFiles, String wordToCount) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();

        for (String logFile : logFiles) {
            LogProcessor processor = new LogProcessor(logFile, wordToCount);
            futures.add(executorService.submit(processor));
        }

        int totalOccurrences = 0;
        for (Future<Integer> future : futures) {
            totalOccurrences += future.get();
        }

        return totalOccurrences;
    }

    public void shutdown() {
        executorService.shutdown();
    }
}