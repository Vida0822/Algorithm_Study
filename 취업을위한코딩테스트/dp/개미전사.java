package dp;

import java.util.Scanner;

public class 개미전사 {

	public static void main(String[] args) {

		// 식량 창고 채우기
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt(); 
		int[] foods = new int[n]; 

		for(int i = 0 ; i < n ; i++) {
			foods[i] = sc.nextInt() ; 
		}
		
		// 점화식 
//		i번째칸까지의 최댓값 : i-1번까지의 최댓값 or i-2번까지의 최댓값 + i번째 식량
		int[] dp = new int[n] ; 
		dp[0] = foods[0] ; 
		dp[1] = foods[1] ; 
		
		for(int i = 2 ; i < n ; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+foods[i]); 
		}
		System.out.println(dp[n-1]);
	}
}
