package com.order.customer;

import com.order.menu.Menu;
import com.order.view.OutputView;

import java.util.Map;

public class Cart {

    private final Map<Menu, Integer> orders;

    public Cart(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void showOrders() {
        OutputView.printOrders(orders);
    }

}
