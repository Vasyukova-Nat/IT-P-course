package lab3;

import java.util.Arrays;

public class Main2_My {
    public static void main(String[] args) {
        N2OrderManager orderManager = new N2OrderManager();

        // Создаем заказы
        N2Order order1 = new N2Order(Arrays.asList("Товар1", "Товар2"), "Адрес 1", 100.50);
        N2Order order2 = new N2Order(Arrays.asList("Товар3"), "Адрес 2", 50.00);

        // Вставляем заказы
        orderManager.addOrder(1, order1);
        orderManager.addOrder(2, order2);

        // Поиск заказа
        N2Order searchedOrder = orderManager.getOrder(1);
        System.out.println("Найденный заказ: " + searchedOrder);

        // Удаление заказа
        N2Order removedOrder = orderManager.removeOrder(1);
        System.out.println("Удаленный заказ: " + removedOrder);

        // Попытка поиска удаленного заказа
        N2Order notFoundOrder = orderManager.getOrder(1);
        System.out.println("Заказ с номером 1 после удаления: " + notFoundOrder);
    }
}
