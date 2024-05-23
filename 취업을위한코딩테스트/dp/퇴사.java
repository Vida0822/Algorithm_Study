package dp ; 

import java.util.*; 

public class 퇴사{
    public static void main(String[] args){
    	
        // N+1일 후 퇴사 --> 남은 N일동안 최대한 많은 상담 
        Scanner sc = new Scanner(System.in) ; 
        int N = sc.nextInt() ; 
        
        int[] T = new int[N] ; 
        int[] P = new int[N] ; 
        for(int i = 0 ; i < N ; i++){
            T[i] = sc.nextInt() ; 
            P[i] = sc.nextInt() ; 
        }
        
        // dp 초기조건
        int[] dp = new int[N+1] ; 
        int answer = 0; 
        
        // dp 점화식 
        for(int i = N-1 ; i >= 0 ; i--) {
        	int time = T[i] + i ; // i일에 배정된 상담 완료 날짜 
        	
        	if(time <= N) {
        		dp[i] = Math.max(P[i]+dp[time], answer) ; 
        		answer = dp[i] ;
        	}else
        		dp[i] = answer ; 
        		
        }
        
        // print answer 
        System.out.println(dp[0]) ; 
    }
}
