package com.order.controller;

import com.order.customer.Cart;
import com.order.customer.Customer;
import com.order.menu.*;
import com.order.kiosk.CardReader;
import com.order.view.InputView;
import com.order.view.OutputView;

public class Controller {

    static MenuBoard menuBoard = new MenuBoard();

    public void run() {
        makeMenu();// 메뉴판 생성
        menuBoard.showMenuBoard(); // 메뉴판 보여주기

        Customer customer = new Customer();
        order(customer);
    }

    public static void order(Customer customer) {
        boolean running = true;
        while (running) {
            OutputView.printMainOption();
            int num = InputView.inputNum();
            System.out.println();

            switch (num) {
                case 1:
                    customer.order(InputView.inputOrder(menuBoard.getMenus()));
                    break;
                case 2:
                    Cart cart = new Cart(customer.getOrders());
                    cart.showOrders();
                    break;
                case 3:
                    customer.cancelOrder();
                    break;
                case 4:
                    CardReader receipt = new CardReader(customer.getOrders());
                    receipt.showReceipt(); // 영수증 출력
                    running = false;
                    break;
                case 5:
                    System.out.println("주문 프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    public static void makeMenu() {
        menuBoard.addMenu(new Pasta("크림 파스타", 21_000, "cream"));
        menuBoard.addMenu(new Pasta("토마토 파스타", 21_000, "tomato"));
        menuBoard.addMenu(new Pizza("고르곤졸라 미니 피자", 10_000, "mini"));
        menuBoard.addMenu(new Pizza("고르곤졸라 피자", 16_000, "regular"));
        menuBoard.addMenu(new Pizza("마르게리타 미니 피자", 10_000, "mini"));
        menuBoard.addMenu(new Pizza("마르게리타 피자", 16_000, "regular"));
        menuBoard.addMenu(new Steak("부채살 스테이크", 50_000, "medium", "brown gravy sauce"));
        menuBoard.addMenu(new Side("윙봉", 5_000));
        menuBoard.addMenu(new Side("마늘빵", 5_000));
        menuBoard.addMenu(new Wine("레드 와인", 50_000, "bottle"));
        menuBoard.addMenu(new Wine("레드 와인 한잔", 9_000, "glass"));
        menuBoard.addMenu(new Wine("화이트 와인", 50_000, "bottle"));
        menuBoard.addMenu(new Wine("화이트 와인 한잔", 9_000, "glass"));
        menuBoard.addMenu(new Ade("딸기 에이드", 3_000, "strawberry"));
        menuBoard.addMenu(new Ade("레몬 에이드", 3_000, "lemon"));
    }
}
