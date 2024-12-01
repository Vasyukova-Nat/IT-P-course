package lab7;

import java.util.*;

public class n3_7_Main {
    // public static List<Integer> products = new ArrayList<>();
    public static Map<String, Integer> products = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        // products.add(21);
        // products.add(103);
        // products.add(14);
        // products.add(24);
        // products.add(25);
        // products.add(22);
        // products.add(15);
        // products.add(16);
        // products.add(12);
        // products.add(17);
        products.put("Гиря", 21);
        products.put("Бананы", 12);
        products.put("Мешок", 14);
        products.put("Ящик1", 24);
        products.put("Ящик2", 25);
        products.put("Мешок1", 12);
        products.put("Мешок2", 10);
        products.put("Мешок3", 2);
        products.put("Мешок4", 49);
        products.put("Мешок5", 51);
        products.put("Мешок6", 6);
        products.put("Мешок7", 5);

        // Создаем 3 потока
        Thread loader1 = new Thread(new n3_7_loaders.Loader(), "Грузчик-1");
        Thread loader2 = new Thread(new n3_7_loaders.Loader(), "Грузчик-2");
        Thread loader3 = new Thread(new n3_7_loaders.Loader(), "Грузчик-3");

        // Запускаем потоки
        loader1.start();
        loader2.start();
        loader3.start();

        // Ожидаем завершения всех потоков
        loader1.join();
        loader2.join();
        loader3.join();

        System.out.println("Мяу");
    }
}
