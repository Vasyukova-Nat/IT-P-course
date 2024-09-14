//tables

package tasks;

import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 число ");
        int a = scanner.nextInt();
        System.out.print("Введите 2 число ");
        int b = scanner.nextInt();
        if (a <= b * 2) {
            System.out.println(0);
        } else {
            int students_remain = a % (b * 2);
            int o = (int) Math.ceil((double) students_remain / 2);
            System.out.println(o);
        }
        scanner.close();
    }
}
