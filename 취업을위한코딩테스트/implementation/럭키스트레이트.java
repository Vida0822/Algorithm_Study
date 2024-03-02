package implementation;

import java.util.Scanner;

public class 럭키스트레이트 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		String N = sc.next(); 
		
		int len = N.length(); 
		int f = 0 , b = 0 ; 
		for(int i = 0 ; i < len/2 ; i++) {
			f += Integer.parseInt(N.charAt(i)+"") ; // N.charAt(i) - '0'
			b += Integer.parseInt(N.charAt(len-i-1)+"") ; 
		}
		if(f == b)
			System.out.println("LUCKY");
		else 
			System.out.println("READY");

	}

}
