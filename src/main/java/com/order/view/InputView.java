package com.order.view;

import com.order.menu.Menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    public static Map<Menu, Integer> inputOrder(List<Menu> menus) {
        System.out.println("주문할 메뉴의 이름과 수량을 입력해주세요.");
        System.out.println("메뉴 한 줄씩 입력해주시고 주문이 끝나면 0을 입력해주세요. 예시) 크림 파스타 2");

        Scanner sc = new Scanner(System.in);
        Map<Menu, Integer> orders = new LinkedHashMap<>();

        while (true) {

            String input = sc.nextLine();

            if (input.equals("0")) {
                System.out.println();
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

    public static String inputNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("번호 입력: ");
        String num = sc.next();
        System.out.println();

        return num;
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
