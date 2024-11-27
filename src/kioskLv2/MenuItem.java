package kioskLv2;

// 단일 메뉴 항목을 관리
public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;

    // 생성자
    public MenuItem(String menuName, double menuPrice, String menuDescription) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    // Getter 메서드
    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    // 메뉴 정보 출력
    public void printMenuItem(int menuNum) {
        System.out.println(menuNum + ". " + menuName + " | W " + menuPrice + " | " + menuDescription);
    }
}