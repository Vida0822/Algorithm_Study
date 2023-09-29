package ch1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 8.-오후 10:59:13
 *	@subject 분기 : 중앙값 구하기 
 * @content 


 */
public class ex02_02 {

	static int med3(int a, int b, int c) {
		if( a >= b)
			if(b>=c)
				return b;
			else if(a<=c)
				return c; 
			else 
				return c; 
		else if (a>c)
			return a ; 
		else if (b>c)
			return c ; 
		else 
			return b; 
	} // med3
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		
		System.out.println("세 정수의 중앙값을 구합니다.");
		System.out.print("a의 값 : ");
		int a = sc.nextInt(); 
		
		System.out.print("b의 값 : ");
		int b = sc.nextInt(); 
		
		System.out.print("c의 값 : ");
		int c = sc.nextInt(); 
		
		System.out.println("중앙값은 "+ med3(a,b,c)+"입니다.");
		
	} // main

}
