package lab7;

import java.util.concurrent.*;

public class n1_2_Main {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int numThreads = 4; // кол-во потоков
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<Integer>[] futures = new Future[numThreads];

        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : start + chunkSize;
            futures[i] = executor.submit(new n1_2_arraySum(array, start, end));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Ошибка InterruptedException или ExecutionException");
            }
        }

        executor.shutdown();
        System.out.println("Итоговая сумма: " + totalSum);
    }
}