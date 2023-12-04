package ch11_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HEEMIN
 * @date 2023. 9. 5.-오후 12:41:15
 *	@subject ArrayListLinkedList
 * @content 


 */
public class ex05 {
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(200000) ; 
		LinkedList ll = new LinkedList() ;
		
		System.out.println("= 순차저으로 추가하기 = "); // 그냥 정의하는 클래스 (실행부가 없는 클래스) 에선 출력함수를 쓸 수 없다 
		System.out.println("ArrayList : "+ add1(al) );
		System.out.println("LinkedList : "+ add1(ll));
		
		System.out.println("= 중간에 추가하기 = "); 
		System.out.println("ArrayList : "+ add2(al) ); // 덮어쓰기됨 
		System.out.println("LinkedList : "+ add2(ll)); // 덮어쓰기됨 
		
		System.out.println("= 중간에서 삭제하기 = "); 
		System.out.println("ArrayList : "+ remove2(al) );
		System.out.println("LinkedList : "+ remove2(ll));
		
		System.out.println("= 순차적으로 삭제하기 = "); 
		System.out.println("ArrayList : "+ remove1(al) );
		System.out.println("LinkedList : "+ remove1(ll));
		
				
	}

	private static long remove1(List list) {

		long start = System.currentTimeMillis(); 
		for (int i = list.size()-1; i >= 0; i--) {
			list.remove(i); 
		}
		long end = System.currentTimeMillis(); 
		return end - start ;
	}

	private static long remove2(List list) {
		long start = System.currentTimeMillis() ;  
		for (int i = 0; i < 10000; i++) { // index를 1씩 증가시키면서 삭제하면 앞으로 땡겨지면서 '배열이 복사되어 새로 생김' <-> 중간부터 삭제하기 
			list.remove(i);   // 0~10000까지 삭제 
		}
		long end = System.currentTimeMillis(); 
		return end-start;
	} // remove2
	
	
	


	private static long add1(List list) {
		long start = System.currentTimeMillis(); // 작업 전 현재시간: 현재 시간을 밀리초로 반환하는 메서드 
		for (int i = 0; i < 1000000; i++) {
			list.add(i+"") ;  // 0 ~ 1000000 까지 차곡차곡 채우기 
		} // for 
		
		long end = System.currentTimeMillis();  // 작업 후 현재시간 
		return end-start ;
	} // add1
	
	private static long add2(List list) {

		long start = System.currentTimeMillis() ; 
		for (int i = 0; i < 10000; i++) {
			list.add(500, "X");  // 500번째부터 10000번 "X" 로 채운다 
		}
		long end = System.currentTimeMillis(); 
		return end - start ; 
	} // add2
}
