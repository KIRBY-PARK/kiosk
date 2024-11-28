package com.example.kiosk;

public class Order {
    private Cart cart; // 장바구니 객체 참조

    // 생성자
    public Order(Cart cart) {
        this.cart = cart;
    }

    // 주문 처리
    public void processOrder() {
        if (cart.getItemCount() == 0) {
            System.out.println("장바구니가 비어 있습니다. 메뉴를 먼저 추가하세요.");
            return;
        }

        // 주문 내역 출력
        System.out.println("\n============================== 주문내역 ==============================");
        // 장바구니 항목만 출력
        cart.printItems();
        // 총 금액 계산
        double totalAmount = cart.calculateTotal();
        System.out.println("총 금액: W " + totalAmount);
        System.out.println("=====================================================================");
        System.out.println("1: 주문하기");
        System.out.println("2: 메뉴판으로 돌아가기");
        System.out.print("선택: ");
    }

    // 주문 완료 메시지
    public void completeOrder() {
        double totalAmount = cart.calculateTotal();
        System.out.println("주문이 완료되었습니다!");
        System.out.println("결제 금액: W " + totalAmount);
        // 주문 후 장바구니 비우기
        cart.clearCart();
    }
}
