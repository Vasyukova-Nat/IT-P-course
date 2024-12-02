package lab7;

import java.util.concurrent.*;

public class n1_2_Main {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int numThreads = 4; // кол-во потоков
        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // создаётся пул потоков с кол-вом потоков
                                                                             // numThreads
        Future<Integer>[] futures = new Future[numThreads]; // создаётся массив объектов Future, который будет хранить
                                                            // рез-ты выполнения задач. Каждый элемент массива
                                                            // - одна задача.

        int chunkSize = array.length / numThreads; // размер блока данных, который будет обрабатывать каждый поток. Это
                                                   // длина массива / кол-во потоков.

        // Создаются задачи для каждого потока
        for (int i = 0; i < numThreads; i++) { // по кол-ву потоков
            int start = i * chunkSize;

            int end = (i == numThreads - 1) ? array.length : start + chunkSize;
            futures[i] = executor.submit(new n1_2_arraySum(array, start, end));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) { // проходит по всем задачам (элементы Future) и собирает рез-ты
                                                 // выполнения
            try {
                totalSum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Ошибка InterruptedException или ExecutionException");
            }
        }

        executor.shutdown(); // ожидает завершения выполнения задач
        System.out.println("Итоговая сумма: " + totalSum);
    }
}