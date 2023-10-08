package cart;

import java.util.ArrayList;
import menu.ChickenMenu;

public class Cart implements CartInterface {

	public ArrayList<CartItem> chickenItem = new ArrayList<CartItem>();
	public static int cartCount = 0;

	public Cart() {

	}

	@Override
	public void printChickenList(ArrayList<ChickenMenu> chickenList) {
		for (int i = 0; i < chickenList.size(); i++) {
			ChickenMenu cm = chickenList.get(i);
			System.out.print(cm.getChickenMenu() + " | ");
			System.out.print(cm.getDescription() + " | ");
			System.out.print(cm.getReleaseDate() + " | ");
			System.out.println();
		}
	}

	@Override
	public boolean isCartInChicken(String chickenId) {
		boolean flag = false;
		for(int i=0; i<chickenItem.size(); i++) {
			if(chickenId.equals(chickenItem.get(i).getChickenID())) {
				chickenItem.get(i).setQuantity(chickenItem.get(i).getQuantity() +1);
			}
		}
		
		return flag;
	}

	@Override
	public void removeCart(int numId) {
		chickenItem.remove(numId);
		cartCount = chickenItem.size();

	}

	@Override
	public void insertChicken(ChickenMenu c) {
		CartItem ChickenMenu = new CartItem(c);
		chickenItem.add(ChickenMenu);
		cartCount = chickenItem.size();
		
	}

	@Override
	public void deleteCart() {
		chickenItem.clear();
		cartCount = 0;
	}
	public void printCart() {
		System.out.println("장바구니 상품 목록 :");
		System.out.println("----------------------------------------");
		System.out.println(" 	주문 ID \t|	수량 \t|	합계");
		
		for (int i=0 ; i< chickenItem.size();i++) {
			System.out.print("	" + chickenItem.get(i).getChickenID() + " \t| ");
			System.out.print("	" + chickenItem.get(i).getQuantity() + " \t| ");
			System.out.print("	" + chickenItem.get(i).getTotalPrice() + " \t| ");
			System.out.println("	");
		}
		System.out.println("----------------------------------------");
	}
	
}