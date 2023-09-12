package exhaustive_Search;

import java.util.Scanner;

public class Tromino_Ans {
	
	//  base 격자 만들기
	
   public static final int MAX_NUM = 200; 
   // 어차피 얜 실제 격자가 아니라 변화할 base이므로 두 변수를 사용할 필요 없음 
   public static int n,m ; 
   public static int[][] grid = new int[MAX_NUM][MAX_NUM] ; 
   
   
   // part1. 나올 수 있는 모양을 반영한 격자 (2차원 배열) x 6 = 3차원 배열 
   // 1, 0으로 위치 표시 ! 
   // 격자
   public static int[][][] shapes =  new int[][][] {
	   {
		   {1,1,0},
		   {1,0,0},
		   {0,0,0}
	   }, // shape 1 
	   
	   {
		   {1,1,0},
		   {0,1,0},
		   {0,0,0}
	   }, // shape 2
	   
	   {
		   {1,0,0},
		   {1,1,0},
		   {0,0,0}
	   }, // shape 3 
	   
	   {
		   {0,1,0},
		   {1,1,0},
		   {0,0,0}
	   }, // shape 4
	   
	   {
		   {1,1,1},
		   {0,0,0},
		   {0,0,0}
	   }, //shape 5 
	   
	   {
		   {1,0,0},
		   {1,0,0},
		   {1,0,0}
	   } // shape 6
   };  // shapes
   
   public static void main(String[] args) {
	
	   // part 2. 숫자가 적힌 격자 (2차원 배열)  
	   Scanner sc = new Scanner(System.in); 
	   
	   n = sc.nextInt() ; 
	   m=sc.nextInt() ; 
	   
	   for (int i = 0; i < n; i++) {
		   for (int j = 0; j < m; j++) {
			grid[i][j] = sc.nextInt() ; 
		}
	} // for  
	   
	   // part 3. 두 격자를 활용해 숫자에 합산 
	   
	   // main  => 
	   int ans = 0 ; 
	   
	   for (int i = 0; i < n; i++) {
		   for (int j = 0; j < m; j++) {
			   ans = Math.max(ans, getMaxSum(i,j)); 
		}
	}  // for
	   System.out.println(ans);
	   
} // main 
   
   		// getMaxSum => 
   public static int getMaxSum(int x, int y) {
	   int maxSum = 0 ; 
	   
	   for (int i = 0; i < 6; i++) { // 모든 모양 검사 
		   boolean isPossible = true ; 
		   int sum = 0; 
		   for (int dx = 0; dx < 3; dx++) {
			   for (int dy = 0; dy < 3; dy++) {
				   if(shapes[i][dx][dy] == 0) continue ; 
				   if(x+dx >= n || y + dy >= m ) isPossible = false ; 
				   else sum += grid[x+dx][y+dy] ; 
			} // for dy 
		} // for dx
		   
		   if(isPossible)
			   maxSum = Math.max(maxSum, sum) ; 
		
	} // for shapes 
	   
	   return maxSum ; 
   }
   
   
} // Tromino_Ans