// containers

package tasks;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во коробок: ");
        int a1 = scanner.nextInt();
        System.out.print("Введите кол-во мешков: ");
        int a2 = scanner.nextInt();
        System.out.print("Введите кол-во бочек: ");
        int a3 = scanner.nextInt();

        System.out.println("" + (a1 * 20 + a2 * 50 + a3 * 100));
        scanner.close();
    }

}
