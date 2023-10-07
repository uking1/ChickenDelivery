package menu;

public class ChickenMenu {
	private String ChickenMenu; // 치킨메뉴
	private int price; //치킨가격
	
	public ChickenMenu() {
		
	}

	public ChickenMenu(String chickenMenu, int price) {
		super();
		this.ChickenMenu = chickenMenu;
		this.price = price;
	}

	public String getChickenMenu() {
		return ChickenMenu;
	}

	public void setChickenMenu(String chickenMenu) {
		ChickenMenu = chickenMenu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
