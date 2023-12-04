package ch11_컬렉션프레임워크;

import java.util.Vector;

/**
 * @author HEEMIN
 * @date 2023. 9. 5.-오전 11:46:01
 *	@subject Vector
 * @content  Vector의 size와 capacity 


 */
public class ex03 {
	
	public static void main(String[] args) {
		
		Vector v = new Vector(5) ; 	
		
		v.add("1"); 
		v.add("2"); 
		v.add("3");
		print(v) ; // size = 3 , capacity = 5 
		
		v.trimToSize(); 
		System.out.println("===After trimToSize() ===");
		print(v);  // size = 3, capacity = 3
		
		v.ensureCapacity(6); // capacity 지정 
		System.out.println("===After ensureCapacity()==");
		print(v); // size = 3, capacity = 6
		
		v.setSize(7); // size 지정 
		System.out.println("=== After setSize(7) === ");
		print(v);  // size = 7 , capacity = 7  (새로운 객체배열 생성 ) x -->12 : Vector는 capacity가 부족할 경우 자동적으로 기존의 크기보다 2배의 크기로 증가 ! 
		
		v.clear();
		System.out.println("=== After clear() === ");
		print(v) ; 	// size = 0 , capacity = 7 --> 12
	}

	private static void print(Vector v) {
		System.out.println(v) ; 
		System.out.println("size : "+ v.size()); // size : 실제 저장된 객체의 수 
		System.out.println("capacity : "+ v.capacity()); // capacity : 저장 가능한 총 용량 
	} // print 

}
