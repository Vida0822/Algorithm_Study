package cH2_기본자료구조;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 8:58:12
 *	@subject 배열 
 * @content 


 */
public class ex03 {

	
	static int maxOf(int[] a) {
		
		int max = a[0] ; 
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max)
				max=a[i] ; 
		}
		return max ; 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = sc.nextInt() ; 
		
		int[] height = new int[num]; 
		
		for (int i = 0; i < num; i++) {
			System.out.print("height["+i+"]: ");
			height[i] = sc.nextInt(); 
		} // for 
		
		System.out.println("최댓값은" + maxOf(height)+"입니다.");
	} // main 

}
