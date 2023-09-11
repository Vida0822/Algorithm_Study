package CH2_기본자료구조;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 11.-오후 4:20:03
 *	@subject 배열
 * @content 기수 변환 - 입력받은 10진수를 2진수 ~ 36진수로 기수 변환하여 출력  


 */
public class ex06_02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int no ;  // 숫자 
		int cd ;  // 진수 
		int dno ;  // 변환 후의 자리수 
		int retry ; 
		char[] cno = new char[32] ;  // 변환 후 각 자리의 나머지를 넣어두는 문자배열 
		
		System.out.println("10진수를 기수 변환합니다.");
		
		// do ~ while 의 자주 사용되는 용법 --> 입력값 유효성 검사 (올바른 값이 입력될때까지 입력을 반복시킨다) 
		
		// part 1 . 변환할 정수와 진수 입력받기 
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수: ");
				no = sc.nextInt(); 
			}while(no<0) ;  // 음수를 입력하면 다시 입력 받음 
			
			do {
				System.out.print("어떤 진수로 변환할까요?(2~36)");
				cd = sc.nextInt() ; 
			}while(cd < 2 || cd > 36); 

			// part 2. r 진수로 변환하기 
			dno = cardConv(no, cd, cno) ; 

			System.out.print(cd+"진수로") ;
			for (int i = 0; i < dno; i++) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다. ");
			
			
			// part 3. retry 질문 받기 
			System.out.println("한번 더 할까요? (1_예/ 2_아니오) ");
			retry = sc.nextInt() ; 
		}while(retry == 1) ; 
		
	


	} // main 

	static int cardConv(int x, int r, char[] d) { //정수값 x , r진수 
		int digits = 0; 
		String dchar = "0123456789ABCDEFGHIJLLMNOPQRSTUVWXZ" ; 
		
		do {
			d[digits++] = dchar.charAt(x % r) ; 
			x /= r ; 
		}while(x != 0) ; 
		
		for (int i = 0; i < digits / 2; i++) {
			char t = d[i] ; 
			d[i] = d[digits -i -1] ; 
			d[digits -i -1] = t; 			
		} 
		return digits ;  // 자리수를 반환 
	}

	
} // class 
