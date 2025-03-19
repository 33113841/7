package com.example.a7;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket implements Serializable {
    private List<BasketItem> items;

    public Basket() {
        items = new ArrayList<>();
    }

    // Add item to basket
    public void addItem(BasketItem item) {
        items.add(item);
    }

    // Get list of items in basket
    public List<BasketItem> getItems() {
        return items;
    }

    // Calculate total price of items in basket
    public int getTotalPrice() {
        int total = 0;
        for (BasketItem item : items) {
            total += item.getPet().getPrice() * item.getQuantity();
        }
        return total;
    }
}