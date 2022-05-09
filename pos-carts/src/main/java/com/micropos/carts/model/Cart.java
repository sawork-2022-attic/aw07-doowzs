package com.micropos.carts.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@SessionScope
public class Cart implements Serializable {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean addItem(Item item) {
        return items.add(item);
    }

    public boolean removeItem(String productId) {
        return items.removeIf((i) -> Objects.equals(i.getProduct().getId(), productId));
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getQuantity() * items.get(i).getProduct().getPrice();
        }
        return total;
    }

}
