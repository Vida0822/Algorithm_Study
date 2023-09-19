package back_tracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 18.-오전 8:28:37
 *	@subject 중복순열 backtracking(K개 중 1개를 n번 뽑기) - 가능한 모든 조합을 구함 (순서대로) 
 * @content  코드 따라침

 */
public class OneInKs_Simple {
	
    public static int k, n;
    public static ArrayList<Integer> selectedNums = new ArrayList<>();

    
	private static void findCombinations(int cnt) {

		// 종료 조건 설정
		if(cnt == n) {			
			printPermutation() ;
			return ; 
		}
		
		// 재귀 함수 호출 
		// 1~k 값 중 랜덤값을 넣는게 아닌 1~k가 각각 들어간 모든 경우의 수를 구해야함 !! 
		// 각 자리수마다 1 ~ k 다 넣어준 숫자값들 도출해야함 
		for (int i = 1; i < k; i++) {
			selectedNums.add(i); 
			findCombinations(cnt + 1);
			selectedNums.remove(selectedNums.size() - 1 ) ; 
		} //for 	
	} // findCombinations

	
	private static void printPermutation() {
		for (int i = 0; i < selectedNums.size(); i++) {
			System.out.print(selectedNums.get(i)+" ");
		} // for 
		System.out.println();
	} // printPermutation


	public static void main(String[] args) {
		
		// part 1. 입력값으로 숫자조합 기본설정  
		Scanner sc= new Scanner(System.in); 
		k = sc.nextInt(); 
		n = sc.nextInt(); 
		
		// part 2 . 탐색 : 조건에 맞는 숫자값을 찾아 List에 쌓음 
		findCombinations(0) ; 
		
		
	} // main 



} // class
