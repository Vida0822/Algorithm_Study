package arrayShift;

import java.util.Scanner;

public class BombTower_MY {
	
	public static final int MAX_N = 100 ; 
	public static int[] numbers = new int[MAX_N] ; 
	
	public static int n, m ; 
	public static int endOfArray ; 
	

	public static void main(String[] args) {
		
		
		// part 1. 타워 세우기 
		Scanner sc = new Scanner(System.in); 
		
		n = sc.nextInt(); 
		endOfArray = n ; 
		
		m = sc.nextInt() ; 
	
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt() ; 	
		} 
		
		
		// part 2. 중복 체크 (중복값 누적으로 비교 ) --> 바로 자르기 
		int startInx = 0 ; 
		int endIdx = 0; 
		
		int same  ;
		
		for (int i = 0; i <endOfArray; i++) {  
			
			startInx =endIdx = i ; 
			same = 1; 
			
			for (int j = i+1; j < endOfArray; j++) {
				
				if(numbers[i] != numbers[j]) {
			//		break ; 
 					continue ;  // 해결 방법 1 . 
				}
				same ++ ; 
				endIdx = j ; 		
				
				if(same>=m) { // m = 3 (터지는 연속조건)    same : 실제 중복 개수 
					makeZero(startInx, endIdx) ; 	
					i = endIdx;
				}
			} // for 
			if(cutArray()) {
				i = 0 ; 
			}; 
		} // for 
			
		// part 4. 출력하기 

		
		if(endOfArray == 0) {
			System.out.println("0");  // 해결 방법 2.  
		}
		
		for (int i = 0; i < endOfArray; i++) {	
			System.out.println(numbers[i]);
		}
	} // main 
	

	public static void makeZero(int startIdx, int endIdx) {
		
		
		for (int i = startIdx; i <= endIdx; i++) { 
			numbers[i] = 0 ; 

		} // for 				
		// 근데 endInx까지 삭제해줘야함 
	} // makeZero 
	
	
	
	private static boolean cutArray() {
		
		
		int[] tempArr = new int[MAX_N] ; 
		int endOfTempArray = 0 ; 
		
		for (int i = 0; i < endOfArray; i++) {
			if(numbers[i] != 0) {			
				tempArr[endOfTempArray++] = numbers[i] ;  // 1 1  , 2 
			}
		} // for
		
		for (int i = 0; i < endOfTempArray; i++) {
			numbers[i] = tempArr[i] ; 
		}
		if(endOfArray != endOfTempArray) {
			endOfArray = endOfTempArray ;  // 2 
			return true; 
		}else {
			return false ; 
		}
		
		
		
		
		
	} // cutArray

	
} // BombTower
