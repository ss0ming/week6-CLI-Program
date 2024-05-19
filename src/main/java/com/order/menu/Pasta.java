package com.order.menu;

public class Pasta extends MainDish {

    private final String type;

    public Pasta(String name, int price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
