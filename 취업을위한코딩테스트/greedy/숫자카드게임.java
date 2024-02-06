package greedy;

import java.util.Scanner;

public class 숫자카드게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		// 숫자카드 행, 열 입력  
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ;
		int result = 0 ; 
		
		for(int i = 0 ; i < n ; i++) {
			int min_value = 10001 ; 
			for(int j = 0 ; j < m ; j++) {
				/*
				 * 아이디어 주목 : 숫자카드를 한번에 완성시킨 후 비교하는게 아닌 입려 받으면서 최솟값 갱신   
				 	=> 각 줄의 최솟값 도출 
				 */
				int x = sc.nextInt(); 
				min_value = Math.min(min_value, x); 
			} // j 
			// 행의 최솟값을 도출한 후 바로 기존 최댓값과 비교하여 갱신 
			result = Math.max(result, min_value) ; 
		} // i 
		System.out.println(result) ; 
	} // main 
} // class 
