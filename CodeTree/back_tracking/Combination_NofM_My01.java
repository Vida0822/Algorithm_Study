package back_tracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 19.-오후 12:00:38
 *	@subject 조합 
 * @content  Accapted 
 * 
 * 1. 모든 경우의 수를 다 dfs 하고, 중복되는 숫자 or 순서가 역행되는 숫자가 있으면 print x  --> 분기를 끝값 종료조건에
 * 2. backtracking으로 이전값들과 같은 or 작은 숫자가 나오면 x  --> 분기를 재귀함수 호출부분에 


 */
public class Combination_NofM_My01 {

	public static int m, n ; 
	public static ArrayList<Integer> selectNums = new ArrayList<Integer>() ; 

	public static void findPermutations(int curNum) {
		// 자리수에 숫자 하나를 넣어주는 함수 --> 이걸 반복 재귀호출해서 결국 모든 n자리 숫자조합을 도출해냄  

		if(curNum == m) {

			for (int i = 0; i <m; i++) {
				for (int j = 0; j <= i; j++) {

					if(i!=j && selectNums.get(i) <= selectNums.get(j)) {
						return ; 
					}
				} // i 
			}

			printPermutation() ; 
			return ; 
		}

		for (int i = 1 ; i <= n ; i++) {

			selectNums.add(i);
			findPermutations(curNum + 1);
			selectNums.remove(selectNums.size() - 1);	

		} // i 
	} // findPermutations

	public static void printPermutation() {

		for (int i = 0; i < selectNums.size(); i++) {
			System.out.print(selectNums.get(i)+" ");
		}
		System.out.println();

	} // printPermutation



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 

		n = sc.nextInt() ; // 정수 범위 
		m = sc.nextInt() ; // 자리수

		findPermutations(0) ; 

	} // main
} // class
