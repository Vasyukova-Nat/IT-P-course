package lab6;

import java.util.Scanner;

public class n3_main {
    public static void main(String[] args) {
        n3_storeSales counter = new n3_storeSales();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println(
                "Выберите команду: \n 1. add / добавить товар \n 2. display / показать товары \n 3. exit / выход \nВведите число без точки:");

        while (true) {
            command = scanner.nextLine().trim();
            if (command.equals("1")) {
                System.out.println("Введите название товара и количество продаж через пробел:");
                // String item = scanner.nextLine().trim();
                String item_count = scanner.nextLine();
                String[] parts = item_count.split(" ");
                String item = parts[0].trim();
                int count = Integer.parseInt(parts[1].trim());
                counter.addSale(item, count);
                System.out.println("Товар добавлен.");
            } else if (command.equals("2")) {
                counter.displaySales();
                counter.displaySummary();
            } else if (command.equals("3")) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Неизвестная команда. Пожалуйста, попробуйте снова.");
            }
        }

        scanner.close();
    }
}
