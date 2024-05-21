package com.order.controller;

import com.order.menu.*;
import com.order.receipt.Receipt;
import com.order.view.InputView;

import java.util.*;

public class Controller {

    static List<Menu> menus = new ArrayList<>();
    static Map<Menu, Integer> orders = new LinkedHashMap<>();

    public void run() {
        makeMenuBoard(); // 메뉴 생성
        showMenu(); // 메뉴판 보여주기
        order(); // 주문하기
        showReceipt(); // 영수증 출력
    }

    public static void order() {
        System.out.println("주문할 메뉴의 이름과 수량을 입력해주세요.");
        System.out.println("메뉴 한 줄씩 입력해주시고 주문이 끝나면 0을 입력해주세요. 예시) 크림 파스타 2");

        orders = InputView.inputOrder(menus);
    }

    public static void showReceipt() {
        System.out.println("============= Receipt =============");
        Receipt receipt = new Receipt(orders);
        receipt.printReceipt();
    }

    public static void showMenu() {
        System.out.println("=========== Main Dishes ===========");
        menus.stream().filter(menu -> Objects.equals(menu.getCategory(), "MainDish"))
                .forEach(Menu::printInfo);
        System.out.println();

        System.out.println("============== Sides ==============");
        menus.stream().filter(menu -> Objects.equals(menu.getCategory(), "Side"))
                .forEach(Menu::printInfo);
        System.out.println();

        System.out.println("============== Drinks ==============");
        menus.stream().filter(menu -> Objects.equals(menu.getCategory(), "Drink"))
                .forEach(Menu::printInfo);
        System.out.println();
    }

    public static void makeMenuBoard() {
        Pasta pasta1 = new Pasta("크림 파스타", 21_000, "cream");
        Pasta pasta2 = new Pasta("토마토 파스타", 21_000, "tomato");
        Pizza pizza1 = new Pizza("고르곤졸라 미니 피자", 10_000, "mini");
        Pizza pizza2 = new Pizza("고르곤졸라 피자", 16_000, "regular");
        Pizza pizza3 = new Pizza("마르게리타 미니 피자", 10_000, "mini");
        Pizza pizza4 = new Pizza("마르게리타 피자", 16_000, "regular");
        Steak steak = new Steak("부채살 스테이크", 50_000, "medium", "brown gravy sauce");
        Side side1 = new Side("윙봉", 5_000);
        Side side2 = new Side("마늘빵", 5_000);
        Wine wine1 = new Wine("레드 와인", 50_000, "bottle");
        Wine wine2 = new Wine("레드 와인 한잔", 9_000, "glass");
        Wine wine3 = new Wine("화이트 와인", 50_000, "bottle");
        Wine wine4 = new Wine("화이트 와인 한잔", 9_000, "glass");
        Ade ade1 = new Ade("딸기 에이드", 3_000, "strawberry");
        Ade ade2 = new Ade("레몬 에이드", 3_000, "lemon");
        menus.add(pasta1);
        menus.add(pasta2);
        menus.add(pizza1);
        menus.add(pizza2);
        menus.add(pizza3);
        menus.add(pizza4);
        menus.add(steak);
        menus.add(side1);
        menus.add(side2);
        menus.add(wine1);
        menus.add(wine2);
        menus.add(wine3);
        menus.add(wine4);
        menus.add(ade1);
        menus.add(ade2);
    }
}
