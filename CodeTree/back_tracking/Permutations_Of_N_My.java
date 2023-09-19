package back_tracking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 19.-오후 1:28:45
 *	@subject 순열 backtracking 
 * @content  Accepted 


 */
public class Permutations_Of_N_My {

	public static int n ; 

	public static ArrayList<Integer> permutations = new ArrayList<>();
	public static boolean[] selected = new boolean[200] ; 


	public static void findPermutations(int curNum) {

		if(curNum == n+1 ) {
			printPermutation();
			return;
		} 

		for (int i = 1; i <=n; i++) {			

			if(!selected[i]) {
				
				permutations.add(i) ;
				selected[i] = true ; 
				findPermutations(curNum+1) ; 
				
				permutations.remove(permutations.size() - 1) ;  // 마지막 원소 삭제 
				selected[i] = false ; 
				
			} // if
		} // for 


	} // findPermutations

	public static void printPermutation() {
		for (int i = 0; i < permutations.size(); i++) {
			System.out.print(permutations.get(i)+" ");
		}
		System.out.println();
	}  // printPermutation


	public static void main(String[] args) {

		// part 1. 입력값 받기 
		Scanner sc = new Scanner(System.in); 

		n = sc.nextInt();

		findPermutations(1) ; 

	} // main 

}
