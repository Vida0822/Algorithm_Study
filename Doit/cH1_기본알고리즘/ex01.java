package cH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 8.-오후 10:27:59
 *	@subject 분기 : 입력된 세 정수중 최대값을 구하는 로직 
 * @content  순차구조와 선택구조 


 */
public class ex01 {
	
	public static void main(String[] args) {
		
		// 순차구조 
		Scanner sc = new Scanner(System.in) ; 
		
		System.out.println("세 정수의 최댓값을 구합니다.");
		
		System.out.println("a의 값 : "); int a = sc.nextInt() ; 
		System.out.println("b의 값 : "); int b = sc.nextInt() ; 
		System.out.println("c의 값 : "); int c = sc.nextInt() ;
		
		int max = a; 
		
		// 선택구조 
		if(b>max) max = b; // 갱신 or 유지 
		if(c>max) max = c;  // 갱신or 유지 
		
		
	}

}
