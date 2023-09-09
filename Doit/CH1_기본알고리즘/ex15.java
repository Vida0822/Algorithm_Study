package CH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 9:39:37
 *	@subject 반복 
 * @content 불필요현 분기 반복 삭제 


 */
public class ex15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		int n , w ; 
		
		System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.  ");
		
		do { 
			System.out.print("n 값 : ");
			n = sc.nextInt() ; 
		}while(n <= 0 ) ; 
		
		do { 
			System.out.print("w 값 : ");
			w = sc.nextInt() ; 
		}while(w <= 0 || w>n) ; 
	
		for (int i = 0; i < n/w; i++) { // i = 0 (첫번째 줄) --> 줄 개수 = 총 숫자 개수 / 개행 기준 수 = 개행하는 줄 수 
			System.out.println("*".repeat(w)); // 개행 기준 개수만큼 *를 출력하고 개행 
		} // * n 번 반복  => 몫이 0일때 , 개행 기준 수 만큼 i 값이 남지 않았을 때 빠져나옴 
		
		int rest = n%w ;  // 남은 * 수(3)를 나눈 나머지 == 전체(31)를 나눈 나머지 == 4   
		if(rest != 0) {
			System.out.println("*".repeat(rest)); // 남은 개수만큼 * 출력 
		}
		
		

	} // main

}
