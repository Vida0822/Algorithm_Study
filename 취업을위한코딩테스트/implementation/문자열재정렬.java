package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열재정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		String S = sc.next() ; 
		
		int nums = 0; 
		ArrayList<Character> alps = new ArrayList<>() ; 
		
		for(int i = 0 ; i < S.length() ; i++) {
			char c = S.charAt(i) ; 
			if(c <= '9') 
				nums += c -'0' ; 
			else
				alps.add(c) ; 
		}
		
		Collections.sort(alps); 
		
		for(char c : alps) {
			System.out.print(c);
		}
		if(nums != 0)
			System.out.print(nums);
	}
}
