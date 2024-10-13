package tasks;

import java.util.ArrayList;
import java.util.List;

public class AllTasks3 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String s11 = "";
        String s12 = "";
        System.out.println(isStrangeInator(s11, s12));

        System.out.println("\n" + "Task 2");
        List<Object[]> products = new ArrayList<>();
        products.add(new Object[] { "Laptop", 124200 });
        products.add(new Object[] { "Phone", 51450 });
        products.add(new Object[] { "Headphones", 13800 });
        int discount = 25;
        for (Object[] item : sale_inator(products, discount)) {
            System.out.println(item[0] + " " + item[1]);
        }

        System.out.println("\n" + "Task 3");
        int x = -2;
        int y = -3;
        int r = 4;
        int xHit = 5;
        int yHit = -6;
        System.out.println(ShootInator(x, y, r, xHit, yHit));

        System.out.println("\n" + "Task 4");
        int a4 = 243;
        System.out.println(parity_inator(a4));

        System.out.println("\n" + "Task 5");
        String p1 = "paper";
        String p2 = "scissors";
        System.out.println(rps_Inator(p1, p2));

        System.out.println("\n" + "Task 6");
        int a6 = 39;
        System.out.println(VERSION2_bugger_inator(a6));
    }

    public static Boolean isStrangeInator(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        } else if ((s1.length() == 0 && s2.length() != 0) || (s1.length() != 0 && s2.length() == 0)) {
            return false;
        } else if ((s1.charAt(0) == s2.charAt(s2.length() - 1)) && (s1.charAt(s1.length() - 1) == s2.charAt(0))) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Object[]> sale_inator(List<Object[]> products, int discount) {
        List<Object[]> o = new ArrayList<>();
        for (Object[] item : products) {
            Object productName = item[0];
            double productPreviousCost = (double) (int) item[1];
            double percent = (1 - (double) discount / 100);
            Object productNewCost = Math.max(Math.round(productPreviousCost * percent), 1);
            o.add(new Object[] { productName, productNewCost });
        }
        return o;
    }

    public static Boolean ShootInator(int x, int y, int r, int xh, int yh) {
        int sx = Math.abs(xh - x); // расстояние по координате x
        int sy = Math.abs(yh - y); // расстояние по координате y
        double s = Math.round(Math.sqrt(Math.pow(sx, 2) + Math.pow(sy, 2))); // расстояние от попадания до центра мишени
        if (s > r) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean parity_inator(int a) {
        // List<Integer> nums = new ArrayList<>(); // Можно было внести все цифры числа
        // в список, но в этом таске нам нужна всего лишь сумма
        int sum = 0;
        int aCopy = a;
        while (aCopy > 0) {
            sum += aCopy % 10; // nums.add(a % 10);
            aCopy /= 10;
        }
        // Collections.reverse(nums); // Перевернем. Пригодится для будущего
        // использования.

        boolean pA = a % 2 == 0;
        boolean pSum = sum % 2 == 0;
        return pA == pSum;
    }

    public static String rps_Inator(String p1, String p2) {
        if (p1 == p2) {
            return "Tie";
        }
        if ((p1 == "rock" && p2 == "scissors") || (p1 == "scissors" && p2 == "paper")
                || (p1 == "paper" && p2 == "rock")) {
            return "Player 1 wins";
        } else {
            return "Player 2 wins";
        }
    }

    public static int VERSION1_bugger_inator(int a) {
        int x = 1;
        while (a > 0) {
            System.out.println("Умножаем " + x + " " + a % 10);
            x *= a % 10;
            a = a / 10;
        }
        int k = 0;
        int x1 = 1;
        if (x > 9) {
            k = 1;
            while (x > 9) {
                x1 = 1;
                System.out.println("в while идёт x " + x);
                while (x > 0) {
                    System.out.println("Умножаем " + x1 + " на " + x % 10);
                    x1 *= x % 10;
                    x = x / 10;
                }
                x = x1;
                k += 1;
                System.out.println("после while " + x);
            }
        }
        return k;
    }

    public static List<Integer> splitNumInator(int a) { // Вспомогательный метод выделения цифр числа
        List<Integer> digits = new ArrayList<>();
        while (a > 0) {
            digits.add(a % 10);
            a /= 10;
        }
        System.out.println(digits);
        return digits;
    }

    public static int VERSION2_bugger_inator(int a) { // Можем использовать как образец метод из Task4
        int k = 0;
        // int[] digits = {};
        List<Integer> digits = splitNumInator(a);

        int mult = 1;
        // while (mult > 9) {

        // }
        for (int digit : digits) {
            mult *= digit;
        }
        return k;
    }
}
