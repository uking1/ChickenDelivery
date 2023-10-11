package cart;

import java.util.ArrayList;
import menu.ChickenMenu;


public class Cart implements CartInterface {

	public ArrayList<CartItem> chickenItem = new ArrayList<CartItem>();
	public static int cartCount = 0;

	public Cart() {

	}

	@Override
	public void printChickenList(ArrayList<ChickenMenu> chickenList) { // 메뉴 출력
		for (int i = 0; i < chickenList.size(); i++) {
			ChickenMenu cm = chickenList.get(i);
			System.out.print(cm.getMenuId() + " | "); // menu 번호
			System.out.print(cm.getChickenMenu() + " | "); // 메뉴 이름
			System.out.print(cm.getPrice() + " | "); // 가격 
			System.out.print(cm.getDescription() + " | "); // 메뉴 설명
			System.out.print(cm.getReleaseDate() + " | "); // 메뉴 출시일
			System.out.println();
		}
	}

	@Override
	public boolean isCartInChicken(String chickenId) { // 장바구니 항목 있는지 확인
		boolean flag = false;
		for(int i=0; i<chickenItem.size(); i++) {
			if(chickenId.equals(chickenItem.get(i).getChickenID())) {
				chickenItem.get(i).setQuantity(chickenItem.get(i).getQuantity() +1);
			}
		}
		
		return flag;
	}

	@Override
	public void removeCart(int numId) { // 장바구니 항목 삭제
		chickenItem.remove(numId);
		cartCount = chickenItem.size();

	}

	@Override
	public void insertChicken(ChickenMenu c) { // 장바구니 항목 추가
		CartItem ChickenMenu = new CartItem(c);
		chickenItem.add(ChickenMenu);
		cartCount = chickenItem.size();
		
	}

	@Override
	public void deleteCart() { // 장바구니 비우기
		chickenItem.clear();
		cartCount = 0;
	}
	
	public void printCart() {
		System.out.println("장바구니 상품 목록 :");
		System.out.println("----------------------------------------");
		System.out.println("	메뉴 \t|  수량 \t|	금액 \t|");
		
		for (int i=0 ; i< chickenItem.size();i++) {
			System.out.print(" " + chickenItem.get(i).getChickenID() + " \t| ");
			System.out.print(" " + chickenItem.get(i).getQuantity() + " \t| ");
			System.out.print(" " + chickenItem.get(i).getTotalPrice() + " \t| ");
			System.out.println("");
		}
		System.out.println("----------------------------------------");
	}
	
}