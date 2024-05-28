package com.order.view;

import com.order.menu.Menu;

import java.util.Map;

public class OutputView {

    public static void printMainOption() {
        System.out.println("1. 주문하기");
        System.out.println("2. 주문 내역 확인하기");
        System.out.println("3. 주문 취소하기");
        System.out.println("4. 주문 완료");
        System.out.println("5. 종료");
    }

    public static void printOrders(Map<Menu, Integer> orders) {
        System.out.println("============ 주문 내역 ============");

        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.\n");
            return;
        }

        for (Menu menu : orders.keySet()) {
            System.out.printf("%-23s %5d\n", menu.getName(), orders.get(menu));
        }

        System.out.println();
    }

    public static void printReceipt(Map<Menu, Integer> orders) {
        int total = 0;

        System.out.println("============= Receipt =============");

        if (orders.isEmpty()) {
            System.out.println("주문 내역이 없습니다.\n");
            return;
        }

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
