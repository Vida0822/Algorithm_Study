package dp ; 

import java.util.Scanner;

public class AllPathMatrix {


	public static int MAX_N = 100 ; 
	public static int[][] grid = new int[MAX_N][MAX_N] ; 
	public static int[][] memo = new int[MAX_N][MAX_N] ; 

	public static int n ; 

	public static void initialize() {

		memo[0][0] = grid[0][0] ; 

		if(n > 1) {
			for (int i = 1; i < n; i++) {
				memo[0][i] = memo[0][i-1] + grid[0][i] ; 
			}
			for (int i = 1; i < n; i++) {
				memo[i][0] = memo[i-1][0] + grid[i][0] ; 
			}
		}
	} 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 

		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt() ; 
			}
		} // 격자 채우기 

		initialize() ; 

		if(n > 2) {

			for (int i = 1; i < n ; i++) {
				for (int j = 1; j < n ; j++) {
					memo[i][j] =Math.max( Math.max(memo[i-1][j], memo[i-1][j-1]),  memo[i][j-1]) + grid[i][j]; 

				}
			}
		}
		System.out.println(memo[n-1][n-1]);
	}
}
