package ch2_기본자료구조;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 9:21:27
 *	@subject 배열 
 * @content 알고리즘 - 역순으로 정렬하기 


 */
public class ex05 {
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("요솟수: ");
		int num = sc.nextInt(); 
		
		int[] x = new int[num]; 
		
		for (int i = 0; i < num; i++) {
			System.out.print("x["+i+"]:" );
			x[i] = sc.nextInt(); 
		} // for 
		
		reverse(x); // 배열을 매개변수로 받음 
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		System.out.println("x = "+ Arrays.toString(x)); 
			
	} // main 
	

	static void reverse(int[] a) {
		for (int i = 0; i < a.length/2; i++) { // 1. 반복 횟수 도출 메서드 
			swap(a,i,a.length-i-1) ; // 앞에서 하나씩 늘려갈수록 뒤에서 하나씩 줄임 
		} // for 
	} // reverse 
	
	static void swap(int[] a, int idx1, int idx2) { // 2. 교환과정 도출 메서드 
 		int t = a[idx1] ; 
		a[idx1] = a[idx2] ; 
		a[idx2] = t; 
	} // swap 
	
	
	
 
}
