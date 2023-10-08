package cart;

import menu.ChickenMenu;

public class CartItem {
	private ChickenMenu menu;
	private String chickenID; // 치킨 ID
	private int quantity; // 치킨 수량
	private int totalPrice; // 치킨 가격 합계
	
	public CartItem() {
		
	}

	public CartItem(ChickenMenu menu) {
		this.menu = menu;
		this.chickenID = menu.getChickenMenu();
		this.quantity = 1;
		updateTotalPrice();
		
	}
	
	
	

	public void updateTotalPrice() {
		totalPrice = this.menu.getPrice() * this.quantity;
		
	}

	public ChickenMenu getMenu() {
		return menu;
	}

	public void setMenu(ChickenMenu menu) {
		this.menu = menu;
	}

	public String getChickenID() {
		return chickenID;
	}

	public void setChickenID(String chickenID) {
		this.chickenID = chickenID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
