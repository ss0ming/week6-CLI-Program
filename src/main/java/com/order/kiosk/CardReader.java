package com.order.kiosk;

import com.order.menu.Menu;
import com.order.view.OutputView;

import java.util.Map;

public class CardReader {

    private final Map<Menu, Integer> orders;

    public CardReader(Map<Menu, Integer> orders) {
        this.orders = orders;
    }

    public void showReceipt() {
        OutputView.printReceipt(orders);
    }
}
