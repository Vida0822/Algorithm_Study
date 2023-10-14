package dp;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 10. 14.-오후 6:56:24
 *	@subject dp 1번  - topdown & memoization 이용 
 * @content  피보나치 수열 (피보나치 수열의 n번째 값 찾기 ) 


 */
public class Fibonacci_Memoization {
	
	public static final int MAX__N = 45 ; 
	public static final int UNUSED = -1  ; 
			
	public static int[] memo = new int[MAX__N] ; 
	public static int n ; 
	
	public static void initializeMemo() {
		for (int i = 0; i < MAX__N; i++) {
			memo[i] = UNUSED ; 
		}
	}
	
	private static int fibonacci(int input) {
		
		if(memo[input] != UNUSED) {
			return memo[n] ; 
		}else if(input == 1 || input ==2) {
			return memo[n] = 1 ;  // 답이 있는 경우 
		}
		return memo[n] = fibonacci(n-1) + fibonacci(n-2) ;
		// 답이 없을 시 피보나치 수를 구하는 로직 (답을 구하는 로직)
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n= sc.nextInt() ; 
		
		initializeMemo(); 
		System.out.println(fibonacci(n)) ; 

	} // main



} // class 
