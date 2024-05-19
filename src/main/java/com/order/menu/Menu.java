package com.order.menu;

public class Menu {

    private final String name;
    private final int price;
    private final String category;

    public Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void printInfo() {
        String info = String.format("%-20s%10d원", name, price);
        System.out.println(info);
    }
}
