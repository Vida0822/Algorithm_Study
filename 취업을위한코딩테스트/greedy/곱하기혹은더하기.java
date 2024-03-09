package greedy;

import java.util.Scanner;

public class 곱하기혹은더하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		String S = sc.next() ;
		
		int answer = S.charAt(0) -'0' , b; 
		for(int i = 1 ; i < S.length() ; i++) {
			b = S.charAt(i) - '0' ;
			
			if(answer <= 1 || b <= 1)
				answer += b ; 
			else 
				answer *= b ; 
		}
		System.out.println(answer);
	}
}
