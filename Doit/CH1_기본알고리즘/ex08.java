package CH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 4:59:59
 *	@subject 반복 : 1~n 까지 합계 
 * @content 


 */
public class ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("1부터 n까지의 합을 구합니다."); 
		System.out.print("n 값 : ");
		int n = sc.nextInt() ; 
		
		int sum = 0; // 더해질 값 (합) 
		// int i = 1; //더할값 
		
		for (int i = 1; i <=  n; i++) {
			sum += i; 
		}

	
		System.out.println("1부터" + n +"까지의 합은" + sum + "입니다");

		
		
	} // main 

}
