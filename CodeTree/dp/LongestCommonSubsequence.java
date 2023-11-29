package dp ; 

import java.util.* ; 

public class LongestCommonSubsequence {

    public static int MAX_LEN = 1000 ; 
    public static String strA ; 
    public static String strB ; 
    public static int lenA, lenB ; 
    public static int[][] dp = new int[MAX_LEN+1][MAX_LEN+1] ;  // 1001  : 0 ~ 1000

    public static void initialize(){
        /*
        for(int i = 1 ; i <= lenA ; i++ ){
            for(int j = 1 ; i <= lenB ; j++){
                dp[i][j] = Integer.MIN_VALUE ; 
            }
        } */
        dp[1][1] = (strA.charAt(1) == strB.charAt(1))? 1: 0 ; 

        // 1열 
        for(int i = 2 ; i <= lenA ; i++){
            if(strA.charAt(i) == strB.charAt(1)){
                dp[i][1] = 1 ; 
            }else{
                dp[i][1] = dp[i-1][1] ; 
            }  
        }
        // 1행
        for(int j = 2 ; j <= lenB ; j++){
            if(strA.charAt(1) == strB.charAt(j)){
                dp[1][j] = 1 ; 
            }else{
                dp[1][j] = dp[1][j-1] ; 
            }  
        }
    } // initialize

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        strA = "#"+ sc.next() ; 
        strB = "#"+ sc.next() ; 

        lenA = strA.length() - 1 ; 
        lenB = strB.length() - 1 ;  
    
        initialize() ; 

        for(int i = 2 ; i <= lenA; i++){
            for(int j = 2 ; j <= lenB; j++){

                if(strA.charAt(i) == strB.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1 ; 
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]) ; 
                }
            
            } // j 
        } // i 
        System.out.println(dp[lenA][lenB]) ; 
    } // main
} // class 