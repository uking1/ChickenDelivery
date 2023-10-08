package main;

import java.util.Scanner;
import java.util.*;

import member.User;
import cart.Cart;
import member.Admin;
import member.User;
import menu.ChickenMenu;

public class Main {
	static final int NUM_CHICKEN = 5; // 치킨 정보 갯수

	static User user; // 사용자

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("*******정욱이닭 왕십리점 입니다.^^*******");

		System.out.print("주문자 성함을 입력해주세요. ");
		String name = scan.nextLine();
		System.out.print("주문자 주소를 입력해주세요. ");
		String address = scan.nextLine();
		System.out.print("연락처를 입력해주세요. ");
		int phone = scan.nextInt();
		scan.nextLine();

		// 사용자 정보 저장
		user = new User(name, phone, address);

		boolean flag = false; // 무한반복

		while (!flag) {
			menuIntroduction();

			System.out.println("메뉴 번호를 선택해주세요.");
			int num = scan.nextInt();
			if (1 > num || num > 9) {
				System.out.println("1부터 9까지의 숫자를 입력해주세요");
			} else {
				switch (num) {
				case 1:
					// 1.고객정보 확인하기
					GuestInfo(name, address, phone); // 고객정보 출력
					break;
				case 2:
					// 2.장바구니 상품 목록 보기
					CartItemList();
					break;
				case 3:
					// 3.장바구니 비우기
//					CartClear();
					break;
				case 4:
					// 4.장바구니에 항목 추가하기
//					CartAddItem();
					break;
				case 5:
					// 5. 장바구니의 항목 수량 줄이기
//					CartRemoveItemCount();
					break;
				case 6:
					// 6. 장바구니의 항목 삭제하기
//					CartRemoveItem();
					break;
				case 7:
					// 7. 영수증 표시하기
//					CartBill();
					break;
				case 8:
					// 8. 종료
//					Exit();
					break;
				case 9:
					// 9. 관리자 로그인
//					AdminLogin();
					break;
				}
			}

		}
	}

	public static void CartItemList() {
		if (Cart.cartCount >= 0) {
			Cart cart = new Cart();
			cart.printCart();
		}
		
	}

	public static void GuestInfo(String name, String address, int phone) {
		System.out.println("현재 고객 정보");
		System.out.printf("이름 :%s \n",user.getName());
		System.out.printf("주소 :%s \n",user.getAddress());
		System.out.printf("연락처 :%s \n",user.getPhone());

	}

	public static void menuIntroduction() {
		System.out.println("************************************************");
		System.out.println("\t\t" + "정욱이닭 메뉴");
		System.out.println("************************************************");
		System.out.println("1.고객정보 확인하기  \t\t 4.장바구니에 메뉴 추가하기");
		System.out.println("2.장바구니 상품 목록 보기\t 5.장바구니의 메뉴 수량 줄이기");
		System.out.println("3.장바구니 비우기   \t\t 6.장바구니의 항목 삭제하기");
		System.out.println("7.영수증 표시하기   \t\t 8.종료");
		System.out.println("9.관리자 로그인");
		System.out.println("************************************************");

	}

}
