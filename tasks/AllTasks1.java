package tasks;

public class AllTasks1 {
    public static void main(String[] args) { // убрать String[] args нельзя, т.к. это стандартная сигнатура для метода
                                             // main

        System.out.println("\n" + "Task 1");
        int[] gallon_m = { 5, 3, 8 };
        for (int i = 0; i < gallon_m.length; i++) {
            System.out.println("В переводе в литры " + gallon_m[i] + " галлонов будет " + convert(gallon_m[i]));
        }

        System.out.println("\n" + "Task 2");
        int[] t_m = { 15, 24, 41 };
        int[] intensity_m = { 1, 2, 3 };
        for (int i = 0; i < t_m.length; i++) {
            System.out.println(t_m[i] + " и " + intensity_m[i] + " будет " + fitCalc(t_m[i], intensity_m[i]));
        }

        System.out.println("\n" + "Task 3");
        int[] a1_m = { 3, 5, 4 };
        int[] a2_m = { 4, 0, 1 };
        int[] a3_m = { 2, 2, 4 };
        for (int i = 0; i < a1_m.length; i++) {
            System.out.println(a1_m[i] + " коробок " + a2_m[i] + " мешков " + a2_m[i] + " бочек. Ответ: "
                    + containers(a1_m[i], a2_m[i], a3_m[i]));
        }

        System.out.println("\n" + "Task 4");
        int[] x_m = { 5, 5, 3, 5 };
        int[] y_m = { 5, 4, 4, 1 };
        int[] z_m = { 5, 5, 5, 1 };
        for (int i = 0; i < x_m.length; i++) {
            System.out
                    .println(x_m[i] + " " + y_m[i] + " " + z_m[i] + " Ответ: " + triangleType(x_m[i], y_m[i], z_m[i]));
        }

        System.out.println("\n" + "Task 5");
        int[] a_m = { 8, 1, 5 };
        int[] b_m = { 4, 11, 9 };
        for (int i = 0; i < a_m.length; i++) {
            System.out.println(a_m[i] + " " + b_m[i] + " Ответ: " + getMax(a_m[i], b_m[i]));
        }

        System.out.println("\n" + "Task 6");
        double[] n_m = { 22, 45, 100 };
        double[] w_m = { 1.4, 1.8, 2 };
        double[] h_m = { 2, 1.9, 2 };
        for (int i = 0; i < n_m.length; i++) {
            System.out
                    .println(n_m[i] + " " + w_m[i] + " " + h_m[i] + " Ответ: " + howManyItems(n_m[i], w_m[i], h_m[i]));
        }

        System.out.println("\n" + "Task 7");
        int[] af_m = { 3, 5, 7 };
        for (int i = 0; i < a_m.length; i++) {
            System.out.println("Факториал числа " + af_m[i] + " равен " + factorial(af_m[i]));
        }

        System.out.println("\n" + "Task 8");
        int[] a_gcd_m = { 48, 52, 259 };
        int[] b_gcd_m = { 18, 8, 28 };
        for (int i = 0; i < a_gcd_m.length; i++) {
            System.out.println(a_gcd_m[i] + " " + b_gcd_m[i] + " Ответ: " + gcd(a_gcd_m[i], b_gcd_m[i]));
        }

        System.out.println("\n" + "Task 9");
        int[] tickets_m = { 70, 24, 53 };
        int[] sold_m = { 1500, 950, 1250 };
        double commission = 0.28;
        for (int i = 0; i < sold_m.length; i++) {
            System.out.println(
                    tickets_m[i] + " " + sold_m[i] + " Ответ: " + ticketSaler(tickets_m[i], sold_m[i], commission));
        }

        System.out.println("\n" + "Task 10");
        int[] students_m = { 5, 31, 123 };
        int[] tables_m = { 2, 20, 58 };
        for (int i = 0; i < students_m.length; i++) {
            System.out.println(students_m[i] + " " + tables_m[i] + " Ответ: " + tables(students_m[i], tables_m[i]));
        }
    }

    public static double convert(double a) {
        return a * 3.785;
    }

    public static int fitCalc(int t, int intensity) {
        return t * intensity;
    }

    public static int containers(int a1, int a2, int a3) {
        return (a1 * 20 + a2 * 50 + a3 * 100);
    }

    public static String triangleType(int x, int y, int z) {
        int maxn = Math.max(x, Math.max(y, z));
        if (maxn < (x + y + z - maxn)) {
            if ((x == y) & (y == z)) { // здесь может быть и &&
                return "equilateral"; // равносторонний
            } else if ((x == y) || (y == z) || (x == z)) {
                return "isosceles"; // равнобедренный
            } else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    public static int getMax(int a, int b) {
        return (a > b) ? a : b; // если a больше b, возвращаем a, иначе возвращаем b
    }

    public static int howManyItems(double n, double w, double h) {
        return (int) ((n * 2.0) / (w * h));
    }

    public static int factorial(int a) {
        int o = 1;
        for (int i = 2; i < a + 1; i++) {
            o = o * i;
        }
        return o;
    }

    public static int gcd(int a, int b) {
        int maxn = (int) Math.max(a, b);
        int minn = (int) Math.min(a, b);
        int temp = maxn % minn;
        while (temp > 0) {
            maxn = minn;
            minn = temp;
            temp = maxn % minn;
        }
        return minn;
    }

    public static double ticketSaler(int a, int b, double commission) {
        return (double) (a * b) - (commission * a * b); // из условия следует комиссия 28%
    }

    public static int tables(int students, int tables) {
        if (students <= tables * 2) {
            return 0;
        } else {
            int students_remain = students % (tables * 2);
            int o = (int) Math.ceil((double) students_remain / 2);
            return o;
        }
    }
}
