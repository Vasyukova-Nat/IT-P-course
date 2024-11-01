package tasks;

import java.util.ArrayList;
import java.util.List;

class a2 {
    public static void main(String[] args) {
        int k = 2; // длина
        int n = 6; // алфавит
        System.out.println(bruteForce(k, n));
    }

    public static List<String> bruteForce(int k, int n) {
        List<String> o = new ArrayList<>();
        int[] counter = new int[k]; // список из k нулей
        boolean F = false; // флаг == break

        while (!F) {
            // System.out.println("ТУТТТТТТ for1");
            String s = "";
            for (int i = 0; i < k; i++) {
                if (s.indexOf(counter[i] + "") == -1) {
                    // System.out.println("не найден " + counter[i] + " В " + s);
                    s += counter[i];
                } else {
                    // System.out.println("BREAK " + s);
                    s = "";
                    break;
                }
            }
            // System.out.println("ТЕПЕРЬ СТРОКА " + s);
            if (s.length() != 0) {
                o.add(s);
            }

            // System.out.println("ПРОШЁЛ ПЕРВЫЙ ЦИКЛ");

            counter[k - 1]++; // последний символ

            // System.out.println("ТЕПЕРЬ " + counter[0] + counter[1] + counter[2]);
            for (int i = k - 1; i > 0 && counter[i] >= n; i--) { // переполнение, перенос.
                // i > 0 && counters[i] >= n - это условия выполнения цикла
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
