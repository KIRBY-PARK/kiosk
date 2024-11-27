package kioskLv3;

import java.util.ArrayList;
import java.util.List;

// 여러 메뉴 항목을 관리
public class Menu {
    private List<MenuItem> menuItems;

    // 생성자
    public Menu() {
        menuItems = new ArrayList<>();
        initializeMenu();
    }

    // 초기 메뉴 추가
    private void initializeMenu() {
        addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // 메뉴 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    // 전체 메뉴 출력
    public void displayMenu() {
        System.out.println("=============== 메뉴 리스트 ===============");
        for (int i = 0; i < menuItems.size(); i++) {
            menuItems.get(i).printMenuItem(i + 1);
        }
        System.out.println("==========================================");
    }

    // 메뉴 가져오기
    public MenuItem getMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            return menuItems.get(index);
        }
        return null;
    }
}
