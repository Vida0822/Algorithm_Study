package Exhaustive_Search;

import java.util.Scanner;

public class Two_Dimensional_Wind_MY {

	
	public static final int MAX_N = 100; 
	public static int m, n , q ; 
	public static int r1, r2 , c1, c2 ; 
	
// 	public static int grid[][] = new int[MAX_N+1][MAX_N] ; 
 	public static int grid[][] = new int[][]{
			{4, 5, 2, 5, 6, 6},
			{2, 1, 6, 1, 0, 5},
			{5, 2, 2, 1, 6, 5},
			{4, 5, 2, 8, 8, 6}
 	}; 
	
	public static int region[][] = new int[grid.length][grid[0].length] ; 
	
	
	public static void main(String[] args) {
		
		// part 1 . 격자 만들기
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("row : ");
		n = sc.nextInt() ; 
		
		System.out.print("col : ");
		m = sc.nextInt() ; 
		
		for (int i = 0; i < n ; i++) {
			for (int  j = 0;  j < m; j++) {
				grid[i][j] =  sc.nextInt() ; 			
			}
		} // for 
		
		
		// part 2. 바람 정보 
		System.out.print("q : ");
		q = sc.nextInt() ; 
		
		while(q-- > 0) {
			//  영향 받는 격자 만들기 
			r1 = sc.nextInt() ; 
			c1 = sc.nextInt() ; 
			r2 = sc.nextInt() ; 
			c2 = sc.nextInt() ; 
		}	
		
		// part 3 . 회전하기 
			makeRegion(r1,c1,r2,c2) ; 
			windShift( ) ; 
			replaceAvg() ; 
			
	
		// part 4 . 출력하기 
			 for(int row = 0; row < n; row++) {
		            for(int col = 0; col < m; col++)
		                System.out.print(grid[row][col] + " ");
		            System.out.println();
		        }
			
		
	} // main 

	private static void makeRegion(int r1, int c1, int r2, int c2) {
		for (int i = 0; i <= r2-r1; i++) {
			for (int j = 0; j <= c2-c1; j++) {
				region[i][j] = grid[r1+i][c1+j] ; 
			}		
		} // for 
	} // makeRegion
	
	
	private static void windShift() {
		// for문 --> 그안에서 분기 : 오른쪽 끝 요소면 아래로  내리고..? 
			
	}
	
	private static void replaceAvg() {
		
		for (int i = 0; i < region.length; i++) {
			for (int j = 0; j < region[i].length; j++) {
		// 		if( (i==region.length-1) ||  )
				region[i][j] = (region[i][j] + region[i][j] + region[i][j] + region[i][j] + region[i][j]) / 5; 
			}
			
		}
		
	}

	
	

}
