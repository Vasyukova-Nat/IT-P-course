package lab6;

import java.util.LinkedHashMap;
import java.util.Map;

public class n3_storeSales {
    private LinkedHashMap<String, Integer> salesMap;

    // Конструктор класса
    public n3_storeSales() {
        salesMap = new LinkedHashMap<>();
    } // создает новый экземпляр класса n3_storeSales и инициализирует карту
      // salesMap

    // Метод для добавления проданного товара
    public void addSale(String item, int count) {
        // salesMap.put(item, salesMap.getOrDefault(item, 0) + 1); // первая версия
        salesMap.put(item, salesMap.getOrDefault(item, 0) + count);
    }

    // Метод для вывода списка проданных товаров
    public void displaySales() {
        System.out.println("Проданные товары:");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        }
    }

    // Метод для подсчета общей суммы продаж и наиболее популярного товара
    public void displaySummary() {
        int totalSales = 0;
        String mostPopularItem = null;
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            totalSales += entry.getValue();
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopularItem = entry.getKey();
            }
        }

        System.out.println("Всего продаж: " + totalSales);
        if (mostPopularItem != null) {
            System.out.println("Наиболее популярный товар: " + mostPopularItem + " (" + maxSales + " раз(а))");
        }
    }
}
