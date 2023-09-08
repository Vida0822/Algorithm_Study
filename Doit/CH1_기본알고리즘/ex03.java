package CH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 8.-오후 11:05:51
 *	@subject 양수/음수/0 분기 
 * @content 


 */
public class ex03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("정수를 입력하세요 : ");
		int n = sc.nextInt(); 
		
		if(n>0)
			System.out.println("이 수는 양수입니다.");
		else if(n<0)
			System.out.println("이 수는 음수입니다");
		else
			System.out.println("이 수는 0ㅇ비니다");

	}

}
