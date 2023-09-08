package Exhaustive_Search; 

/**
 * @author HEEMIN
 * @date 2023. 9. 8.-오후 9:19:13
 *	@subject 포함될 수 있는 동전의 최대값 
 * @content  5*5 격자에 1*3 직사각형 


 */
public class CoinSelect_1 {
	
    public static int n = 5; 
    public static int[][] grid = new int[][]{
        {0, 0 ,0 ,1 ,1},
        {1 ,0 ,1 ,1 ,1},
        {0 ,1 ,0 ,1 ,0},
        {0 ,1 ,0 ,1 ,0,},
        {0 ,0 ,0 ,1 ,1}       
    }; 

    // row 행의 colS ~ colE 사이의 금의 개수 계산하는 함수  
    public static int getNumOfGold(int row, int colS, int colE){
        int numOfGold = 0;

        for(int col=colS; col <= colE ; col++)
            numOfGold += grid[row][col] ; 
        
        return numOfGold; 
    }

    public static void main(String[] args) {
        int maxGold = 0; 

        for(int row = 0 ; row <n ; row++){

            for(int col = 0; col < n ; col++){
                if(col+2 >= n)
                    continue; 
                
                int numOfGold = getNumOfGold(row,col,col+2); 

                maxGold = Math.max(maxGold, numOfGold) ; 
            } // for col 
        } // for row
        System.out.println(maxGold) ; 
    } // main 
}