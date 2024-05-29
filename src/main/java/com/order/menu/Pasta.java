package com.order.menu;

public class Pasta extends MainDish {

    private final String type;

    public Pasta(String name, int price, String type) {
        super(name, price);
        this.type = type;
    }

    public int calculateCookingTime() {
        int baseTime = 15;

        if (type.equals("cream")) {
            baseTime += 5;
        }

        return baseTime;
    }

    public String getType() {
        return type;
    }
}
