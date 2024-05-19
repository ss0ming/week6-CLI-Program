package com.order.menu;

public class Ade extends Drink {

    private final String flavor;

    public Ade(String name, int price, String flavor) {
        super(name, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }
}
