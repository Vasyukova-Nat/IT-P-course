package lab7;

import java.util.Random;

public class n2_1_Main {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 9 }, { 7, 8, 3 } };
        int rows = matrix.length; // строк
        int cols = matrix[0].length; // столбцов

        // создание матрицы через рандом
        // int rows = 5;
        // int cols = 5;
        // int[][] matrix = new int[rows][cols];
        // Random random = new Random();
        // int[][] matrix = new int[rows][cols];
        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < cols; j++) {
        // matrix[i][j] = random.nextInt(100); // от 0 до 99
        // }
        // }

        System.out.println("Матрица:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        n2_1_matrixMax[] threads = new n2_1_matrixMax[rows];
        for (int i = 0; i < rows; i++) {
            threads[i] = new n2_1_matrixMax(matrix[i]); // создание потоков
            threads[i].start(); // запуск потоков
        }

        int o = -1000000000; // или 2-й способ: int o = Integer.MIN_VALUE;
        System.out.println(o);
        try {
            for (n2_1_matrixMax thread : threads) {
                thread.join(); // ожидание завершения каждого потока
                o = Math.max(o, thread.getMaxElement());
            }
        } catch (InterruptedException e) {
            System.err.println("Ошибка InterruptedException");
        }

        System.out.println("Макс элемент: " + o);
    }
}
