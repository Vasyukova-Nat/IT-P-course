package tasks;

class a {
    public static void main(String[] args) {
        int n = 3; // Пример значения n
        nestedLoops(n);
    }

    public static void nestedLoops(int n) {
        int[] counters = new int[n]; // список из n нулей
        boolean finished = false;

        while (!finished) {
            // System.out.println("ТУТТТТТТ for1");
            for (int i = 0; i < n; i++) {
                System.out.print(counters[i] + " ");
            }
            System.out.println();

            counters[n - 1]++; // последний символ

            // System.out.println("ТУТТТТТТ for2");
            for (int i = n - 1; i > 0 && counters[i] >= n; i--) { // перенос переполнения
                counters[i] = 0;
                counters[i - 1]++;
            }

            if (counters[0] >= n) { // достигли ли конца
                finished = true;
            }
        }

    }

}
