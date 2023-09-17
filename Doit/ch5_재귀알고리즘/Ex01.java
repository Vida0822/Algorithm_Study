package ch5_재귀알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 7:33:21
 *	@subject 재귀호출 
 * @content  factorial 구현


 */
public class Ex01 {
	
	static int factorial(int n) {
		if(n>0)
			return n*factorial(n-1) ;  // 메서드 factorial은 자기자신과 똑같이 생긴 메서드 factorial을 호출한다 <-> 재귀호훌
		else
			return 1; 
	} // factorial
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		System.out.print("정수를 입력하세요: ");
		int x = sc.nextInt(); 
		
		System.out.println(x +"의 팩토리얼은 "+factorial(x) + " 입니다. ");
		
	}

}
