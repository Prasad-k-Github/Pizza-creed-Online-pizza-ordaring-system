package com.EAD2.pizzacreed.entity;

public class BillItem {

    private String productName;
    private String sizeOfPizza;
    private int quantity;
    private double price;

    public BillItem(String productName, String sizeOfPizza, int quantity, double price) {
        this.productName = productName;
        this.sizeOfPizza = sizeOfPizza;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizeOfPizza() {
        return sizeOfPizza;
    }

    public void setSizeOfPizza(String sizeOfPizza) {
        this.sizeOfPizza = sizeOfPizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
