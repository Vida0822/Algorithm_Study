package ch1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 9:39:37
 *	@subject 반복 
 * @content 불필요한 분기는 삭제한다 


 */
public class ex13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		int n ; 
		
		System.out.println("+와 -를 번갈아 n개 출력합니다. ");
		
		do { 
			System.out.print("n 값 : ");
			n = sc.nextInt() ; 
		}while(n <= 0 ) ; 
		
		for (int i = 0; i < n/2; i++) {  // i 변화시 이 초기값만 바꿔주면 밑엔 안바꿔도 됨  
			// 어차피 출력값은 정해져 있음 : -+도 안되고 무조건 +-  
			// <-> index에 따라 출력값이 뭔지 판단할 필요 없음 
			// ==> 시작값을 분기로 정하는게 아니라 그냥 +로 시작하게 하고 그 기호가 출력되는 count만 정해주면 됨 
			System.out.print("+-"); // 이렇게 하면 무조건 +로 시작
		}
		
		if(n%2 != 0)
			System.out.print("+"); // 홀수면 +로 끝나고, 짝수면 - 로 끝남 (else 만들어줄필요 x) 
		

	} // main

}
