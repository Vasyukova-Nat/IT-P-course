//ticketSaler

package tasks;

import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 число ");
        int a = scanner.nextInt();
        System.out.print("Введите 2 число ");
        int b = scanner.nextInt();
        double commission = 0.28;
        System.out.println(ticketSaler(a, b, commission));
        scanner.close();
    }

    public static double ticketSaler(int a, int b, double commission) {
        return (double) (a * b) - (commission * a * b); // из условия следует комиссия 28%
    }
}
