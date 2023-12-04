package ch11_컬렉션프레임워크;

import java.util.*;

/**
 * @author HEEMIN
 * @date 2023. 9. 5.-오전 11:02:54
 *	@subject ArrayList 
 * @content  ArrayList에 CRUD 작업하기 
 */
public class ex01 {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1,4)) ;
		// subList : 하위 리스트를 만드는 메서드 => 기존 리스트의 요소 중 일부분으로 리스트 객체 만듬  
		print(list1,list2) ; 
		
		Collections.sort(list1); // Collections : 컬렉션 클래스의 작업을 도와주는 클래스 (컬렉션이 x) 
		Collections.sort(list2);
		print(list1, list2) ; 
		
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B"); 
		list2.add("C"); 
		list2.add(3,"A");
		
		print(list1, list2); 
		
		for (int i = list2.size()-1; i >=0 ; i--) {
			// 감소시키면서 비교해서 삭제 => 앞에서부터 삭제하면 해당 요소 삭제될때 빈 공간 채우려고 나머지 요소들 앞으로 땡김 
			// (index 3 --> 2   , 근데 2는 이미 검사 끝났으니까 그냥 넘어가는 결과) 
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}  // if 			
		} // for => list1과 list2 중복되는 요소 제거 (remove(index) ) 
		print(list1, list2) ; 	
	}

	private static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1); // 출력함수에 그냥 list 넣어주면 그대로 요소를 출력한다 
		System.out.println("list2:"+list2);
		System.out.println();	
	}
}
