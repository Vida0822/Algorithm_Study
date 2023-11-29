package dp ; 
import java.util.* ; 

public class ChooseOneOfTwo {

	    public static int n ; 
        public static int MAX_VALUE = 100 ; 
	    public static int[] red = new int[2* MAX_VALUE+ 1 ] ;
	    public static int[] blue = new int[2 * MAX_VALUE+1] ;
	    public static int[][] dp = new int[2 * MAX_VALUE+1][MAX_VALUE+1] ; 


	    public static void initialize(){
	       
	        for(int i = 0; i <= 2*n; i++){
	          for(int j = 0 ; j <= n ; j++){
	            dp[i][j] = Integer.MIN_VALUE; 
	          }  
	        }
             dp[0][0] = 0 ; 
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in) ; 
	        n = sc.nextInt() ; 

	        for(int i = 1 ; i <= 2*n; i++){
	            red[i] = sc.nextInt() ; 
	            blue[i] = sc.nextInt() ; 
	        }

	        initialize() ; 

	        for(int i = 1 ; i <= 2*n ; i++){    
                if(i <= n ){
                    dp[i][0] = dp[i-1][0] + blue[i] ; 
                    dp[i][i] = dp[i-1][i-1] + red[i] ;
                }
	            
	            for(int j = 1 ; j <= n ; j++){
	                dp[i][j] 
	                = Math.max ( dp[i][j] , Math.max(dp[i-1][j-1] + red[i] , dp[i-1][j] + blue[i])) ; 
	            }
	        }
	        System.out.print(dp[2*n][n]) ; 
	    }
	}
