package kioskLv1.kiosk;

import java.util.Scanner;

public class Kiosk {
    // 생성자
    private String menuIntro;
    private String bugerName;
    private String menuAll;

    private boolean menuStart;

    // 사용자 입력 객체 생성
    Scanner scanner = new Scanner(System.in);

    public void run() {
        menuStart = true;
        while (menuStart) {
            // 안내 및 메뉴 출력
            System.out.println(System.lineSeparator() + "=============== Kirby's Buger ===============");
            System.out.println("view : 메뉴판 확인 | save : 메뉴 등록 | exit : 종료");
            menuIntro = scanner.nextLine();

            switch (menuIntro) {
                // 키오스크 종료
                case "exit":
                    System.out.println("커비버거 키오스크를 종료합니다!");
                    System.exit(0);
                    break;
                // 키오스크 메뉴 등록
                case "save":
                    System.out.println("커비버거 메뉴를 등록합니다.");
                    menuStart = !menuStart;
                    break;
                // 키오스크 메뉴
                case "view":
                    menuAll = scanner.nextLine();
                    System.out.println("[ Kirby's Buger Menu]");
                    System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                    System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                    System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                    System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                    break;
            }
        }

        // 메뉴 이름 입력
        System.out.println("메뉴 이름을 입력하세요 : ");
        bugerName = scanner.nextLine();
    }

}
