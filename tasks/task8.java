//gcd

package tasks;

import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1 число ");
        int a = scanner.nextInt();
        System.out.print("Введите 2 число ");
        int b = scanner.nextInt();
        int maxn = (int) Math.max(a, b);
        int minn = (int) Math.min(a, b);
        int temp = maxn % minn;
        while (temp > 0) {
            maxn = minn;
            minn = temp;
            temp = maxn % minn;
        }

        System.out.println("НОД " + minn);
        scanner.close();
    }
}
