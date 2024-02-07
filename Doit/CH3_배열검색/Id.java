package cH3_배열검색;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 4:29:26
 *	@subject 클래스 메서드와 인스턴스 메서드 
 * @content 
클래스 메서드 : 특정 인스턴스에 속하지 않고 클래스 전체에 대한 처리 (전역적 처리) 또는 클래스의 개별 인스턴스와 관계없는 처리를 할 때 사용한다.   

 */
public class Id {
	
	// 클래스 변수와 인스턴스 변수 
	private static int counter = 0 ;  // 그냥 이 클래스 자체에 값이 초기화 되어있는 애 ! --> 어떤 인스턴스에서 접근해도 같은 값 (설계도에서 정해진 값) 
	private int id ;  // 매 인스턴스 생성할때마다 초기화됨  (구현할 때 정해지는 값) 
	
	public Id() {
		id = ++ counter ; 
	}
	
	// 클래스 메서드와 인스턴스 메서드 
	public static int getCounter() {
		return counter ; 
	}
	
	public int getID() {
		return id; 
	}
	
	public static void main(String[] args) {
		
		Id a= new Id() ; 
		Id b = new Id() ; 
		
		System.out.println("a의 아이디: "+ a.getID()); // 각 자동차에서 가져와야함 
		System.out.println("b의 아이디: "+ b.getID()); // 인스턴스 메서드 사용 : 클래스형 변수(인스텬스 담은 참조변수)이름.메서드이름() 
		
		System.out.println("부여한 아이디의 개수: "+ Id.getCounter()); // 클래스 메서드 사용 : 클래스이름.메서드이름()
		
		

	} // main 

} // class 
