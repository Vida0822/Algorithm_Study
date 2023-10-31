package dp;

import java.util.Scanner;

public class IncreasingSubsequence {
	
	public static final int INT_MIN = Integer.MIN_VALUE ; 
	public static final int MAX_NUM = 1000 ; 
	
	public static int n ; 
	public static int[] a = new int[MAX_NUM + 1] ; // 뽑은 원소들 
	public static int[] dp = new int[MAX_NUM + 1] ;
	// 마지막으로 고른 원소의 위치가 i인 부분수열 중 최장 부분 수열의 길이 
	
	public static void initialize() {
		for (int i = 0; i < n ; i++) {
			dp[i]= INT_MIN ; 
		}
		dp[0] = 0; 
		// dp 가 순열 길이를 i개라고 가정했으므로 i번째 '위치'를 기준으로 최장길이를 기록하기 때문에 (3번째 --> dp[3] ) 
		// 0번째 위치까지 최대 증가부분 수열길이는 0으로 설정 
		a[0] = 0;  
		//  dp에 맞춰 값을 바로 갱신할 수 있도록 a[0]을 새롭게 넣어줌 
	}
	
	public static void main(String[] args) {
		
		// part 1. 순열 만들기  
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt() ; 
		}
		initialize();
	
		// part 2. Tabulation (배열 순차적으로 채우기) 
		for (int i = 1; i <= n ; i++) {
			for (int j = 0; j < i ; j++)  { // i번째 노드 앞 노드까지 검색하니까 
				if(a[j] < a[i]) // a[i]보다는 값이 작은 것을 골라 
					dp[i] = Math.max(dp[i], dp[j]+1) ;
					// 새로운 원소인 a[i]를 추가했을 때의 부분 수열 중 최대 부분 수열의 길이를 계산한다 
			}
		} // for 
		
		// part 3. 최대값 출력 
		int answer = 0 ; 
		for (int i = 0; i <= n; i++) {
			answer = Math.max(answer, dp[i]) ;
		}
		System.out.println(answer); 	
	} // main 


} // class 
