package greedy;

import java.util.Scanner;

/**
 * @author SHIN HEEMIN
 * @problem Greedy-문자열 뒤집기 
 *
 */
public class 문자열뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		String s = sc.next() ; 
		
		// step 1. 각 숫자 별 연속 횟수 연속(묶음) 횟수 count 
		// step 2. 둘중 적은 숫자가 곧 최소 flip 횟수 
		// point : 실제로 flip 연산을 수행할 필요 없다 
		int c0 = s.split("1+").length ; 
		int c1 = s.split("0+").length ; 
		
		if(s.charAt(0) == '0')
			c1-=1 ;
		else
			c0-= 1 ; 
		
		System.out.println(c0 < c1 ? c0 : c1) ; 
		
	}

}
