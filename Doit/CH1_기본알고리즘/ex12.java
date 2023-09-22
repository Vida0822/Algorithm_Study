package cH1_기본알고리즘;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 9:43:06
 *	@subject 반복 
 * @content  +- 를 번갈아서 출력한다 


 */
public class ex12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n ; 
		
		System.out.println("+와 -를 번갈아 n개 출력합니다. ");
		
		do { 
			System.out.print("n 값 : ");
			n = sc.nextInt() ; 
		}while(n <= 0 ) ; 
		
		for (int i = 0; i < n; i++) { // 만약 i 가 변화하면 ex) 1 
			if(i % 2 ==0) 
				System.out.print("+"); // 이것도 - 로 바꿔줘야하고 
			else
				System.out.println("-"); // // 이것도 + 로 바꿔줘야함 
		} // for 	

	} // main

}
