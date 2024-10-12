// Вариант 7

package lab3;

import java.util.Arrays;

public class Main2_My {
    public static void main(String[] args) {
        N2OrderManager orderManager = new N2OrderManager();

        // Создаем заказы
        N2Order order1 = new N2Order(Arrays.asList("Товар1", "Товар2"), "Адрес 1", 100.50);
        N2Order order2 = new N2Order(Arrays.asList("Товар3"), "Адрес 2", 50.00);
        N2Order order3 = new N2Order();

        // Вставляем заказы
        orderManager.addOrder(1, order1);
        orderManager.addOrder(2, order2);
        orderManager.addOrder(3, order3);

        // Поиск заказа
        N2Order searchedOrder = orderManager.getOrder(1);
        System.out.println("Найденный заказ: " + searchedOrder);

        N2Order searchedOrder2 = orderManager.getOrder(3);
        System.out.println("Найденный заказ: " + searchedOrder2);

        // Удаление заказа
        N2Order removedOrder = orderManager.removeOrder(1);
        System.out.println("Удаленный заказ: " + removedOrder);

        // Попытка поиска удаленного заказа
        N2Order notFoundOrder = orderManager.getOrder(1);
        System.out.println("Заказ с номером 1 после удаления: " + notFoundOrder);
    }
}
