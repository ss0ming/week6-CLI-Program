package com.order.menu;

public abstract class Menu {

    private String name;
    private int price;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void printInfo() {
        String info = String.format("%-20s%10d원", name, price);
        System.out.println(info);
    }
}
