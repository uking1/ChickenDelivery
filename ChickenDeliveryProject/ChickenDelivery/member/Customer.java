package member;

public class Customer {
	private String name; //주문자 성함
	private int phone; //주문자 연락처
	private String address; //주문자 주소

	public Customer() {

	}
	
	public Customer(String name, int phone) {
		this.name = name;
		this.phone = phone;
	}

	public Customer(String name, int phone, String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
