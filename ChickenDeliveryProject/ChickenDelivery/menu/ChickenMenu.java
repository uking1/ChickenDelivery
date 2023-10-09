package menu;

public class ChickenMenu {
	private String menuId; // 메뉴 Id
	private String ChickenMenu; // 치킨메뉴
	private int price; // 치킨가격
	private String description; // 설명
	private String releaseDate; // 출시일

	public ChickenMenu() {

	}


	public ChickenMenu(String menuId, String chickenMenu, int price, String description, String releaseDate) {
		super();
		this.menuId = menuId;
		this.ChickenMenu = chickenMenu;
		this.price = price;
		this.description = description;
		this.releaseDate = releaseDate;
	}

	
	public String getMenuId() {
		return menuId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return "[" + menuId + " | " + ChickenMenu + " | " + price + " | "
				+ description + " | " + releaseDate + "]";
	}
	
	

}
