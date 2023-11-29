package dp;

public class ShortestCommonSubsequence {

	public static final int lenA = 4 , lenB = 3 ; 

	public static String A = " ABAB" ;  // 0 ~ 5 (0은 빈 문자열 )  
	public static String B = " BBA" ;  // 0 ~ 4  (0은 빈 문자열) 
	public static int[][] dp = new int[lenA + 1][lenB + 1 ]; 

	public static void initialize() {
		dp[1][1] = (A.charAt(1) == B.charAt(1))? 1: 2 ; 

		// 1행 
		for(int i = 2 ; i <= lenA ; i++) {
			if(A.charAt(i) == B.charAt(1)) {
				dp[i][1] = i ; 
			}else {
				dp[i][1] = dp[i-1][1] + 1 ; 
			}
		}
		// 1열 
		for(int j = 2 ; j <= lenB ; j++) {
			if(A.charAt(1) == B.charAt(j)) {
				dp[1][j] = j ; 
			}else {
				dp[1][j] = dp[1][j-1] + 1 ; 
			}
		}
	} // initialize
	
	public static void main(String[] args) {
		
		initialize(); 
		
		for(int i = 2 ; i <= lenA ; i++) {
			for(int j = 2 ; j <= lenB ; j++) {
				if(A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1 ; 
				}	else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1  ; 
				}
			} // j 
		} // i 
		
		System.out.println(dp[lenA][lenB]) ; 
	} // main 
} // class 
