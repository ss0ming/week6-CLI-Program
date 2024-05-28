package com.order.customer;

import com.order.menu.Menu;
import com.order.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

public class Customer {

    private Map<Menu, Integer> orders;

    public Customer() {
        this.orders = new LinkedHashMap<>();
    }

    public void order(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void cancelOrder() {
        orders.clear();
    }

    public Map<Menu, Integer> getOrders() {
        return orders;
    }
}
