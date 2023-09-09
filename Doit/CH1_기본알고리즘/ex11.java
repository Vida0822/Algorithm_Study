package CH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 4:59:59
 *	@subject 반복 : 1~n 까지 합계 
 * @content 불필요한 분기는 삭제 


 */
public class ex11 {

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

		// 반복 n 번
		for (int i = 1; i <  n; i++) {
			System.out.print(i+"+");  // 1+2+3+4+5+6+7+8+9+ 
			sum += i; 
		} 
		
		System.out.print(n+"="+(sum+=n));  // 10 = 55 
		// 어차피 이건 마지막 숫자 n 출력한 다음 더해짐  => 반복이 다 끝나고 뒤에 붙여줌 
		/* 분기되는 지점을 알고 있다면, 분기문을 사용해 조건 판단해줄 필요 없이 내가 코드에서 직접 빼줌 (컴퓨터 시키지 말고) */ 
	
		System.out.println("1부터" + n +"까지의 합은" + sum + "입니다");

	} // main 

}
