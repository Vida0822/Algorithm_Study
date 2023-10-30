package dp;

public class jump {
	
	public static final int INT_MIN = Integer.MIN_VALUE ; 
	public static final int n = 5 ; 
	
	public static int[] a= new int[] {2,3,0,1,4} ;   // 점프 가능 칸수 
	public static int[] dp = new int[n] ; // 답 배열 : 최대 점프횟수 
	
	 
	public static void main(String[] args) {
		
		// part 1. 격자 만들기 
		for (int i = 1; i < n ; i++) {
			dp[i] = INT_MIN  ; 
		}
		dp[0] = 0; 
		
		for (int i = 0; i < n; i++) { // 이 노드의 
			for (int j = 0; j < i; j++) { // 앞에있는 애들 중 이 노드까지 올 수 있는지 검사  
				
				if(dp[j] == INT_MIN) // 만약 그 노드까지의 최대 점프가 구해지지 않았다면 pass  
					continue ; 
				
				if(j+a[j] >= i )
					// j가 위치, a[j] : 이동 가능한 '위치 수' 이기 때문에 j+a[j]는 이동한 위치 ! 
					// 그 위치가 i 번째를 넘으면 
					dp[i] = Math.max(dp[i], dp[j]+1) ; 
					// 최대. 최소값 도출 방법 中 1 : 새로 나온 값과 기존 값을 비교해 더 큰 값으로 세팅 
			}
		}
		int ans = 0 ; 
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]) ; 
			// 만약 그 이전까지 올수 있는 노드 점프수가 더 많다면 그게 최대값! 
			// 6번 노드의 점프가능횟수가 0이더라도 점프를 5번했으면 그게 7번째 이전까지 가능한 점프의 최대값 !! 
			// 각 메모의 값들 조사해서 판별해야함 
		}
		System.out.println(ans);
		
	} // main 
} // class
