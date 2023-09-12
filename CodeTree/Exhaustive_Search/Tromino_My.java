package exhaustive_Search;

import java.util.Scanner;

public class Tromino_My {

	public static final int MAX_NUM = 300 ; 
//	public static final int MAX_M = 300 ; 

	public static int n ; 
	public static int m ; 

	//public static int[][] grid = new int[MAX_N][MAX_M] ; 
	// 어차피 얜 실제 격자가 아니라 base이므로 두 변수를 사용할 필요 없음 
	 public static int[][] grid = new int[MAX_NUM][MAX_NUM];


	public static void main(String[] args) {
		// main : 실제 프로그램이 실행 되었을 때 일어나는 동작 

		int sum ; 

		// 1. 격자 만들기 
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt() ; 
		m = sc.nextInt() ; 

		for (int row = 0; row < n ; row++) {
			for (int col = 0; col < m; col++) {
				grid[n][m] = sc.nextInt() ; 			
			}
		} // for 

		// 2. 도형 모양 결정 (2번이라고 가정) 
		int shape = sc.nextInt() ; 

		// 도형 돌리기 
		if(shape==1) {

		}else {
			for (int i = 0; i < shape; i++) {  // shape == 2 
				
				if(i==0) {
					int[][] blocks = new int[1][3] ; 
				}
				else {
					int[][] blocks = new int[3][1] ; 
				}
				
				// 왼쪽 모서리 이동 => 합하는 함수에 위치값 보내주기 
				for (int row= 0; row < n; row++) { // 검사 (row) 
					for (int col = 0; col < m; col++) { // 검사 (col) 
						if(i==0) { // 옆으로 3칸 
							if(col + 2 >= m)
								continue;
							
							    sum = getSum(row, col, row ,col+2) ; // 좌표 보내기 
							    
						}else{ // 아래로 3칸
							if(row + 2 >= n)
								continue;
							
								sum = getSum(row, col, row+2 ,col+1) ; 	
						}
					} // col 				
				} // row 				
			} // shape 

		}



	}


	private static int getSum(int rowS, int colS, int rowE, int colE) {
		// TODO Auto-generated method stub
		
		int sumOfNum = 0; 
		
		for (int row = rowS ; row < rowE; row++) {
			for (int col = colS; col < colE; col++) {
				sumOfNum += grid[row][col] ; 
			}		
		}
		return sumOfNum;
	}
}
