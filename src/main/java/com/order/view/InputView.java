package com.order.view;

import com.order.menu.Menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public static Map<Menu, Integer> inputOrder(List<Menu> menus) {
        Scanner sc = new Scanner(System.in);
        Map<Menu, Integer> orders = new LinkedHashMap<>();

        while (true) {

            String input = sc.nextLine();

            if (input.equals("0")) {
                break;
            }

            int lastSpaceIndex = input.lastIndexOf(' ');
            if (!checkInput(input, lastSpaceIndex)) {
                System.out.println("메뉴 이름과 수량을 정확히 입력해주세요.");
                continue;
            }

            String menuName = input.substring(0, lastSpaceIndex).trim();
            int count = Integer.parseInt(input.substring(lastSpaceIndex + 1).trim());

            try {
                Menu menu = findMenu(menuName, menus);
                orders.put(menu, count);
            } catch (IllegalArgumentException e) {
                System.out.println("메뉴 이름과 수량을 정확히 입력해주세요.");
            }

        }

        return orders;
    }

    public static boolean checkInput(String input, int index) {
        if (index == -1 || index == input.length() - 1) {
            return false;
        }
        else if (!input.substring(index + 1).trim().matches("\\d+")) {
            System.out.println(input.substring(index + 1).trim());
            return false;
        }
        else if (Integer.parseInt(input.substring(index + 1).trim()) < 1) {
            return false;
        }
        return true;
    }

    public static Menu findMenu(String name, List<Menu> menus) {
        return menus.stream()
                .filter(menu -> menu.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Menu not found"));
    }
}
