package ch2_기본자료구조;

import java.util.Arrays;

/**
 * @author HEEMIN
 * @date 2023. 9. 11.-오후 5:09:45
 *	@subject 배열 
 * @content   배열이 복제 


 */
public class c_1 {

	public static void main(String[] args) {

		int [] a = {1,2,3,4,5,}; 
		int [] b = a.clone() ; 
		
		
		b[3] = 0; 
		
		System.out.println("a = "+Arrays.toString(a));
		System.out.println("b = "+Arrays.toString(b));
	}

	
}
