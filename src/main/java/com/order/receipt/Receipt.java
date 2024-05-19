package com.order.receipt;

import com.order.menu.Menu;

import java.util.Map;

public class Receipt {

    private final Map<Menu, Integer> orders;

    public Receipt(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void printReceipt() {
        int total = 0;

        for (Menu order : orders.keySet()) {
            int price = order.getPrice();
            int sum = price * orders.get(order);
            total += sum;
            System.out.printf("%-15s %8d %8d\n", order.getName(), orders.get(order), sum);
        }
        System.out.println("-----------------------------------");
        System.out.printf("%-26s %8d\n", "total", total);
    }
}
