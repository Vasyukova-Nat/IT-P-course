package tasks;

import java.util.ArrayList;
import java.util.List;

public class AllTasks4 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String s1 = "aaaabbbbc";
        System.out.println(nonRepeat_inator(s1));

        System.out.println("\n" + "Task 2");
        int k = 2; // длина
        int n = 6; // алфавит
        System.out.println(bruteForce(k, n));
    }

    public static String nonRepeat_inator(String s) {
        String o = "";
        for (int i = 0; i < s.length(); i++) {
            String symb = s.charAt(i) + "";
            int k = s.length() - s.replace(symb, "").length();
            if (k <= 3) {
                o += symb;
            }
        }
        // System.out.println("ОТВЕТ " + o);

        if (o.equals(s)) { // если строка не меняется
            return o;
        } else {
            return nonRepeat_inator(o);
        }
    }

    public static List<String> bruteForce(int k, int n) {
        List<String> o = new ArrayList<>();
        int[] counter = new int[k]; // список из k нулей
        boolean F = false; // флаг == break

        while (!F) {
            String s = "";
            for (int i = 0; i < k; i++) {
                if (s.indexOf(counter[i] + "") == -1) {
                    s += counter[i];
                } else {
                    s = "";
                    break;
                }
            }
            if (s.length() != 0) {
                o.add(s);
            }

            counter[k - 1]++; // последний символ

            for (int i = k - 1; i > 0 && counter[i] >= n; i--) { // переполнение, перенос.
                counter[i] = 0;
                counter[i - 1]++;
            }
            if (counter[0] >= n) { // достигли ли конца
                F = true;
            }
        }

        return o;
    }
}
