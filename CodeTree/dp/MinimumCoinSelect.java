package dp;

import java.util.Scanner;

public class MinimumCoinSelect {
	
	public static int n ; 
	public static int m ; 
	public static int[] coins = new int[100] ;  
	public static int[] dp = new int[10000] ; 
	// 이거 계속 틀림!!!! 채울 index가 1부터 시작하면 +1해서 크기 잡아줘야함 !!!!!!!


	public static void initialize() {
		coins[0] = 0 ; 
		dp[0] = 0 ; 
		
		for (int i = 1; i <= m; i++) {
			dp[i] = Integer.MAX_VALUE  ; 		
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		m = sc.nextInt() ;  
		
		initialize() ; 
		
		for (int i = 1; i <= n; i++) {
			coins[i] = sc.nextInt() ; 	
		} // for 
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n ; j++) {
		
				if(i >= coins[j]) {
					
					if(dp[i-coins[j]] == Integer.MAX_VALUE) {
						continue ; 
					}	
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1 ) ; 
				}
			}		
		} // for 
		System.out.println(dp[m] != Integer.MAX_VALUE? dp[m] : -1 );
	} // main 
} // class
