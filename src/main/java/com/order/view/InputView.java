package com.order.view;

import com.order.menu.Menu;

import java.util.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static Map<Menu, Integer> inputOrder(List<Menu> menus) {
        System.out.println("주문할 메뉴의 이름과 수량을 입력해주세요.");
        System.out.println("메뉴 한 줄씩 입력해주시고 주문이 끝나면 0을 입력해주세요. 예시) 크림 파스타 2");

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

            if (count < 1) {
                System.out.println("수량은 한 개이상 입력해주세요.");
                continue;
            }

            try {
                Menu menu = findMenu(menuName, menus);
                orders.put(menu, count);
            } catch (IllegalArgumentException e) {
                System.out.println("입력한 메뉴는 없는 메뉴입니다. 다시 입력해주세요.");
            }


        }

        return orders;
    }

    public static int inputNum() {
        System.out.print("번호 입력: ");
        try {
            int num = sc.nextInt();
            sc.nextLine();
            return num;
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.\n");
            return inputNum();
        }
    }

    public static boolean checkInput(String input, int index) {
        if (index == -1 || index == input.length() - 1) {
            return false;
        }
        else if (!input.substring(index + 1).trim().matches("\\d+")) {
            System.out.println(input.substring(index + 1).trim());
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
