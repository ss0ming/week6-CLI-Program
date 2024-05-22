package com.order.receipt;

import com.order.menu.Menu;
import com.order.view.OutputView;

import java.util.Map;

public class Receipt {

    private final Map<Menu, Integer> orders;

    public Receipt(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void showReceipt() {
        OutputView.printReceipt(orders);
    }
}
