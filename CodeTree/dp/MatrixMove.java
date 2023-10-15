package dp;

public class MatrixMove {
	
	public static int n = 4 ;
	public static int[][] a = { // 문제 격자 (로직 적용할 값 ; 더할 값) 
			{4},
			{6,2},
			{3,7,9},
			{3,4,9,9}
	} ; 
	
	public static int [][] dp = new int[4][4] ;  // 메모 격자 (문제 적용한 값 ; 더한 값) 
	 
	public static void initialize() { // 초기조건 (초기에 확실히 채워줄 수 있는 값들) 
		dp[0][0] = a[0][0] ; 
		
		for (int i = 1; i < n ; i++) { // 1열 
			dp[i][0] = dp[i-1][0] + a[i][0] ; 
		}
		for (int i = 1; i < n ; i++) {
			dp[i][i] = dp[i-1][i-1] + a[i][i] ; 
		}
	} // initialize

	public static void main(String[] args) {
		
		initialize();
		
		for (int i = 2; i < n; i++) {  // 점화식으로 채워와야하는 값  : (2, 1) 부터 채움
			// 2행 -> 오른쪽 칸들 채우기 (남은 1칸 ; j ) 
			// -> 3행 -> 오른쪽 칸들 채우기  (3칸 ; j) 
			// -> 4행 -> 오른쪽 칸들 채우기 (4칸 ; j) -> 종료 
			for (int j = 1; j < i ; j++) {  // i번째 칸은 오른쪽 끝 대각선이므로 이미 채워져있음
				// 행의 값들을 먼저 채우고, 다음 행으로 넘어감 
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + a[i][j] ; 	
			}
		} // for 
	} // main 
} // class
