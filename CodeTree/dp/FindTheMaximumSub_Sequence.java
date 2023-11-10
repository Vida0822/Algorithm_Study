package dp;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 11. 10.-오후 8:19:35
 *	@subject dp2 - Find the Maximum Sub-Sequence 
 * @content description 문제 풀이 


 */
public class FindTheMaximumSub_Sequence {
	
	public static int n ; 
	public static int[] a ; 
	public static int[] dp ; 
	
	public static void initialize(Scanner sc) {
	
		a = new int[n+1] ; 
		dp = new int[n+1] ; 
		
		for (int i = 1; i <= n ; i++) {
			a[i] = sc.nextInt() ; 
			dp[i] = Integer.MIN_VALUE ; 
		}
		dp[1] = a[1] ;  
	} // initialize 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt() ; 
		
		// 1. 초기화 (초기조건 반영) 
		initialize(sc) ; 
	
		
		// 2. 각 자리수 별 최대합 구하기 (dp 채우기) 	
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1] + a[i], a[i]) ; 
		}
		
		// 3. 최종 합 도출 
		int ans = Integer.MIN_VALUE ; 
		for (int i = 1; i < dp.length; i++) {
			ans = Math.max(ans, dp[i]) ; 
		}
		
		System.out.println(ans);
		
	} // main 
} // class 
