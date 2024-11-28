package com.example.kiosk;

import java.util.Scanner;

// 키오스크의 메인 로직을 관리
public class Kiosk {
    private Scanner scanner;
    private Menu menu;
    private Cart cart;
    private Order order;
    private boolean isRunning;

    // 생성자
    public Kiosk() {
        scanner = new Scanner(System.in);
        menu = new Menu();
        cart = new Cart();
        order = new Order(cart); // Order 객체 초기화
        isRunning = true;
    }

    // 키오스크 실행
    public void run() {
        while (isRunning) {
            showMainMenu();
            String input = scanner.nextLine().toLowerCase(); // 소문자로 변환

            switch (input) {
                case "1":
                    handleCategorySelection(menu.getBurgers(), "버거");
                    break;
                case "2":
                    handleCategorySelection(menu.getDrinks(), "음료");
                    break;
                case "3":
                    handleCategorySelection(menu.getDesserts(), "디저트");
                    break;
                case "cart":
                    cart.displayCart(); // 장바구니 보기
                    break;
                case "order":
                    handleOrder(); // 주문 처리
                    break;
                case "exit":
                    System.out.println("키오스크를 종료합니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("올바른 입력이 아닙니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    // 메인 메뉴 출력
    private void showMainMenu() {
        System.out.println("\n=============== Kirby's Burger Kiosk ===============");
        System.out.println("1 : 버거 메뉴 보기");
        System.out.println("2 : 음료 메뉴 보기");
        System.out.println("3 : 디저트 메뉴 보기");
        System.out.println("cart : 장바구니 보기");
        System.out.println("order : 주문하기");
        System.out.println("exit : 종료");
        System.out.println("===================================================");
        System.out.print("선택 : ");
    }

    // 주문 처리
    private void handleOrder() {
        order.processOrder(); // 주문 내역 및 총 금액 출력

        while (true) {
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                order.completeOrder(); // 주문 완료
                return; // 메인 메뉴로 돌아가기
            } else if ("2".equals(input)) {
                System.out.println("메뉴판으로 돌아갑니다.");
                return; // 메인 메뉴로 돌아가기
            } else {
                System.out.println("올바른 입력이 아닙니다. 1 또는 2를 입력하세요.");
            }
        }
    }

    // 카테고리 메뉴 처리
    private void handleCategorySelection(java.util.List<MenuItem> menuList, String category) {
        while (true) {
            menu.displayMenu(menuList, category);
            System.out.print("메뉴 번호를 선택하세요 (0: 뒤로가기): ");
            int selection;

            try {
                selection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
                continue;
            }

            if (selection == 0) {
                System.out.println("메인 메뉴로 돌아갑니다.");
                return; // 메인 메뉴로 돌아가기
            }

            if (selection >= 1 && selection <= menuList.size()) {
                showMenuDetails(menuList.get(selection - 1)); // 상세 정보 출력
            } else {
                System.out.println("잘못된 번호입니다. 다시 선택하세요.");
            }
        }
    }

    // 메뉴 상세 정보 출력
    private void showMenuDetails(MenuItem item) {
        System.out.println("\n============================== 메뉴 상세 정보 ==============================");
        item.printMenuItem(0);
        System.out.println("1: 장바구니에 추가");
        System.out.println("2: 취소 후 뒤로가기");
        System.out.println("=====================================================================");

        while (true) {
            System.out.print("선택: ");
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                cart.addItem(item); // 장바구니에 추가
                return; // 뒤로가기
            } else if ("2".equals(input)) {
                System.out.println("취소되었습니다. 뒤로 돌아갑니다.");
                return; // 뒤로가기
            } else {
                System.out.println("올바른 입력이 아닙니다. 1 또는 2를 입력하세요.");
            }
        }
    }
}