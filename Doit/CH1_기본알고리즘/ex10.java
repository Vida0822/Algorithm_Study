package cH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 4:59:59
 *	@subject 반복 : 1~n 까지 합계 
 * @content 반복 n 번 + 분기 n 번


 */
public class ex10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int n ; 
		
		System.out.println("1부터 n까지의 합을 구합니다."); 

		
		// 입력값 유효성 검사 : 양수만 입력되도록 함 
		do { 
			System.out.print("n 값 : ");
			n = sc.nextInt() ; 
		}while(n <= 0 ) ; 

		int sum = 0; // 더해질 값 (합) 
		// int i = 1; //더할값 

		// 반복 n 번 + 분기 n 번
		for (int i = 1; i <=  n; i++) {
			if(i<n)
				System.out.print(i+"+");
			else 
				System.out.print(i+"="); // 어차피 이건 마지막 숫자 n 출력한 다음 더해짐 
			sum += i; 
		} 
		System.out.print(sum);

		System.out.println("1부터" + n +"까지의 합은" + sum + "입니다");



	} // main 

}
