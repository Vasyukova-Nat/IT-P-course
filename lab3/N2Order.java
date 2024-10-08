// Вариант 7

package lab3;

import java.util.List;
import java.util.ArrayList;

public class N2Order {
    private List<String> items; // Список товаров в заказе
    private String deliveryAddress; // Адрес доставки
    private double totalCost; // Общая стоимость заказа

    public N2Order(List<String> items, String deliveryAddress, double totalCost) {
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.totalCost = totalCost;
    }

    public N2Order() {
        this.items = new ArrayList<>();
        this.deliveryAddress = "КАКОЙ-ТО АДРЕС";
        this.totalCost = 0.0;
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
