package ch3_배열검색;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 4:49:10
 *	@subject Arrays.binarySearch 객체배열에서의 문자열 검색 
 * @content 자연 정렬된 배열에서 요소간 대소관계를 파악하고 검색 


 */
public class ex06 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		String[] x = {
				"abstract", "assert", "boolean", "break", "byte", 
				"case", "catch", "char", "class", "const", 
				"continue", "default", "do", "double", "else", 
		} ; 
		
		System.out.print("원하는 키워드를 입력하세요 : "); // key값 입력 
		String key = sc.next();  
		
		int idx = Arrays.binarySearch(x, key) ; 
		
		if(idx < 0)
			System.out.println("해당 키워드가 없습니다");
		else
			System.out.println("해당 키워드는 x["+idx+"]에 있습니다.");
		
		
	} // main 	
} // class 
