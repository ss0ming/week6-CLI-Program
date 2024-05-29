package com.order.menu;

public class Pizza extends MainDish {

    private final String size;

    public Pizza(String name, int price, String size) {
        super(name, price);
        this.size = size;
    }

    public int calculateBakingTime() {
        int bakingTime = 15;

        if (size.equals("mini")) {
            bakingTime += 5;
        } else if (size.equals("regular")) {
            bakingTime += 10;
        }

        return bakingTime;
    }

    public String getSize() {
        return size;
    }
}
