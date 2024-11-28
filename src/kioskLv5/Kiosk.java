package kioskLv5;

import java.util.Scanner;

// 키오스크의 메인 로직을 관리
public class Kiosk {
    private Scanner scanner;
    private Menu menu;
    private boolean isRunning;

    // 생성자
    public Kiosk() {
        scanner = new Scanner(System.in);
        menu = new Menu();
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
                case "save":
                    addCustomMenuItem();
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
        System.out.println("save : 새 메뉴 추가");
        System.out.println("exit : 종료");
        System.out.println("===================================================");
        System.out.print("선택 : ");
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
        System.out.println("\n=============== 메뉴 상세 정보 ===============");
        item.printMenuItem(0); // 상세 정보 출력
        System.out.println("0을 입력하여 뒤로 가세요.");
        while (true) {
            System.out.print("선택: ");
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                return; // 카테고리 메뉴로 돌아가기
            } else {
                System.out.println("잘못된 입력입니다. 0을 입력하여 뒤로 가세요.");
            }
        }
    }

    // 사용자 정의 메뉴 추가
    private void addCustomMenuItem() {
        System.out.println("어느 카테고리에 메뉴를 추가하시겠습니까? (1: 버거, 2: 음료, 3: 디저트)");
        String category = scanner.nextLine();
        System.out.print("메뉴 이름: ");
        String name = scanner.nextLine();
        System.out.print("메뉴 가격: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("메뉴 설명: ");
        String description = scanner.nextLine();

        MenuItem newItem = new MenuItem(name, price, description);

        switch (category) {
            case "1":
                menu.getBurgers().add(newItem);
                break;
            case "2":
                menu.getDrinks().add(newItem);
                break;
            case "3":
                menu.getDesserts().add(newItem);
                break;
            default:
                System.out.println("잘못된 카테고리 선택입니다.");
                return;
        }

        System.out.println("새로운 메뉴가 추가되었습니다!");
    }
}
