package dp;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 10. 14.-오후 7:13:41
 *	@subject dp 1번 - bottomUp & 배열 채우기 
 * @content  피보나치 수열 (피보나치 수열의 n번째 값 찾기 ) 


 */
public class Fibonachi_Tabulation {
	
	public static final int MAX_NUM = 45 ; 
	
	public static int n ; 
	public static int[] dp = new int[MAX_NUM+1] ; // index와 n의 값을 일치시켜줄 거기 때문에 (1의 피보나치 수열 --> dp[1] = ** ) 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		
		dp[1] = 1; 
		dp[2] = 1; 
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2] ; 
		}
		System.out.println(dp[n]);	
	}
} // class
