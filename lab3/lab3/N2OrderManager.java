package lab3;

import java.util.HashMap;

public class N2OrderManager {
    private HashMap<Integer, N2Order> orderMap;

    public N2OrderManager() {
        orderMap = new HashMap<>();
    }

    // Метод для вставки заказа
    public void addOrder(int orderNumber, N2Order order) {
        orderMap.put(orderNumber, order);
    }

    // Метод для поиска заказа
    public N2Order getOrder(int orderNumber) {
        return orderMap.get(orderNumber);
    }

    // Метод для удаления заказа
    public N2Order removeOrder(int orderNumber) {
        return orderMap.remove(orderNumber);
    }
}