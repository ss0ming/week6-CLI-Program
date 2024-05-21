package com.order.menu;

public class Side extends Menu {

    private final String category = "Side";

    public Side(String name, int price) {
        super(name, price);
    }

    public String getCategory() {
        return category;
    }
}
