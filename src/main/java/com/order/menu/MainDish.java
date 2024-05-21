package com.order.menu;

public class MainDish extends Menu {

    private final String category = "MainDish";

    public MainDish(String name, int price) {
        super(name, price);
    }

    public String getCategory() {
        return category;
    }
}
