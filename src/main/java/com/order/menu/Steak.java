package com.order.menu;

public class Steak extends MainDish {

    private final String doneness;
    private final String sauce;

    public Steak(String name, int price, String doneness, String sauce) {
        super(name, price);
        this.doneness = doneness;
        this.sauce = sauce;
    }

    public int calculateCookingTime() {
        int baseTime = 25;

        if (doneness.equals("well-done")) {
            baseTime += 10;
        }

        return baseTime;
    }

    public String getDoneness() {
        return doneness;
    }

    public String getSauce() {
        return sauce;
    }
}
