package dp;

import java.util.Scanner;

public class 금광 {
	
	public static void dp() {
		Scanner sc = new Scanner(System.in) ; 
		
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ; 
		int[][] gold = new int[n+2][m+2] ; // 둘레를 한칸씩 비워두고 0으로 초기화하여 index 오류 방지 
		int[][] dp = new int[n+2][m+2] ; 
		
		// 금광 만들기 
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				gold[i][j] = sc.nextInt() ; 
			}
		}
		
		// dp 수행 - 점화식 : dp[i][j] = dp[i-1 ~ i+1][j-1] + gold[i][j] 
		for(int j = 1 ; j <= m ; j++) {
			for(int i = 1 ; i <= n ; i++) {
				int max = 0 ; 
				max = Math.max( Math.max(dp[i-1][j-1], dp[i][j-1]), dp[i+1][j-1]) ; 
				/*for(int k = i-1 ; k <= i+1 ; k++) {
					max = Math.max(max, dp[k][j-1]) ; 
				}*/
				dp[i][j] = max + gold[i][j] ; 
			}
		}
			
		
		// 최종 답 출력 
		int answer = 0 ; 
		for(int i = 1 ; i <= n ; i++) {
			answer = Math.max(answer, dp[i][m]) ;
		}
		System.out.println(answer);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int T = sc.nextInt() ; 

		for(int i = 1 ; i <= T ; i++) {
			dp() ; 
		}
	} 

}
