package member;

public class Admin extends Customer {
	private String id = "Admin";
	private String passWord = "Admin";

	public Admin(String name, int phone) {
		super(name, phone);

	}

	public String getId() {
		return id;
	}

	public String getPassWord() {
		return passWord;
	}

}
