// GitHub: https://github.com/Vasyukova-Nat/IT-P-course.git

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
        double[] m4 = { 3.5, 7, 1.5, 9.0, 5.5 };
        System.out.println("Ответ: " + Arrays.toString(normalizatorinator(m4)));

        System.out.println("\n" + "Task 5");
        double[] m5 = { 1.6, 0, 212.3, 34.8, 0, 27.5 };
        System.out.println("Ответ: " + compressedNums_inator(m5));

        System.out.println("\n" + "Task 6");
        String str = "helloWorld";
        System.out.println("Для " + str + " ответ: " + camelToSnake_inator(str));

        System.out.println("\n" + "Task 7");
        int[] m6 = { 3, 5, 8, 1, 2, 4 };
        System.out.println("Для " + Arrays.toString(m6) + " ответ: " + secondBiggest_inator(m6));

        System.out.println("\n" + "Task 8");
        // String str6 = "baobab";
        String str6 = "Hello, I'm under the water, please help me"; // String str6 =
        // "baeobimnbzedbv";
        String markerSymbol = "e";
        System.out.println("Для " + str6 + " ответ: \n" + localReverse_inator(str6, markerSymbol));

        System.out.println("\n" + "Task 9");
        int a8 = 1;
        int b8 = 1;
        int c8 = 0;
        System.out.println("Для " + a8 + " " + b8 + " " + c8 + " ответ: " + equalinator(a8, b8, c8));

        System.out.println("\n" + "Task 10");
        String a10 = "Eleven plus two?";
        String b10 = "Twelve plus one!";
        System.out.println("Для '" + a10 + "' и '" + b10 + "' ответ: " + isAnagramInator(a10, b10));
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

    public static double[] normalizatorinator(double[] m) {
        double[] o = new double[m.length];
        double maxn = Arrays.stream(m).max().orElse(Double.NaN);
        double minn = Arrays.stream(m).min().orElse(Double.NaN);

        for (int i = 0; i < m.length; i++) {
            o[i] = (m[i] - minn) / (maxn - minn);
        }

        return o;
    }

    public static String compressedNums_inator(double[] m) {
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

    public static String camelToSnake_inator(String s) {
        String o = "";
        for (int i = 0; i < s.length(); i++) {
            String symbol = "" + s.charAt(i); // тут преобразуем в строку длиной 1. Либо можно
                                              // Character.toUpperCase(s.charAt(i)); - класс Character
            if (symbol == symbol.toUpperCase()) {
                o += "_" + symbol.toLowerCase();
            } else {
                o += symbol;
            }
        }
        return o;
    }

    public static int secondBiggest_inator(int[] m6) {
        // int[] copy = m6.clone();
        Arrays.sort(m6);
        return m6[m6.length - 2];
    }

    public static String localReverse_inator(String s, String marker) {
        String o = "";
        int markerCount = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != marker.charAt(0)) {
                if ((markerCount != 1)) {
                    temp += "" + s.charAt(i);
                } else {
                    temp = "" + s.charAt(i) + temp;
                }
            } else {
                o += temp + marker;
                temp = "";
                if (markerCount == 2) {
                    markerCount = 1;
                } else {
                    markerCount += 1;
                }
            }
        }
        o += temp;
        return o;
    }

    public static int equalinator(int a, int b, int c) {
        int o = 0;
        if (a == b && b == c) {
            o = 3;
        } else if (a == b || b == c || a == c) {
            o = 2;
        }
        return o;
    }

    public static Boolean isAnagramInator(String a, String b) {
        String alphabet = "[^a-z]";
        char[] arrayA = a.toLowerCase().replaceAll(alphabet, "").toCharArray(); // .toLowerCase должен быть раньше
                                                                                // .replaceAll(alphabet, иначе маска
                                                                                // пропускает заглавные символы
        Arrays.sort(arrayA);
        char[] arrayB = b.toLowerCase().replaceAll(alphabet, "").toCharArray();
        Arrays.sort(arrayB);
        // System.out.println(Arrays.toString(arrayA) + " " + Arrays.toString(arrayB));
        return Arrays.equals(arrayA, arrayB);

    }
}