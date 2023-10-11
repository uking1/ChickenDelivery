package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

import cart.Cart;
import member.Customer;
import menu.ChickenMenu;
import member.Admin;
import exception.CartException;

public class Main {

	static Cart cart = new Cart();
	static Customer user; // 사용자

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<ChickenMenu> menuInfoList;
		int totalChickenMenu = 0;

		System.out.println("*******정욱이닭 왕십리점 입니다.^^*******");

		System.out.print("주문자 성함을 입력해주세요. ");
		String name = scan.nextLine();
		System.out.print("연락처를 입력해주세요. ");
		String phoneStr = scan.nextLine(); // nextLine()을 사용하여 문자열로 입력 받음
		int phone = Integer.parseInt(phoneStr);

		// 사용자 정보 저장
		user = new Customer(name, phone);

		boolean flag = false; // 무한반복
		
		while (!flag) {
			
			menuIntroduction();

			try {
				
				System.out.println("메뉴 번호를 선택해주세요.");
				
	            int num = Integer.parseInt(scan.nextLine()); 
				
				if (1 > num || num > 8) {
					System.out.println("1부터 8까지의 숫자를 입력해주세요");
				} else {
					switch (num) {
					case 1:
						// 1.고객정보 확인하기
						GuestInfo(name, phone); // 고객정보 출력
						break;
					case 2:
						// 2.장바구니 상품 목록 보기
						CartItemList();
						break;
					case 3:
						// 3.장바구니 비우기
						CartClear();
						break;
					case 4:
						// 4.장바구니에 항목 추가하기
						totalChickenMenu = totalFileToChickenMenu();
						menuInfoList = new ArrayList<ChickenMenu>();
						CartAddItem(menuInfoList);
						break;
					case 5:
						// 5. 장바구니의 항목 삭제하기
						CartRemoveItem();
						break;
					case 6:
						// 6. 영수증 표시하기(주문하기)
						CartBill();
						break;
					case 7:
						// 7. 종료
						Exit();
						flag = true;
						break;
					case 8:
						// 8. 관리자 로그인(신메뉴 추가용도)
						AdminLogin();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 선택으로 종료합니다.");
				flag = true;
			}
		}
	}

	public static void AdminLogin() { // 관리자 로그인(신메뉴 추가)
		System.out.println("관리자 정보를 입력하세요. ");
		System.out.print("아이디 : ");
		String adminId = scan.next();

		System.err.print("비밀번호 : ");
		String adminPw = scan.next();

		Admin admin = new Admin(user.getName(), user.getPhone());
		if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPassWord())) {
			String[] writeMenu = new String[5];
			System.out.println("신메뉴를 추가하겠습니까? Y | N");
			String input = scan.next();

			if (input.equalsIgnoreCase("Y")) {

				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); // 출시일
				String strDate = formatter.format(date);

				System.out.print("메뉴 ID : "); // menu1 ~ ...
				writeMenu[0] = scan.next();
				System.out.print("메뉴명 : ");
				writeMenu[1] = scan.next();
				System.out.print("가격 : ");
				writeMenu[2] = scan.next();
				System.out.print("설명 : ");
				writeMenu[3] = scan.next();
				writeMenu[4] = strDate; // 출시일(작성하는 기준날짜로 설정)
				try {
					FileWriter fw = new FileWriter("menu.txt", true);

					for (int i = 0; i < 5; i++) {
						fw.write(writeMenu[i] + "\n");
					}
					fw.close();
					System.out.println("새 메뉴 정보가 저장되었습니다.");
				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				System.out.println("이름 : " + admin.getName() + ", 연락처 : " + admin.getPhone());
				System.out.println("아이디 : " + admin.getId() + ", 비밀번호 : " + admin.getPassWord());
			}
		} else {
			System.out.println("관리자 정보가 일치하지 않습니다.");
		}
		scan.nextLine();// 버퍼제거
	}

	public static void Exit() { // 종료
		System.out.println("종료 되었습니다.");
	}

	public static void CartBill() throws CartException { // 영수증 출력(주문하기)
		if (cart.cartCount == 0) {
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("배송받을 분은 고객정보와 같습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			if (str.equalsIgnoreCase("Y")) {
				System.out.print("배송지를 입력해주세요.");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드 호출
				printBill(user.getName(), String.valueOf(user.getPhone()), address);
			} else {
				System.out.print("배송받을 고객명을 입력하세요.");
				String name = input.nextLine();
				System.out.print("배송받을 고객의 연락처를 입력하세요.");
				String phone = input.nextLine();
				System.out.print("배송받을 고객의 배송지를 입력하세요.");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드 호출
				printBill(name, phone, address);
			}
		}
	}

	public static void printBill(String name, String phone, String address) { // 배송지 출력
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("---------------------배송 받을 고객 정보---------------------");
		System.out.println("고객명 : " + name + "   \t\t\t연락처 : " + phone);
		System.out.println("배송지 : " + address + "\t발송일 : " + strDate);
		// 장바구니에 담긴 항목 출력
		cart.printCart();

		// 장바구니에 담긴 항목의 총 금액 계산
		totalPrice();
	}

	public static void CartRemoveItem() throws CartException { // 장바구니 항목 삭제
		if (cart.cartCount == 0) {
			throw new CartException("장바구니에 항목이 없습니다. ");
		} else {
			CartItemList();
			boolean flag = false;
			while (!flag) {
				System.out.println("장바구니에서 삭제할 치킨 메뉴를 입력하세요. :");
				String str = scan.nextLine();
				boolean findFlag = false;
				int numId = -1;

				for (int i = 0; i < cart.cartCount; i++) {
					if (str.equals(cart.chickenItem.get(i).getChickenID())) {
						numId = i;
						findFlag = true;
						break;
					}
				}

				// 해당 치킨 메뉴를 찾았을 때 처리 추가
				if (findFlag) {
					System.out.println(cart.chickenItem.get(numId).getChickenID() + "을(를) 장바구니에서 삭제했습니다.");
					cart.removeCart(numId);
					flag = true; // while 종료
				} else {
					System.out.println("장바구니에 해당 메뉴가 없습니다. 다시 입력하세요.");
				}
			}
		}
	}

	public static void CartAddItem(ArrayList<ChickenMenu> menu) { // 장바구니 항목 추가
		chickenList(menu);

		cart.printCart();
		boolean flag = false;

		while (!flag) {
			System.out.println("장바구니에 추가할 치킨의 메뉴를 입력하세요.(1을 입력하면 종료):");
			String str = scan.nextLine();

			if (str.equals("1")) {
				flag = true; // 1을 입력하면 종료
				continue;
			}

			boolean findFlag = false;
			int numId = -1;

			for (int i = 0; i < menu.size(); i++) {
				if (str.equals(menu.get(i).getMenuId())) {
					numId = i;
					findFlag = true;
					break;
				}
			}

			if (findFlag) {
				System.out.println("장바구니에 추가하겠습니까? Y | N");
				String inputStr = scan.nextLine();
				if (inputStr.equalsIgnoreCase("Y")) {
					System.out.println(menu.get(numId).getMenuId() + "을(를) 장바구니에 추가했습니다.");
					// 장바구니에 넣기
					if (!isCartInChicken(menu.get(numId).getMenuId())) {
						cart.insertChicken(menu.get(numId));
					}
				}
			} else {
				System.out.println("다시 입력해 주세요. ");
			}
		}
	}

	public static void CartClear() throws CartException { // 장바구니 항목 모두 삭제
		if (cart.cartCount == 0) {
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("장바구니에 모든 항목을 삭제하시겠습니까? (Y | N)");
			String ans = scan.nextLine();
			if (ans.equalsIgnoreCase("Y")) {
				System.out.println("장바구니의 모든 항목을 삭제했습니다. ");
				cart.deleteCart();
			}
		}
	}

	public static void CartItemList() { // 장바구니 항목 보기
		if (cart.cartCount >= 0) {
			cart.printCart();
		}
		totalPrice(); // 주문 총 금액 출력
	}

	public static void GuestInfo(String name, int phone) { // 입력한 손님 정보 보기
		System.out.println("현재 고객 정보");
		System.out.printf("이름 :%s \n", user.getName());
		System.out.printf("연락처 :%d \n", user.getPhone());
	}

	public static void menuIntroduction() {
		System.out.println("************************************************");
		System.out.println("\t\t" + "정욱이닭 왕십리점 입니다.^^");
		System.out.println("************************************************");
		System.out.println("1.고객정보 확인하기  \t\t 4.장바구니에 메뉴 추가하기");
		System.out.println("2.장바구니 상품 목록 보기\t\t 5.장바구니의 항목 삭제하기");
		System.out.println("3.장바구니 비우기   \t\t 6.영수증 표시하기");
		System.out.println("7.종료   \t\t\t 8.관리자 로그인");
		System.out.println("************************************************");
	}

	public static void chickenList(ArrayList<ChickenMenu> menu) {
		setFileToChickenMenu(menu);

		System.out.println("메뉴 목록 :"); // 메뉴 목록 출력
		for (ChickenMenu data : menu) {
			System.out.println(data.toString());
		}

	}

	public static int totalFileToChickenMenu() {
		try {
			FileReader fr = new FileReader("menu.txt");
			BufferedReader br = new BufferedReader(fr);

			String str;
			int num = 0; // 치킨메뉴의 갯수
			while ((str = br.readLine()) != null) {
				if (str.contains("menu")) {
					++num;
				}
			}
			br.close();
			fr.close();
			return num;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public static void setFileToChickenMenu(ArrayList<ChickenMenu> menuList) {
		try {
			FileReader fr = new FileReader("menu.txt");
			BufferedReader br = new BufferedReader(fr);

			String chickenId;
			String[] readChicken = new String[5];
			int count = 0;

			while ((chickenId = br.readLine()) != null) {
				if (chickenId.contains("menu")) {
					readChicken[0] = chickenId; // 메뉴ID (menu1 ~ ...)
					readChicken[1] = br.readLine(); // 메뉴명
					readChicken[2] = br.readLine(); // 가격
					readChicken[3] = br.readLine(); // 설명
					readChicken[4] = br.readLine(); // 출시일
				}
				ChickenMenu menu = new ChickenMenu(readChicken[0], readChicken[1], Integer.parseInt(readChicken[2]),
						readChicken[3], readChicken[4]);
				menuList.add(menu);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static boolean isCartInChicken(String chickenId) { // 장바구니에 항목 있는지 확인
		return cart.isCartInChicken(chickenId);
	}

	public static void totalPrice() { // 총 금액 출력
		int sum = 0;
		for (int i = 0; i < cart.cartCount; i++) {
			sum += cart.chickenItem.get(i).getTotalPrice();
		}
		System.out.println("\t\t\t주문 총금액 : " + sum + "원\n");
		System.out.println("----------------------------------------------------------");
		System.out.println();
	}
}