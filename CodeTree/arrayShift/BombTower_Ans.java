package arrayShift;

import java.util.Scanner;

public class BombTower_Ans {
	
	public static final int MAX_NUM = 100; 
	
	public static int n, m, endOfArray, endOfTemp ; 
	public static int[] numbers = new int[MAX_NUM] ; 
	public static int[] temp = new int[MAX_NUM] ; 

	public static void main(String[] args) {
		
		// part 1. 타워 만들기 
		Scanner sc = new Scanner(System.in); 
		
		n = sc.nextInt(); 
		m = sc.nextInt() ; 
		
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt(); 
		}
		endOfArray = n ;
			
		boolean didExplode ; 
		do {
			didExplode = false ; 
			
			for (int currIdx = 0; currIdx < endOfArray; currIdx++) {
				
				if(numbers[currIdx] == 0) {
					continue ; 
				} // if 
				
				int endIdx = getEndInxOfExplosion(currIdx, numbers[currIdx]) ; 
				
				if(endIdx - currIdx +1 >= m) {
					fillZero(currIdx, endIdx) ; 
					didExplode = true; 
				}
			} // for 
			moveToTemp() ; 
			
			copy() ; 
		}while(didExplode) ; 
		
		System.out.println(endOfArray) ;
		for (int i = 0; i < endOfArray; i++) {
			System.out.println(numbers[i]);
		}
	}
}
