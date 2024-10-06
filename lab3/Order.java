// Вариант 7

package lab3;

import java.util.List;

public class Order {
    private List<String> items; // Список товаров в заказе
    private String deliveryAddress; // Адрес доставки
    private double totalCost; // Общая стоимость заказа

    public Order(List<String> items, String deliveryAddress, double totalCost) {
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.totalCost = totalCost;
    }

    public List<String> getItems() {
        return items;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Предметы: " + items +
                ", адрес доставки:'" + deliveryAddress + '\'' +
                ", общая стоимость: " + totalCost;
    }
}
