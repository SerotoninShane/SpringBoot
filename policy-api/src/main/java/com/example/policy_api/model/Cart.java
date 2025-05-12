package com.example.policy_api.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public List<Item> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
