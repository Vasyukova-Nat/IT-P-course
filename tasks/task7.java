package tasks;

import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ");
        int a = scanner.nextInt();
        int o = 1;
        for (int i = 2; i < a + 1; i++) {
            o = o * i;
        }
        System.out.println(o);
        scanner.close();
    }
}
