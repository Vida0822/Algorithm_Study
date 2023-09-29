package ch3_배열검색;

public class GenericClassTester {
	
	static class GenericClass<T>{
		
		private T xyz ; 
		
		GenericClass(T t){
			this.xyz = t ; 
		}
		T getXyz() {
			return xyz ; 
		}
	}

	public static void main(String[] args) {
		
		
		// 이렇게 하나의 생성자로 여러개의 자료형값을 입력받을 수 잇음 (String 생성자, Integer생성자 따로 안만들어줘도됨) 
		GenericClass<String> s = new GenericClass<String>("ABC") ; // 자료형을 전달 받음 
		GenericClass<Integer> n = new GenericClass<Integer>(15) ; 
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
		
		

	} // main 
} // class
