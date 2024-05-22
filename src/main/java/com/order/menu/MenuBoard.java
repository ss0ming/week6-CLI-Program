package com.order.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuBoard {
    private final List<Menu> menus;

    public MenuBoard() {
        menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void showMenuBoard() {
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
}
