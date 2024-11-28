## 키오스크
![키오스크](https://ifh.cc/g/gYYZpF.png)

## ❓ 키오스크를 왜 만들까요?
> 기초적인 흐름 제어 및 객체지향 설계 개념을 복습 및 연습!
> <br>
>
> 제공받은 가이드라인 중 기본과제 Lv1~5와 도전과제 Lv1 까지 구현하였습니다.<br>
> 이 프로젝트는 클래스 설계를 쉽게 머릿속에 그릴 수 있고 계산기 과제 이후,<br>
> 다시 한 번 클래스의 개념을 이해하고 객체지향 설계를 활용하는 기회가 되었습니다! 😊

## 🙋‍♀️ 조금 더 구체적으로 가르쳐주세요!
1. Scanner를 사용한 메뉴 출력 및 반복문을 이용한 프로그램 종료
2. 객체 지향 설계를 적용해 메뉴를 클래스로 관리
3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리
4. 객체 지향 설계를 적용해 메뉴와 주문 내역을 클래스로 관리
5. 캡슐화 적용

## 📌 목차

1. [❓ 키오스크를 왜 만들까요?](#-키오스크를-왜-만들까요)
2. [🙋‍♀️ 조금 더 구체적으로 가르쳐주세요!](#-조금-더-구체적으로-가르쳐주세요)
3. [📌 목차](#-목차)
    - [🗂️ Project info](#-Project-info)
    - [🚀 Stacks](#-Stacks)
    - [💻 Program operation screen](#-Program-operation-screen)
    - [☄️ Major functional code](#-Major-functional-code)
    - [📂 Architecture](#-Architecture)
    - [🛠️ Trouble shooting](#-Trouble-shooting)

## 🗂️ Project info

- 프로젝트 이름 : Project < Kiosk >
- 개발기간 : 2024.11.22 - 2024.11.28

<br>

## 🚀 Stacks

### Environment
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![GitGub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)


### Skills
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### OS
![Mac os](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=apple&logoColor=white)

### Workspace Specs
![MacBookPro M2](https://img.shields.io/badge/Apple-MacBook_Pro_M2_2022-999999?style=for-the-badge&logo=apple&logoColor=white)

### Blog
[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api/badge?name=kirby_y)](https://velog.io/@kirby_y)

<br>

## 💻 Program operation screen

<details>
   <summary>📍 메뉴보기 실행 화면 보기</summary>

### 📍 메뉴보기 실행 화면

![메뉴보기 실행 화면](https://ifh.cc/g/YHjP1q.png)
![메뉴보기 실행 화면](https://ifh.cc/g/1SxdT2.png)
![메뉴보기 실행 화면](https://ifh.cc/g/Gj6QjC.png)

</details>

<details>
   <summary>📍 장바구니에 상품 추가 화면 보기</summary>

### 📍 장바구니에 상품 추가 화면

![장바구니에 상품 추가 화면](https://ifh.cc/g/RwjHmq.png)
![장바구니에 상품 추가 화면](https://ifh.cc/g/d8rGwH.png)

</details>

<details>
   <summary>📍 장바구니에 상품 확인 화면 보기</summary>

### 📍 장바구니에 상품 확인 화면

![장바구니에 상품 추가 화면](https://ifh.cc/g/5nf6zS.png)

</details>

<details>
   <summary>📍 장바구니에 상품 주문하기 화면 보기</summary>

### 📍 장바구니에 상품 주문하기 화면

![장바구니에 상품 주문하기 화면](https://ifh.cc/g/VmsCYN.png)

</details>

## ☄️ Major functional code

### 여러 카테고리 메뉴 관리
유지보수에 용이하도록 각 메뉴를 카테고리 별로 분리했습니다.
```java
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
```

### 공통양식으로 메뉴 정보 관리
```java
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
```

<br>

## 📂 Architecture

```java
📂
├─ .idea
│  ├─ .gitignore
│  ├─ material_theme_project_new.xml
│  ├─ misc.xml
│  ├─ modules.xml
│  └─ vcs.xml
│
├─ .gitignore
│
├─ README.md
│
├─ kiosk.iml
│
└─ src
   ├─ com
   │ └─ example
   │    └─ kiosk
   │      ├─ Cart.java
   │      ├─ Kiosk.java
   │      ├─ Main.java
   │      ├─ Menu.java
   │      ├─ MenuItem.java
   │      └─ Order.java
   │
   ├─ kioskLv1
   │  └─ Kiosk.java
   │
   ├─ kioskLv2
   │  ├─ Kiosk.java
   │  ├─ Main.java
   │  ├─ Menu.java
   │  └─ MenuItem.java
   │
   ├─ kioskLv3
   │  ├─ Kiosk.java
   │  ├─ Main.java
   │  ├─ Menu.java
   │  └─ MenuItem.java
   │
   ├─ kioskLv4
   │  ├─ Kiosk.java
   │  ├─ Main.java
   │  ├─ Menu.java
   │  └─ MenuItem.java
   │
   ├─ kioskLv5
   │  ├─ Kiosk.java
   │  ├─ Main.java
   │  ├─ Menu.java
   │  └─ MenuItem.java
   │
   ├─ kioskChallenge
   │  ├─ Cart.java
   │  ├─ Kiosk.java
   │  ├─ Main.java
   │  ├─ Menu.java
   │  ├─ MenuItem.java
   │  └─ Order.java
   │
   └─ Main.java



```

<br>

## 🛠️ Trouble shooting
[![Velog's GitHub stats](https://velog-readme-stats.vercel.app/api?name=kirby_y&tag=kiosk)](https://velog.io/@kirby_y)
