// fitCalc

package tasks;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите время тренировки (мин): ");
        int t = scanner.nextInt();

        System.out.print("Введите интенсивность (от 1 до 3): ");
        int b = scanner.nextInt();
        System.out.println("Сожжено калорий " + t * b);

        scanner.close();
    }
}
