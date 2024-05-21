package com.order.menu;

public abstract class Menu {

    private final String name;
    private final int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public abstract String getCategory();

    public void printInfo() {
        String info = String.format("%-20s%10d원", name, price);
        System.out.println(info);
    }
}
