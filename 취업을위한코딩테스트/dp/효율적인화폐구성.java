package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 효율적인화폐구성 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ; 
		
		int[] coins = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			coins[i] = sc.nextInt() ;
		}
		
		// 점화식 
		// i 금액을 만들 때, a(i-k)를 만드는 방법이 존재하는 경우 a(i) = min: a(i), a(i-k) 
		
		
		int[] dp = new int[m+1] ; 
		Arrays.fill(dp, 10001);
		dp[0] = 0 ; 
		
		for(int i = 1 ; i < n ; i ++) { 
			// 모든 화폐 단위에 대해 차례대로 적용
			for(int j = coins[i] ; j <= m ; j++) { 
				// 1개 사용했을때 금액부터 1씩 증가하면서 (3, 4, 7) 
				if(dp[j-coins[i]] != 10001)
					// 만들 금액(j)에서 coin 액수 만큼 뺀 금액을 만들 수 있으면 
					dp[j] = Math.min(dp[j], dp[j-coins[i]]+1) ; 			
			}
		}
		System.out.println(dp[m] == 100001? -1 : dp[m]);
		
		

	}

}
