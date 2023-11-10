package dp;

/**
 * @author HEEMIN
 * @date 2023. 11. 10.-오후 8:06:51
 *	@subject dp2 - Find the Maximum Sub-Sequence 
 * @content introduction - 연속하는 부분 수열의 최대 합 


 */
public class 연속하는SubSequence {
	
	// 이렇게 static으로 주는 것은 모든 함수에 매개변수로 넣어주는 효과와 같다. 
	public static int[] a = new int[] {0, 4, -2, -5, 2, 2} ;   // [1] 부터 값 존재 [5]까지 
 	public static int[] dp = new int[a.length] ;   // i = 1 부터 채울 것이므로 
 	public static int n  = 5; 
 	
 	public static void initialize() {
 		for (int i = 1; i < dp.length; i++) { // index에선 length -1 까지 채워야함 
 			dp[i] = Integer.MIN_VALUE ; 	
		}
 		dp[1] = 2*a[1] ; 
 	} // initailize 
 	
	public static void main(String[] args) {
		
		initialize(); 
		
		// 각 i번째 원소를 포함한 중복순열 중 최대합 
		for (int i = 2; i < dp.length; i++) {  // 5
			dp[i] = Math.max(dp[i-1] + a[i], 2*a[i]) ; 	
		}
		
		// 문제의 답 : 나올 수 있는 중복순열의 합중 최대값 
		int ans = Integer.MIN_VALUE ; 
		for (int i = 1; i < dp.length; i++) {
			ans = Math.max(ans, dp[i]); 
		}
		System.out.println(ans);
		
	} // main 
} // class 
