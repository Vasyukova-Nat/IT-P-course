package tasks;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Введите длину ткани (в метрах), ширину детали (в метрах) и длину детали (в метрах) через пробел:");

        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        double n = Double.parseDouble(numbers[0]);
        double a2 = Double.parseDouble(numbers[1]);
        double a3 = Double.parseDouble(numbers[2]);

        System.out.println("Можно сшить " + howManyItems(n, a2, a3));
        scanner.close();
    }

    public static int howManyItems(double n, double w, double h) {
        return (int) ((n * 2.0) / (w * h));
    }
}
