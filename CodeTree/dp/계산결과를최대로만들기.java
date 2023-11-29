package dp;

/**
 * @author HEEMIN
 * @date 2023. 11. 25.-오후 3:29:34
 *	@subject dp(2) - 원하는 State를 정의하여 한 칸씩 나아가는 DP 
 * @content  Introduction 문제 - 계산 결과를 최대로 만들기 

* dp[i][j] : i 번째 숫자까지 고려했고 지금까지 숫자를 정확히 j개 골랐다고 했을 때 얻을 수 있는 최대 결과 
* 점화식 
	DP[i][j] 
	- if j = 0 --> DP[i-1][j] 
	 : i 번째 숫자까지 고려했는데 숫자를 아무것도 고려하지 않았다는 것은 i-1번째 숫자까지도 어떤 숫자도 고려하지 않았음을 의미
	  <-> 아무 숫자도 고려하지 않았다는 것은 그 어떤 숫자를 빼지도, 더하지도 않았음을 의미 => 0이 대입됨  
	- if j is odd --> max(DP[i-1][j] , DP[i-1][j-1] + a[i]) 
	- if j is even --> max(DP[i-1][j], DP[i-1][j-1] - a[i] ) 

 */
public class 계산결과를최대로만들기 {
	
	public static final int INT_MIN = Integer.MIN_VALUE ; 
	public static final int n = 2 ; 
	
	public static int[] a = new int[] {0, 2, 4, 1, 6} ;
	public static int [][] dp = new int[2*n+1][2*n+1] ; 
	
	public static void initialize() {
		for (int i = 0; i <= 2*n; i++) {
			for (int j = 0; j <= 2 * n ; j++) {
				dp[i][j] = INT_MIN ; 
			}
		}
		dp[0][0] = 0; 
		for (int i = 1; i <= 2*n ; i++) {
			dp[i][0] = dp[i-1][0] ; 
		}
	} // initialize
			
	
	public static void main(String[] args) {
		initialize(); 

		for (int i = 1; i <= 2*n ; i++) {
			for (int j = 1; j <= i; j++) {
				// 점화식 부분 
				if(j%2 == 1) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+ a[i]) ; 
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - a[i]) ; 
				}
			}  // j 
		} // i 
	} // main 
} // class 
