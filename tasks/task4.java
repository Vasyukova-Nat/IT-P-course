// triangleType

package tasks;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 3 стороны, разделяя их пробелом: ");
        String input = scanner.nextLine(); // Читаем всю строку ввода
        String[] numbers = input.split(" "); // Разбиваем строку на части по пробелам
        int x = Integer.parseInt(numbers[0]); // Преобразуем строки в целые числа
        int y = Integer.parseInt(numbers[1]);
        int z = Integer.parseInt(numbers[2]);

        int maxn = Math.max(x, Math.max(y, z));
        if (maxn < (x + y + z - maxn)) {
            if ((x == y) & (y == z)) { // здесь может быть и &&
                System.out.print("equilateral"); // равносторонний
            } else if ((x == y) || (y == z) || (x == z)) {
                System.out.print("isosceles"); // равнобедренный
            } else {
                System.out.print("different-sided");
            }
        } else {
            System.out.print("not a triangle");
        }

        scanner.close();
    }
}
