package lab3;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        // Создаем заказы
        Order order1 = new Order(Arrays.asList("Товар1", "Товар2"), "Адрес 1", 100.50);
        Order order2 = new Order(Arrays.asList("Товар3"), "Адрес 2", 50.00);

        // Вставляем заказы
        orderManager.addOrder(1, order1);
        orderManager.addOrder(2, order2);

        // Поиск заказа
        Order searchedOrder = orderManager.getOrder(1);
        System.out.println("Найденный заказ: " + searchedOrder);

        // Удаление заказа
        Order removedOrder = orderManager.removeOrder(1);
        System.out.println("Удаленный заказ: " + removedOrder);

        // Попытка поиска удаленного заказа
        Order notFoundOrder = orderManager.getOrder(1);
        System.out.println("Заказ с номером 1 после удаления: " + notFoundOrder);
    }
}
