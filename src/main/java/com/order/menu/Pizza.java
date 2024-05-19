package com.order.menu;

public class Pizza extends MainDish {

    private final String size;

    public Pizza(String name, int price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
