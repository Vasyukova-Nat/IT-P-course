package tasks;

import java.util.ArrayList;
import java.util.List;

public class AllTasks5 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String s1 = "FFFF";
        String s2 = "ABCD";
        System.out.println(sameLetterPattern(s1, s2));

        System.out.println("\n" + "Task 2");
        System.out.println(memeSum(26, 39));

        System.out.println("\n" + "Task 3");
        System.out.println(digitsCount(0, 1289396387328L));
        System.out.println(digitsCount2(1289396387328L));
    }

    public static List<Integer> positions(String s, char a) { // вспомогательный метод для Task1
        List<Integer> symbols = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == a) {
                symbols.add(i);
            }
        return symbols;
    }

    public static boolean sameLetterPattern(String s1, String s2) { // Task1
        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            List<Integer> l1 = positions(s1, s1.charAt(i));
            List<Integer> l2 = positions(s2, s2.charAt(i));
            if (!l1.equals(l2)) {
                flag = false;
            }
        }
        return flag;
    }

    public static String memeSum(int a, int b) { // Task 2
        // просьба ставить более длинное число в переменную a12
        String o = "";

        String as = String.valueOf(a);
        String bs = String.valueOf(b);

        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        if (as.length() >= bs.length()) {
            while (a != 0) {
                al.add(0, a % 10); // добавляем цифры в начало списка
                a /= 10;
            }

            while (b != 0) {
                bl.add(0, b % 10); // добавляем цифры в начало списка
                b /= 10;
            }
            for (int i = 0; i < as.length() - bs.length(); i++) {
                bl.add(0, 0); // добавляем ноль в начало списка
            }
        }

        for (int i = 0; i < al.size(); i++) {
            o += (al.get(i) + bl.get(i));
        }

        return o;
    }

    public static int digitsCount(int o, long a) { // Task 3 усложненная версия
        if (a < 10)
            return o + 1;
        o += 1;
        return digitsCount(o, a / 10);
    }

    public static int digitsCount2(long a) { // Task 3 упрощенная версия
        if (a < 10)
            return 1;
        return 1 + digitsCount2(a / 10);
    }
}
