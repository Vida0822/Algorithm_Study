package ch5_재귀알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 22.-오후 11:35:00
 *	@subject 재귀 알고리즘 분석하기 
 * @content  하향식 분석과 상향식 분석 


 */
public class Ex03 {
	
	static void recur(int n) {
		if(n > 0) {
			recur(n-1) ; 
			System.out.println(n);
			recur(n-2);  
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		System.out.print("정수를 입력하세요: ");
		int x = sc.nextInt() ; 
		
		recur(x) ; 

	} // main 
} // class
