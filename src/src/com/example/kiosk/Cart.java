package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

// 장바구니 관리 클래스
public class Cart {
    private List<MenuItem> cartItems;

    // 생성자
    public Cart() {
        cartItems = new ArrayList<>();
    }

    // 장바구니에 항목 추가
    public void addItem(MenuItem item) {
        cartItems.add(item);
        System.out.println("'" + item.getMenuName() + "'이(가) 장바구니에 추가되었습니다.");
    }

    // 장바구니 항목 출력 (일반 출력)
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("\n============================== 장바구니 ==============================");
            printItems();
            System.out.println("=====================================================================");
        }
    }

    // 장바구니 항목만 출력
    public void printItems() {
        for (int i = 0; i < cartItems.size(); i++) {
            cartItems.get(i).printMenuItem(i + 1);
        }
    }

    // 장바구니 비우기
    public void clearCart() {
        cartItems.clear();
        System.out.println("장바구니가 비워졌습니다.");
    }

    // 장바구니에 있는 항목 수
    public int getItemCount() {
        return cartItems.size();
    }

    // 장바구니 항목 반환
    public List<MenuItem> getItems() {
        return new ArrayList<>(cartItems); // 리스트 복사본 반환
    }

    // 총 금액 계산
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : cartItems) {
            total += item.getMenuPrice();
        }
        return total;
    }
}
