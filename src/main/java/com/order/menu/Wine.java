package com.order.menu;

public class Wine extends Drink{

    private final String amount;

    public Wine(String name, int price, String amount) {
        super(name, price);
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
}
