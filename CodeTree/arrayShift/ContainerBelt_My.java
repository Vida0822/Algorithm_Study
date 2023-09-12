package arrayShift;

import java.util.Scanner;

public class ContainerBelt_My {
	
	public static final int MAX_NUM = 200; 
	public static int n, t ; 
	
	// public static int[][] grid = new int[MAX_NUM][MAX_NUM] ; 
	public static int [][] belt = new int[2][MAX_NUM] ; 
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		
		// part 1. 격자 만들기 
	//	System.out.print("n 입력 : ");
		n = sc.nextInt() ; 
		
	//	System.out.print("t 입력 : ");
		t = sc.nextInt() ; 
		
		for (int i = 0; i <  belt.length; i++) {
			for (int j = 0; j < n; j++) {
				belt[i][j] = sc.nextInt() ; 
			}
		} // for 
		
		// part 2. 
		for (int i = 0; i < t; i++) {
			belt = ShiftBelt() ; 
		} // for 

		// part 3. 출력 
		for (int i = 0; i < belt.length; i++) {
			for (int j = 0; j < n ; j++) {
				System.out.print(belt[i][j] +",");
			}
			System.out.println();
		} // for 

	} // main 


	private static int[][] ShiftBelt() {

		// 1. temp 에 소실될 변수 담고 
		int upTemp = belt[0][n-1]; 
		int downTemp = belt[1][n-1] ; 
		
		for (int i = 0; i < belt.length; i++) {
			for (int j = n-1; j > 0; j--) {
				belt[i][j] = belt[i][j-1] ; 
			}
		}
		
		belt[0][0] = downTemp ; 
		belt[1][0] = upTemp ; 
		

		return belt;
	}
	
	

}
