package main;

import java.util.Scanner;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("*******정욱이닭 왕십리점 입니다.^^*******");
		
		System.out.println("주문자 성함을 입력해주세요. ");
		String name = scan.nextLine();
		System.out.println("주문자 주소를 입력해주세요. ");
		String address = scan.nextLine();
		System.out.println("연락처를 입력해주세요. ");
		int phone = scan.nextInt();
		scan.nextLine();
		
		
	}

}
