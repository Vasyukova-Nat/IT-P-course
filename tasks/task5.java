//ternaryEvaluation

package tasks;

import java.util.Scanner;

public class task5 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число 1: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите число 2: ");
        int number2 = scanner.nextInt();

        System.out.println("Максимальное число: " + getMax(number1, number2));
        scanner.close();
    }

    public static int getMax(int a, int b) {
        return (a > b) ? a : b; // если a больше b, возвращаем a, иначе возвращаем b
    }
}
