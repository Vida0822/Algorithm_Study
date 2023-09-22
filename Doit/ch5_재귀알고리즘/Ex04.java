package ch5_재귀알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 22.-오후 11:38:29
 *	@subject 비재귀적 표현 
 * @content  꼬리 재귀의 제거 


 */
public class Ex04 {
	
	static void recur(int n) {
		while(n > 0) {
			recur(n-1) ; 
			System.out.println(n);
			n = n-2 ; 
		}
	} // recur
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		System.out.print("정수를 입력하세요: ");
		int x = sc.nextInt() ; 
		
		recur(x) ; 

	} // main 

}
