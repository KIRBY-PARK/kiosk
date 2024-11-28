package kioskLv5;

import java.util.ArrayList;
import java.util.List;

// 여러 카테고리 메뉴를 관리
public class Menu {
    private List<MenuItem> burgers;
    private List<MenuItem> drinks;
    private List<MenuItem> desserts;

    // 생성자
    public Menu() {
        burgers = new ArrayList<>();
        drinks = new ArrayList<>();
        desserts = new ArrayList<>();
        initializeMenu();
    }

    // 초기 메뉴 설정
    private void initializeMenu() {
        initializeBurgersMenu();
        initializeDrinksMenu();
        initializeDessertsMenu();
    }

    // 초기 버거 메뉴 추가
    private void initializeBurgersMenu() {
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // 초기 음료 메뉴 추가
    private void initializeDrinksMenu() {
        drinks.add(new MenuItem("Sprite", 1.9, "스프라이트"));
        drinks.add(new MenuItem("Grape Ade", 5.0, "포도 에이드"));
        drinks.add(new MenuItem("Budweiser", 4.5, "버드와이저"));
        drinks.add(new MenuItem("Americano", 3.0, "아메리카노"));
    }

    // 초기 디저트 메뉴 추가
    private void initializeDessertsMenu() {
        desserts.add(new MenuItem("Piece of Cake", 7.9, "조각케이크 3종 중(택1)"));
        desserts.add(new MenuItem("Egg Tart", 2.9, "손바닥만한 에그타르트"));
        desserts.add(new MenuItem("French Fries", 4.9, "감자튀김"));
        desserts.add(new MenuItem("Strawberry Jam and Scones", 3.2, "딸기잼과 스콘"));
    }

    // 특정 카테고리 메뉴 출력
    public void displayMenu(List<MenuItem> menuList, String category) {
        System.out.println("\n============================== " + category + " 메뉴 ==============================");
        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).printMenuItem(i + 1);
        }
        System.out.println("=====================================================================");
    }

    // Getter 메서드
    public List<MenuItem> getBurgers() {
        return burgers;
    }

    public List<MenuItem> getDrinks() {
        return drinks;
    }

    public List<MenuItem> getDesserts() {
        return desserts;
    }
}
