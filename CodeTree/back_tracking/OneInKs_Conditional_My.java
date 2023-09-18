package back_tracking;



import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author HEEMIN
 * @date 2023. 9. 18.-오전 8:27:57
 *	@subject K개 중 1개를 n번 뽑기 - Conditional : 추가하기 전 특정 조건 만족하는지 확인 
 * @content  Accepted

 */
public class OneInKs_Conditional_My {
	public static int k, n;
	public static ArrayList<Integer> selectedNums = new ArrayList<>();



	public static void findPermutations(int cnt) {
		// n개를 모두 뽑은 경우 답을 출력해줍니다.
		if(cnt == n) {
			printPermutation();
			return;
		}

		// 1부터 k까지의 각 숫자가 뽑혔을 때의 경우를 탐색합니다.
		for(int i = 1; i <= k; i++) {

			if(cnt >= 2 ) { // cnt == 0 --> 첫번째 자리수 채우고 있음 , cnt == 1 --> 두번째 자리수 채우고 있음 , cnt == 2 --> 세번째 자리수 채우고 있음

				int p1Step = selectedNums.get(selectedNums.size()-1) ; 
				int p2Step = selectedNums.get(selectedNums.size()-2) ; 

				if(!(p1Step == p2Step && i ==p1Step)) {
					selectedNums.add(i);
					findPermutations(cnt + 1);
					selectedNums.remove(selectedNums.size() - 1);	
				}
				continue ; 
			} // if 
			
			selectedNums.add(i);
			findPermutations(cnt + 1);
			selectedNums.remove(selectedNums.size() - 1);
			
		} // for 
	} // findPermutations


	// 선택된 원소들을 출력해줍니다.
	public static void printPermutation() {
		for(int i = 0; i < selectedNums.size(); i++)
			System.out.print(selectedNums.get(i) + " ");
		System.out.println();
	} // printPermutation


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		n = sc.nextInt();

		findPermutations(0);
	}
}