package kioskLv3;

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
                case "2":
                case "3":
                case "4":
                    showMenuDetails(Integer.parseInt(input) - 1);
                    break;
                case "view":
                    menu.displayMenu();
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
        System.out.println("1 : 1번 메뉴 보기 | 2 : 2번 메뉴 보기 | 3 : 3번 메뉴 보기 | 4 : 4번 메뉴 보기");
        System.out.println("view : 전체 메뉴 보기 | save : 새 메뉴 추가 | exit : 종료");
        System.out.println("===================================================");
        System.out.print("선택 : ");
    }

    // 메뉴 상세 정보 출력
    private void showMenuDetails(int menuIndex) {
        while (true) {
            MenuItem item = menu.getMenuItem(menuIndex);
            if (item != null) {
                System.out.println("\n=============== 메뉴 상세 정보 ===============");
                item.printMenuItem(menuIndex + 1);
                System.out.println("==========================================");
                System.out.println("뒤로가려면 'back'을 입력하세요.");
                System.out.print("선택 : ");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("back")) {
                    return; // 메인 메뉴로 돌아가기
                } else {
                    System.out.println("올바른 입력이 아닙니다. 다시 시도하세요.");
                }
            } else {
                System.out.println("해당 메뉴는 존재하지 않습니다.");
                return; // 메인 메뉴로 돌아가기
            }
        }
    }

    // 사용자 정의 메뉴 추가
    private void addCustomMenuItem() {
        System.out.print("메뉴 이름: ");
        String name = scanner.nextLine();
        System.out.print("메뉴 가격: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("메뉴 설명: ");
        String description = scanner.nextLine();

        menu.addMenuItem(new MenuItem(name, price, description));
        System.out.println("새로운 메뉴가 추가되었습니다!");
    }
}
