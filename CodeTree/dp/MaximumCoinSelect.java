package dp;

public class MaximumCoinSelect {
	
	public static final int INT_MIN = Integer.MIN_VALUE ; 
	public static final int n = 3 , m = 8 ; 
	public static int[] coin = new int[] {0,2,3,5}  ; 
	public static int[] dp = new int[m+1] ; 
	
	public static void initialize() {
		for (int i = 0; i <= m; i++) {
			dp[i] = INT_MIN ; 
		}
		dp[0] = 0;
	}
	
	public static void main(String[] args) {
		initialize() ; 
		
		for (int i = 1; i <= m ; i++) { // dp[] 채우기 
			for (int j = 1; j <= n ; j++) { // 동전이 각각 j번째에 왔을때,  
				
				if( i >= coin[j]) {
					if(dp[i - coin[j]] == INT_MIN)
						continue ;  
					// 건너뛰어도 괜찮? oo tabulation의 본질은 배열의 작은 index부터 채워나가는 것 
					// dp[i] 보다 작은 index의 값이 없으면 그건 그 값을 채우는게 불가능했던거임 (그 합을 동전으로 만들 수 없음) 
				}
				dp[i] = Math.max(dp[i], dp[i-coin[j]]+1 ) ; // 최대값으로 계속 초기화 
			}
		}
		int ans = dp[m] ; 
		
		if(ans == INT_MIN)
			ans = -1 ; 
		
		System.out.println(ans);
		
	} // main 
} // class 

