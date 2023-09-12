package arrayShift;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 11.-오후 8:51:23
 *	@subject 중력 적용하기 - 아래로 요소들 떨어트리기 
 * @content 
1. temp[] 배열로 복사해 채우고 다시 가져오는 방법과 o 
2. 90도 눕혀서 바라봐 왼쪽으로 shift한다고 생각  

 */
public class TowerCollapse_Ans_1 {
	
	public static final int MAX_N = 100 ; 
	
	public static int[] numbers = new int[MAX_N] ; 
	
	public static int n ; // 타워 층수 (블럭 수)
	public static int endOfArray ; 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 

		// part 1. tower 세우기 
		n = sc.nextInt() ; 
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt() ;
		} 
		endOfArray = n ;
		
		// part 2. 지울 타워 입력받기 
		// s, e : nth flooar --> 3층 입력시 배열 index 는 2부터 삭제해야함  
		for (int i = 0; i < 2; i++) {
			
			int s = sc.nextInt() ;  
			int e = sc.nextInt() ;
			
			// 문제 조건 --> input 값이 잘못 입력될리 없음 (유효성 검사 따로 안해줘도 됨) 
			s -- ; 
			e -- ; 
			
		// part 3. 배열 자르기 
			// [ s , e 구간 삭제] 
			cutArray(s, e) ; 
			System.out.println(endOfArray);

		} // for 
		
		// part 3. tower(new 배열) 출력 
		for (int i = 0; i < endOfArray ; i++) {
			System.out.println(numbers[i]);  
		} // for 
	} // main 
	
	public static void cutArray(int startIdx, int endIdx) {
		int[] tempArr = new int[MAX_N] ; 
		int endOfTempArray = 0 ; 
		
		for (int i = 0; i < endOfArray ; i++) {
			if(i < startIdx || i > endIdx) {				
				tempArr[endOfTempArray++] = numbers[i] ; 
			}
		} // for
		
		for (int i = 0; i < endOfTempArray; i++) {
			numbers[i] = tempArr[i] ; 
		} // for 
		endOfArray = endOfTempArray ; // 끝깞도 변경된 배열에 맞춰 update 해줘야함 
	} // cutArray 

}
