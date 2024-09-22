package tasks;

import java.util.Arrays;

public class AllTasks2 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        String[] s1 = { "Barack", "Obama" };
        System.out.println(duplicateChars(s1[0], s1[1]));

        System.out.println("\n" + "Task 2");
        int[] a = { 2, 1, 5, 9, 7, 12, 15 };
        System.out.println("Ответ: " + dividedByThree(a));

        System.out.println("\n" + "Task 3");
        String b1 = "simonov sergei evgenievich";
        String b2 = "kozhevnikova tatiana vitalevna";
        System.out.println("Ответ: " + getInitials(b1) + " и " + getInitials(b2));

        System.out.println("\n" + "Task 4");
        double[] m4 = { 3.5, 7.0, 1.5, 9.0, 5.5 };
        System.out.println("Ответ: " + Arrays.toString(normalizator(m4)));

        System.out.println("\n" + "Task 5");
        double[] m5 = { 1.6, 0, 212.3, 34.8, 0, 27.5 };
        System.out.println("Ответ: " + compressedNums(m5));
    }

    public static String duplicateChars(String s1, String s2) {
        String o = "";
        for (int i = 0; i < s1.length(); i++) {
            String symbol = "" + s1.charAt(i);
            // String symbol = s1.charAt(i); не работает из-за типов данных
            // symbol — это объект типа char
            // String symbol = String.valueOf(s1.charAt(i)); работает при помощи метода
            // valueOf, который переводит разные типы данных в строку.

            if (s2.toLowerCase().indexOf(symbol.toLowerCase()) == -1) { // indexOf возвращает индекс первого символа
                                                                        // в строке, если символ найден; если
                                                                        // символ не найден, метод возвращает -1.
                o += symbol;
            }
        }
        return o;
    }

    public static int dividedByThree(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] % 2 != 0) & (a[i] % 3 == 0)) {
                count += 1;
                System.out.println(a[i]);
            }
        }
        return count;
    }

    public static String getInitials(String a) {
        String[] splitS = a.split(" ");
        String surname = splitS[0];
        String name = splitS[1];
        String patronymic = splitS[2];

        String N = "" + name.charAt(0);
        String P = "" + patronymic.charAt(0);
        String S = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
        return (N.toUpperCase() + "." + P.toUpperCase() + ". " + S);
    }

    public static double[] normalizator(double[] m) {
        double[] o = new double[m.length];

        double maxn = Arrays.stream(m).max().orElse(Double.NaN);
        double minn = Arrays.stream(m).min().orElse(Double.NaN);

        for (int i = 0; i < m.length; i++) {
            o[i] = (m[i] - minn) / (maxn - minn);
        }

        return o;
    }

    public static String compressedNums(double[] m) {
        Arrays.sort(m);
        System.out.println("Дано: " + Arrays.toString(m));

        int count0 = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] == 0)
                count0++;
        }

        int[] o = new int[m.length - count0];

        for (int i = count0; i < m.length; i++) {
            o[i - count0] = (int) m[i];
        }
        // System.out.println(Arrays.toString(o));

        return Arrays.toString(o);
    }
}