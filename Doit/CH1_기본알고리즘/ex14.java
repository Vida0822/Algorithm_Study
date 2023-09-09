package CH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 9:39:37
 *	@subject 반복 
 * @content * 을 n번 출력 + w개마다 줄 바꿈  


 */
public class ex14 {

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
		
		for (int i = 0; i < n; i++) { // w = 4
			System.out.print("*");
			if(i%w == w-1) // i가 0부터 시작 --> i=3 일때 *은 4개 찍힘  <-> i %w == 3일때 개행 해줘야함 
				System.out.println();
		} // for 
		
		if(n%w != 0)
			System.out.println();
		

	} // main

}
