package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

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
        int a6 = 4;
        System.out.println(VERSION2_bugger_inator(a6));

        System.out.println("\n" + "Task 7");
        List<Object[]> inventory = new ArrayList<>();
        inventory.add(new Object[] { "Скакалка", 550, 8 });
        inventory.add(new Object[] { "Шлем", 3750, 4 });
        inventory.add(new Object[] { "Мяч", 2900, 10 });
        System.out.println(mostExpensiveInator(inventory));

        System.out.println("\n" + "Task 8");
        String s8 = "abcbabcd";
        System.out.println("Дана строка " + s8 + ".\nОтвет: " + unique_inator(s8));

        System.out.println("\n" + "Task 9");
        String word = "retrospect";
        String s9 = "retro-";
        System.out.println("Дана строка " + word + " и " + s9
                + ".\nОтвет: isPrefix == " + isPrefix(word, s9)
                + " isSuffix == " + isSuffix(word, s9));

        System.out.println("\n" + "Task 10");
        // int[] a10 = { 1, 1, 1, 1, 1 };
        int a = 5;
        int b = 2;
        int c = 1;
        int w = 1;
        int h = 5;
        System.out.println(brick_inator(a, b, c, w, h));
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

    public static String rps_Inator(String p1, String p2) { // Task 5
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

    public static int VERSION1_bugger_inator(int a) { // НЕ ИСПОЛЬЗУЕМ, найден вариант оптимальнее
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
        // System.out.println(digits);
        return digits;
    }

    public static int multiplicationSplitInator(int a) { // Вспомогательный метод перемножения чисел списка
        List<Integer> digits = splitNumInator(a);
        int mult = 1;
        for (int digit : digits) {
            mult *= digit;
        }
        return mult;
    }

    public static int VERSION2_bugger_inator(int a) { // Task 6
        // Можем использовать как образец метод из Task4
        int k = 0;
        int mult = multiplicationSplitInator(a);
        if (mult > 9) {
            k += 1;
            while (mult > 9) {
                mult = multiplicationSplitInator(mult);
                k += 1;
            }
        }
        return k;
    }

    public static String mostExpensiveInator(List<Object[]> inventory) { // Task 7
        int maxCost = -1111111;
        String itemMax = "";
        for (Object[] item : inventory) {
            int cost = (int) item[1];
            int count = (int) item[2];
            if (cost * count > maxCost) {
                maxCost = cost * count;
                itemMax = (String) item[0];
            }
        }
        return "Наибольшая стоимость у предмета " + itemMax + " - " + maxCost;
    }

    // public static String unique_inator(String s) {
    // String o = "";
    // // HashSet<Character> o = new HashSet<>();
    // HashSet<Character> unique = new HashSet<>();
    // for (int i = 0; i < s.length(); i++) {
    // // o += s.charAt(i);
    // // o.add(s.charAt(i));
    // if (unique.contains(s.charAt(i))) {

    // } else if (i > 0 && (s.charAt(i) != s.charAt(i - 1))) {
    // unique.add(s.charAt(i));
    // o += s.charAt(i);
    // // o.add(s.charAt(i));
    // System.out.println(unique + " " + o);
    // }
    // }
    // return o;
    // }

    private static boolean uniqueSymbols(String str) { // Вспомог. метод определения уникальности всех символов в строке
        HashSet<Character> unique = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!unique.add(c)) {
                return false;
            }
        }
        return true;
    }

    // public static String unique_inator(String str) {
    // String longestSubstring = "";
    // for (int i = 0; i < str.length(); i++) {
    // for (int j = i + 1; j <= str.length(); j++) {
    // String substring = str.substring(i, j);
    // if (uniqueSymb(substring) && substring.length() > longestSubstring.length())
    // {
    // longestSubstring = substring;
    // }
    // }
    // }
    // return longestSubstring;
    // }

    public static String unique_inator(String s) { // Task 8
        String o = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("Отсчет уникальности пошел с символа '" + s.charAt(i) + "'
            // индекса " + i);

            for (int j = i; j < s.length(); j++) {
                // System.out.println("В проверяемую на уникальность строку вошел символ " +
                // s.charAt(j));
                temp += s.charAt(j);
                if ((uniqueSymbols(temp) == false) || (j == s.length() - 1)) {
                    // System.out.println("Цикл остановлен, temp в конце цикла " + temp);
                    if (temp.length() > o.length()) {
                        o = temp;
                    }
                    temp = "";
                    break;

                }
                // System.out.println("Темп в конце цикла " + temp);
                if (temp.length() > o.length()) {
                    o = temp;
                }
            }

        }
        return o;
    }

    public static boolean isPrefix(String word, String s) { // Task 9-1
        String wordPart = word.substring(0, s.length() - 1);
        String sPart = s.substring(0, s.length() - 1);
        return wordPart.equals(sPart);
    }

    public static boolean isSuffix(String word, String s) { // Task 9-2
        String wordPart = word.substring(word.length() - (s.length() - 1), word.length());
        String sPart = s.substring(1, s.length());
        // System.out.println(wordPart + " " + sPart);
        return wordPart.equals(sPart);
    }

    public static boolean brick_inator(int a, int b, int c, int w, int h) { // Task 10
        if (a * b <= w * h || b * c <= w * h || a * c <= w * h) {
            return true;
        }
        return false;
    }
}
