package ch5_재귀알고리즘;

import java.util.Scanner;
import java.util.Stack;

public class Ex05 {
	
	static void recur(int n) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		while(true) {
			if(n>0) {
				s.push(n); 
				n=n-1 ; 
				continue; // 남은 반복문 코드 건너뜀 <-> 다시 while문으로 돌아감 ! : n이 0이 될때까지 스택에 채움  
			}
			if(s.isEmpty() != true) { // 비어있지 않으면 
				n = s.pop() ; // 스택에 저장된 숫자들  
				System.out.println(n);  // 출력 
				n = n-2 ; 
				continue ; 
			}
			break ; 
		}
	} // recur 


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		System.out.print("정수를 입력하세요: ");
		int x = sc.nextInt() ; 
		
		recur(x) ; 

	} // main 

}
