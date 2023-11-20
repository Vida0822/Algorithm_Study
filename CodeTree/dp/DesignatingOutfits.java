package dp;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 11. 14.-오전 10:39:51
 *	@subject DP2 - 연속적이지만 직전 상황에 영향을 받는 dp 
 * @content  description 문제 
 * 사실상 직전 상황에 영향을 받는 순환식
 * 점화식 mind : 지금까지 입은 옷을 고려한 날짜, 마지막 날에 입은 옷이 모두 같다면, 
						지금까지 얻은 만족도가 클수록 더 좋다 

 */
public class DesignatingOutfits {
	
	public static final int INT_MIN = Integer.MIN_VALUE ; 
	public static final int MAX_N = 200 ; 
	public static final int MAX_M = 200 ; 

	public static int n , m  ;

	// 	public static int s, e, v ; 
	// public static int[][] a ;
	public static int[] s = new int[MAX_N+1] ;
	public static int[] e = new int[MAX_N+1] ;
	public static int[] v = new int[MAX_N+1] ;
	

	public static int[][] dp = new int[MAX_M+1][MAX_N+1] ;
	// dp[][] : m일차에 해당 outfit을 입었을 때 누적 만족도 점수 합  
	
	public static void initialize() {
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n ; j++) {
				dp[i][j] = INT_MIN;
			}
		}
		
		for (int j = 1; j <= n; j++) {
			if(s[j] == 1)
				dp[1][j] = 0 ; 
				// 만약 첫째날에 그 옷 입을 수 있으면 입히는 대신 만족도는 0 , 입을 수 없으면 만족도는 MIN_INT로 유지 
		}
	} // initialize
	
	public static void main(String[] args) {
		
		/* 
		 * 입력 받기 
		 */
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ;  // outfit 개수 
		m = sc.nextInt() ;  // 총 일수 
		
		// ** 여기가 중요 point : 각 옷에 대한 입을 수 있는 날짜 등을 인덱스에 맞춰 각각 배열로 나타냄 (이 아이디어 기억) 
		for (int i = 1; i <= n ; i++) {	
			s[i] = sc.nextInt() ; // i번째 옷의 입기 시작할 수 있는 날짜 
			e[i] = sc.nextInt() ; // i번째 옷의 입을 수 있는 마지막 날짜 
			v[i] = sc.nextInt() ; // 화려함 점수 (만족도 : 앞날과의 화려도 점수 차이)  
		} 
		
		/*
		 * dp 채우기 
		 */
		// 초기 설정 
		initialize(); 
		
		// dp 배열 채우기 (점화식) -- recursive 부분 
		for (int i = 2; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// i 번째날에 j번째 옷을 입을 때 얻을 수 있는 최대 만족도 (행렬) 
				
				for (int k = 1; k <= n; k++) {
					// k : i-1 번째날에 입은 옷 
					// 		; 전날 1~k번옷을 입었을 때 오늘 j번째 옷을 입은 경우 만족도 --> 그 중 최대가 i번째 날에 j번째 옷을 입었을 때의 최대 만족도   
					// ==> '직전 상황에 영향을 받는 순환식' : 전날 입은 옷의 종류에 따라 당일 옷의 만족도가 달라지니 이걸 따로 변수 k를 사용해 고려해줬어야함 
					if(s[k] <= i-1 && i-1 <= e[k] && s[j] <= i && i <= e[j]) 
						// k번째 옷을 입을 수 있었다면 (못입으면 그냥 INT_MIN으로 유지) 
						
						dp[i][j] = Math.max(dp[i][j] /* 전날 1 ~ k번 옷 입었을 경우 비교하며 최대값으로 update */
								, dp[i-1][k] + Math.abs(v[j] - v[k])) ; /* 점화식 */ 
				/*
				 * recursive의 중요 mind 
				 * : i 까지의 경우가 최선이라면, i-1까지의 경우도 최선의 선택들이었어야한다  
				 */
				}
			}
		}
		
		/*
		 * 답 출력 
		 */
		int ans = 0 ; 
		for (int i = 1; i <= n;  i++) {  
			ans = Math.max(ans, dp[m][i]) ;
			// m번째 날짜까지 전부 입을 옷을 결정햇을 때, 
			// 마지막 날에 입은 옷(1~j) 각각의 최대 만족도 가장 큰 값 ! 
		}
		System.out.println(ans); 			
	}
}
