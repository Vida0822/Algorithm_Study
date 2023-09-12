package exhaustive_Search; 

import java.util.Scanner;

public class CoinSelect_2_Ans {
	
    public static final int MAX_N = 20;

    // 격자 자체는 이미 만들어 놓고 ! 
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static int n;
    
    // (rowS, colS) ~ (rowE, colE) 사이의 금의 개수를 계산합니다.
    public static int getNumOfGold(int rowS, int colS, int rowE, int colE) {
        int numOfGold = 0;

        // 그 격자에 row와 col로 범위를 제한해 실제 문제에 사용되는 격자 '범위'를 정하는 방식 (새로운 격자를 만드는게 ㄴㄴ) 
        for(int row = rowS; row <= rowE; row++) {
            for(int col = colS; col <= colE; col++) {
                numOfGold += grid[row][col];
            }
        }
        
        return numOfGold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxGold = 0;

        // 입력
        n = sc.nextInt();
        for(int row = 0; row < n; row++)
            for(int col = 0; col < n; col++)
                grid[row][col] = sc.nextInt();
        
        // (row, col)이 3 * 3 격자의 좌측 모서리인 경우를 전부 탐색합니다. 
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                // 3 * 3 격자가 n * n 격자를 벗어나는 경우는 계산하지 않습니다.
                if(row + 2 >= n || col + 2 >= n)
                    continue;
                
                // 금의 개수를 계산합니다.
                int numOfGold = getNumOfGold(row, col, row + 2, col + 2);

                // 최대 금의 개수를 저장합니다.
                maxGold = Math.max(maxGold, numOfGold);
            }
        }

        System.out.println(maxGold);
    }
}