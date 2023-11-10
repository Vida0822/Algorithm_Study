package dp;

/**
 * @author HEEMIN
 * @date 2023. 11. 10.-오후 10:41:24
 *	@subject dp 2  - 직전상황에 영향을 받는 dp 
 * @content introduction


 */
public class 직전상황에영향을받는dp {
	
	public static int[][] a = new int[][] {
		{0, 0, 0, 0}, 
		{0, 1,2,5}, 
		{0, 8,9,10}, 
		{0, 12, 17, 14},
		{0, 21, 16, 20} 
	} ; 
	public static int[][] dp = new int[a.length][a[1].length] ;  // [5][4]
	
	public static void initialize() {
		for (int i = 1; i < a.length; i++) { // < 5 
			for (int j = 1; j < a[i].length; j++) { // < 4 
				dp[i][j] = Integer.MIN_VALUE; 
			}	
		}
		
		for (int i = 1; i < a[1].length; i++) { // < 4 
			dp[1][i] = a[1][i] ; 
		}

	} // initialize

	public static void main(String[] args) {
		initialize();
		
		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				/*
				int max = Integer.MIN_VALUE ; 
				for(int k = 1; k< dp[i].length; k++) {
					
					if(j == k) {
						continue; 
					}
					max = Math.max(dp[i-1][k-1], dp[i-1][k]) ; 
				} // k 
				
				dp[i][j] = max + a[i][j] ; 
				*/
				for (int k = 1; k < dp[i].length; k++) {
					if(j != k) {						
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + a[i][j]) ; 
					}
				} // k 
			}// j	
		} // i 
		
		int ans = Integer.MIN_VALUE ;
		for (int i = 1; i <dp[dp.length-1].length; i++) {			
				ans = Math.max(ans, dp[dp.length-1][i]) ; 
		}
		System.out.println(ans);

	} // main 

}
