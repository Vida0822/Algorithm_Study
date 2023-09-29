package ch1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 10:07:07
 *	@subject 드모르간 법칙과 단축평가  
 * @content 
 * && (논리곱) : 둘 다 참이면 참  --> 왼쪽 피연산자가 거짓이면 뒤에 검사 안함  <-> 왼쪽에 거짓일 확률이 높은 피연산자를 둠 --> 활용 : By 드모르간 법칙 --> 계속조건 <--> 거짓조건 
 * || (논리합) : 둘 중 하나라도 참이면 참  --> 왼쪽 피연산자가 참이면 뒤에 검사 안함 <-> 왼쪽에 참일 확률이 높은 피연산자를 둠 
 * 
 * ex) n 은 두 자리 양수일 가능성이 큼 (안내 멘트가 나갓으니)  
 * n<10 || n>99   : 계속 조건  --> 첫번째 피연산자는 거짓 나올 가능성 큼 : 두번째 피연까지 연산 (속도 down) 
 * =>드 모르간 법칙 !(n>10 && n <= 99)  : 거짓 조건 
 * 


 */
public class TwoDigits_드모르간법칙 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int no ; 
		
		System.out.println("2자리의 양수를 입력하세요.");
		
		// 입력값 유효성 검사 : 1자리나 3자리 등 안됨 ! 두 자리 양수만 됨 
		do {
			System.out.print("no값 : ") ;
			no = sc.nextInt() ; 
		}while( no < 10 || no > 99) ; 
		
		System.out.println("변수 no의 값은 "+no+"이 되었습니다. ");
		

	} // main 

}
