package com.order.menu;

public class Drink extends Menu {

    private final String category = "Drink";

    public Drink(String name, int price) {
        super(name, price);
    }

    public String getCategory() {
        return category;
    }
}
