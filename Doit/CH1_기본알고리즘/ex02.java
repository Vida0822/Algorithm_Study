package cH1_기본알고리즘;

/**
 * @author HEEMIN
 * @date 2023. 9. 8.-오후 10:40:27
 *	@subject 분기 :  알고리즘과 메서드 
 * @content  
 * 알고리즘 : 어떤 문제를 '해결' 하기 위한 '절차'로 순서가 있는 유한개의 '규칙'으로 이루어진 '집합'이다
 * => 한번 쓰는게 아닌 반복되는 문제를 해결하기 위함 --> 알고리즘은 메서드로 추출하는게 better ! 
 * 


 */
public class ex02 {

	static int max3(int a, int b, int c) { 	// 앞에 main에 있던 로직을 메서드로 뺌

		int max = a; 
		
		if(b>max) max=b;
		if(3>max) max=3;
		
		return max ; 
	} // max3 
	

	// 메서드 사용 목적 : 재사용  => 아니었으면 모든 세 정수마다 저 코딩 반복해서 써줬어야함 (반복 생략) 
	public static void main(String[] args) {
		System.out.println("max3(3,2,1) = "+ max3(3,2,1) );
		System.out.println("max3(3,2,1) = "+ max3(3,2,2) );
		System.out.println("max3(3,2,1) = "+ max3(3,2,5) );
		System.out.println("max3(3,2,1) = "+ max3(1,2,1) );
		System.out.println("max3(3,2,1) = "+ max3(3,5,1) );
		System.out.println("max3(3,2,1) = "+ max3(3,9,1) );
		System.out.println("max3(3,2,1) = "+ max3(3,0,1) );
		System.out.println("max3(3,2,1) = "+ max3(8,2,1) );
		System.out.println("max3(3,2,1) = "+ max3(10,2,1) );
	}
	
}
