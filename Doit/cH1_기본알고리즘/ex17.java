package cH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 10:50:07
 *	@subject 반복 
 * @content  별찍기 (직각이등변삼각형 출력 ) 


 */
public class ex17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n ; 
		
		System.out.println("왼쪽 아래가 직각인 이등변삼각형을 출력합니다");
		
		do {
			System.out.print("몇 단 삼각형입니까? : ");
			n = sc.nextInt(); 
		}while(n<=0) ; 
		
		// 로직 i번째 줄엔 i개의 *를 출력한다 
		for (int i = 0; i < n ; i++) { // 1번째줄 -> *,  2번째줄 **, 3번째줄 ***  
			for (int j = 0; j < i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		

	} // main 

}
