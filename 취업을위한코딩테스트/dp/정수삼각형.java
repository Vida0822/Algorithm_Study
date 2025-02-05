// dp 의 핵심 : 점화식 
import java.util.* ; 

class Main{
    public static void main(String[] args){
        // '최대가 되는 경로'  = 최대가 되는 합 그 자체 
        Scanner sc = new Scanner(System.in) ; 
        int n = sc.nextInt() ; 
        int[][] dp = new int[n+1][n+1] ; 

        // step 1 : 초기 배열 채우기 
        for(int i = 1 ; i <= n ; i++){ // O(N^2) --> N : 500 이라 ㄱㅊ 
            for(int j = 1 ; j <= i ; j++){
                dp[i][j] = sc.nextInt(); 
            }    
        }
        
        // step 2 : 점화식따라 배열 채우기 (위에서부터 채우기)
        // ** 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택
        for(int i = 2 ; i <= n ; i++){ // O(N^2) --> N : 500 이라 ㄱㅊ 
            for(int j = 1 ; j <= i ; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];  
            }    
        }
        
        // step 3 : 답 구하기 (max)
        int answer = 0 ;
        for(int i = 1 ; i <= n ; i++){
            answer = Math.max(dp[n][i], answer) ; 
        }
        System.out.println(answer) ;
    }
}
