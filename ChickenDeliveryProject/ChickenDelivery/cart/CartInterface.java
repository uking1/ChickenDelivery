package cart;

import menu.ChickenMenu;
import java.util.ArrayList;

public interface CartInterface {
	
	void printChickenList(ArrayList<ChickenMenu> chickenList); // 전체 치킨 정보 목록 출력
	boolean isCartInChicken(String id); // 장바구니에 담긴 갯수를 1씩 증가
	void insertChicken(ChickenMenu c); // ChickenItem에 치킨 정보를 등록
	void removeCart(int numId); // 장바구니 순번 numId 의 항목 삭제
	void deleteCart(); // 장바구니의 모든 항목을 삭제
}	
