package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 위에서아래로_JavaLibrary {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		Integer[] arr = new Integer[n] ; 
		
		for(int i = 0 ; i < n ;i++) {
			arr[i] = sc.nextInt() ; 
		}	
		
//		int[] arr = new int[n] ; => 에러  
		Arrays.sort(arr, Collections.reverseOrder());
		/*
		 * sort(T[] a, Comparator<? super T> c) 
		 * Comparator는 정렬대상이 '객체'일 때 사용가능 => 기본형 객체인 Integer을 사용해줘야한다
		 */
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i]);
		}
	}
}
