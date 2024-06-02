package com.EAD2.pizzacreed.entity;

import java.util.List;

public class Bill {

    private List<BillItem> items;
    private double totalAmount;

    public Bill(List<BillItem> items, double totalAmount) {
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public void setItems(List<BillItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
