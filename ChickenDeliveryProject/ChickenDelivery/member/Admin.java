package member;

public class Admin extends Customer {
	private String id = "Admin"; //관리자 ID
	private String passWord = "Admin1"; //관리자 PassWord

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
