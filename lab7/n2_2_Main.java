package lab7;

import java.util.concurrent.*;

public class n2_2_Main {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int numThreads = 4; // кол-во потоков
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<Integer>[] futures = new Future[numThreads];

        int rowsPerThread = matrix.length / numThreads;

        // создаем задачи для каждого потока
        for (int i = 0; i < numThreads; i++) {
            final int startRow = i * rowsPerThread;
            final int endRow = (i == numThreads - 1) ? matrix.length : startRow + rowsPerThread;

            futures[i] = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    int max = Integer.MIN_VALUE;
                    for (int r = startRow; r < endRow; r++) {
                        for (int c = 0; c < matrix[r].length; c++) {
                            if (matrix[r][c] > max) {
                                max = matrix[r][c];
                            }
                        }
                    }
                    return max;
                }
            });
        }

        executor.shutdown(); // executor закрывается

        int o = -1000000000; // или 2-й способ: int o = Integer.MIN_VALUE;
        for (int i = 0; i < numThreads; i++) {
            try {
                int maxInPart = futures[i].get();
                if (maxInPart > o) {
                    o = maxInPart;
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Ошибка InterruptedException или ExecutionException");
            }
        }

        System.out.println("Наибольший элемент в матрице: " + o);
    }
}
