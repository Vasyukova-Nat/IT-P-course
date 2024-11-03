package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTasks4 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String s1 = "aaaabbbbc";
        System.out.println(nonRepeat_inator(s1));

        System.out.println("\n" + "Task 2");
        int k = 2; // длина
        int n = 6; // алфавит
        System.out.println(bruteForce_inator(k, n));

        System.out.println("\n" + "Task 3");
        String s3 = "MTUCI";
        int[] l3 = { 0, 31, 28, 10, 29 };
        String key = "MKIIT";
        System.out.println(Arrays.toString(decode_inator(s3, key)));
        System.out.println(encode_inator(l3, key));

        System.out.println("\n" + "Task 4");
        String s4 = "((())())(()(()()))";
        System.out.println(split_inator(s4));

        System.out.println("\n" + "Task 5");
        String s5 = "abbccc";
        System.out.println(shortHand_inator(s5));

        System.out.println("\n" + "Task 6");
        int a6 = 52;
        System.out.println(convertToRome_inator(a6));

        System.out.println("\n" + "Task 7");
        String s7 = "1020132320";
        System.out.println(uniqueSubstring_inator(s7));

        System.out.println("\n" + "Task 8");
        int[][] m8 = {
                { 1, 3, 1 },
                { 1, -1, 1 },
                { 4, 2, 1 } };
        int[][] m8_2 = {
                { 2, -7, 3 },
                { -4, -1, 8 },
                { 4, 5, 9 }
        };
        //////// int n8 = 3;
        // System.out.println(labirint_inator(m8, n8 - 1, n8 - 1));
        System.out.println(labirint_inator(m8));

        System.out.println("\n" + "Task 9");
        String s9 = "re6sponsibility Wit1h gr5eat power3 4comes g2reat";
        System.out.println(Arrays.toString(numericOrder_inator(s9)));

        System.out.println("\n" + "Task 10");
        String s10 = "CCCABDD";
        System.out.println(fibString_inator(s10));

    }

    public static String nonRepeat_inator(String s) { // Task 1
        String o = "";
        for (int i = 0; i < s.length(); i++) {
            String symb = s.charAt(i) + "";
            int k = s.length() - s.replace(symb, "").length();
            if (k <= 3) {
                o += symb;
            }
        }

        if (o.equals(s)) { // если строка не меняется
            return o;
        } else {
            return nonRepeat_inator(o);
        }
    }

    public static List<String> bruteForce_inator(int k, int n) { // Task 2
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

    public static int[] decode_inator(String s, String key) { // Task 3.1
        int[] o = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int sym_s = s.charAt(i);
            int sym_key = key.charAt(i);
            o[i] = sym_s ^ sym_key;
        }
        return o;
    }

    public static String encode_inator(int[] l, String key) { // Task 3.2
        String o = "";
        for (int i = 0; i < l.length; i++) {
            int sym_l = l[i];
            int sym_key = key.charAt(i);
            o += (char) (sym_l ^ sym_key);
        }
        return o;
    }

    public static List<String> split_inator(String s) { // Task 4
        int c = 0;
        String so = "";
        List<String> o = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ("(".equals(s.charAt(i) + "")) {
                c += 1;
                so += s.charAt(i);
            } else if (")".equals(s.charAt(i) + "")) {
                c -= 1;
                so += s.charAt(i);
            }
            if (c == 0) {
                o.add(so);
                so = "";
            }
        }
        return o;
    }

    public static String shortHand_inator(String s) { // Task 5
        String o = "";
        int c = 0;
        Boolean F = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                c += 1;
                F = true;
            } else {
                if (!F) {
                    o += s.charAt(i);
                    c = 0;
                } else {
                    o += s.charAt(i) + "*" + (c + 1);
                    c = 0;
                    F = false;
                }
            }
        }
        if (!F) {
            o += s.charAt(s.length() - 1);
        } else {
            o += s.charAt(s.length() - 1) + "*" + (c + 1);
        }

        return o;
    }

    public static String convertToRome_inator(int a) { // Task 6 // L - 50, C - 100, D - 500, M - 1000
        String[] thousands = { "", "M", "MM", "MMM" };
        String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return (thousands[a / 1000] + hundreds[a % 1000 / 100] + tens[a % 100 / 10] + units[a % 10]);
    }

    public static String uniqueSubstring_inator(String s) { // Task 7
        String s_even = ""; // чёт
        String s_odd = ""; // нечёт
        for (int i = 0; i < s.length(); i += 2) {
            s_even += s.charAt(i);
            s_odd += s.charAt(i + 1);
        }

        int max_even = 0;
        String maxB_even = "";
        for (int i = 0; i < s_even.length(); i++) {
            int k = s_even.length() - s_even.replace(s_even.charAt(i) + "", "").length();
            if (k > max_even) {
                max_even = k;
                maxB_even = s_even.charAt(i) + "";
            }
        }
        int first_max_even = s_even.indexOf(maxB_even);

        int max_odd = 0;
        String maxB_odd = "";
        for (int i = 0; i < s_odd.length(); i++) {
            int k = s_odd.length() - s_odd.replace(s_odd.charAt(i) + "", "").length();
            if (k > max_odd) {
                max_odd = k;
                maxB_odd = s_odd.charAt(i) + "";
            }
        }
        int first_max_odd = s_odd.indexOf(maxB_odd);

        if (max_even > max_odd) {
            return "чёт";
        }
        if (max_even < max_odd) {
            return "нечёт";
        } else {
            if (first_max_even < first_max_odd) {
                return "чёт";
            } else {
                return "нечёт";
            }
        }
    }

    public static List<String> labirint_inator(int[][] matrix) { // Task 8
        int n = matrix.length;
        int[][] dp = new int[n][n];
        String[][] path = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                path[i][j] = "";
            }
        }

        if (matrix[n - 1][n - 1] >= 0) {
            dp[n - 1][n - 1] = matrix[n - 1][n - 1];
            path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0)
                    continue;

                if (i < n - 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
                    int cost = dp[i + 1][j] + matrix[i][j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        path[i][j] = path[i + 1][j] + "-" + matrix[i][j];
                    }
                }

                if (j < n - 1 && dp[i][j + 1] != Integer.MAX_VALUE) {
                    int cost = dp[i][j + 1] + matrix[i][j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        path[i][j] = path[i][j + 1] + "-" + matrix[i][j];
                    }
                }
            }
        }

        if (dp[0][0] == Integer.MAX_VALUE) {
            List<String> result = new ArrayList<>();
            result.add("Прохода нет");
            return result;
        } else {
            List<String> result = new ArrayList<>();
            result.add(path[0][0]);
            result.add(String.valueOf(dp[0][0]));
            return result;
        }
    }

    // public static String labirint_inator(int[][] m, int x, int y) {
    // String o = "";
    // System.out.println("NACHALO " + m[x][y]);
    // // System.out.println(labirint_inator(m, x, y - 1));
    // if ((x - 1 != -1) && (y - 1 != -1)) {
    // System.out.println("AAAAAAA " + labirint_inator(m, x, y - 1));
    // System.out.println("AAAAAAA " + labirint_inator(m, x - 1, y));
    // // return labirint_inator(m, x - 1, y);

    // } else {
    // System.out.println("Slomalsa");
    // }
    // return o;

    // }

    public static String[] numericOrder_inator(String s) { // Task 9
        String[] words = s.split(" ");
        String[] o = new String[words.length];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i))) {
                    o[Character.getNumericValue(word.charAt(i)) - 1] = word.replaceAll("[0-9]", "");

                }
            }
        }
        return o;
    }

    public static boolean fibString_inator(String str) { // Task 10.1
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            String symb = str.charAt(i) + "";
            int k = str.length() - str.replace(symb, "").length();
            if (k > 1) {
                maxCount = Math.max(maxCount, k);
            }
        }
        return isFibonacci(maxCount);
    }

    private static boolean isFibonacci(int n) { // Task 10.2
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b == n;
    }
}
