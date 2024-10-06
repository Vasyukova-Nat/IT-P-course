package lab3;

import java.util.HashMap;

public class OrderManager {
    private HashMap<Integer, Order> orderMap;

    public OrderManager() {
        orderMap = new HashMap<>();
    }

    // Метод для вставки заказа
    public void addOrder(int orderNumber, Order order) {
        orderMap.put(orderNumber, order);
    }

    // Метод для поиска заказа
    public Order getOrder(int orderNumber) {
        return orderMap.get(orderNumber);
    }

    // Метод для удаления заказа
    public Order removeOrder(int orderNumber) {
        return orderMap.remove(orderNumber);
    }
}