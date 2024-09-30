public class olymp1 {
    public static void main(String[] args) {
        for (int i = 600; i < 1000; i++) {
            int symbol1 = i / 100 % 10;
            int symbol2 = i / 10 % 10;
            int symbol3 = i % 10;
            // System.out.println(symbol1 + " " + symbol2 + " " + symbol3);
            if (i % 2 == 0) {
                if (((symbol1 - symbol2 == 1) || ((symbol1 - symbol2 == 3)))
                        && ((symbol2 - symbol3 == 1) || ((symbol2 - symbol3 == 3)))) {
                    System.out.println("Подходит " + i);
                }
            }
        }
    }
}
