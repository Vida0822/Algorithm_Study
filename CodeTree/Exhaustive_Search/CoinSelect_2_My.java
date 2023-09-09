package Exhaustive_Search; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class CoinSelect_2_My {
	
	
	
	/*
	public static int n = 3; 

	public static int[][] grid = new int[][]{
		{ 1, 0, 1},
		{ 0, 1, 0},
		{ 0, 1, 0}  
	}; 
	 
	 */
	// row 행의 colS ~ colE 사이의 금의 개수 계산하는 함수  


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        
        int[][] grid = new int[n][n] ; 
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				
				Random random = new Random() ; 
				grid[i][j]= random.nextInt(2); 	
				System.out.print(grid[i][j]+ ",");
			}
			System.out.println();
		}
        
        
		int maxGold = 0; 

		// main의 이중 for : 좌측 모서리를 격자 칸따라 차례로 옮기는 것 
		for(int row = 0 ; row <n ; row++){  // n=3 
			
			for(int col = 0; col < n ; col++){
				if(row+2 >= n || col+2 >= n ) continue;  // 우측 끝값을 격자 크기와 비교 (3 vs 3) 
					
				int numOfGold = getNumOfGold(row,row+2, col,col+2, grid); 

				maxGold = Math.max(maxGold, numOfGold) ; 
			} // for col 
		} // for row
		System.out.println(maxGold) ; 
	} // main 
	
	public static int getNumOfGold(int rowS,int rowE, int colS, int colE, int [][] grid){
		int numOfGold = 0;

		// getNumOfGold 의 이중 for :  직사각형이 덮고 있는 격자 한칸한칸 조사하며 개수 + 
		for(int row=rowS; row <= rowE ; row++) { 
			for(int col=colS; col <= colE ; col++)
				numOfGold += grid[row][col] ; 
		}
		return numOfGold; 
	} // getNumOfGold
	
}