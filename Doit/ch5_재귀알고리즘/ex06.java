package ch5_재귀알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 23.-오전 11:05:34
 *	@subject 메모화 
 * @content 

 */
public class ex06 {
	
	static String[] memo ;  // 메모장 --> 배열을 활용 
	
	static void recur(int n) {
		
		if(memo[n+1] != null) {
			System.out.print(memo[n+1]);
		
		}else {
			if(n>0) {
				recur(n-1); 
				System.out.println(n);
				recur(n-2) ; 
				
				memo[n+1] = memo[n] + n +"\n" + memo[n-1] ; 
			}else {
				memo[n+1] = "" ;  
			} // if n 
		} // if memo 
	} // recur

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in ) ;
		
		System.out.print("정수를 입력하세요: ");
		int x = sc.nextInt();  
		
		memo = new String[x+2]; 
		recur(x) ; 

	} // main 
} // class 
