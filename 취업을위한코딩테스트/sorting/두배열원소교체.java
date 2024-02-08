package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 두배열원소교체 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int k = sc.nextInt() ; 
		
		Integer[] A = new Integer[n] ; 
		Integer[] B = new Integer[n] ; 
		
		for(int i = 0 ; i < n ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < n ; i++) {
			B[i] = sc.nextInt();
		}
		Arrays.sort(A); // 작은값부터 정렬 
		Arrays.sort(B, Comparator.reverseOrder()); // 큰값부터 정렬 
		/*
		 * sort(T[] a, Comparator<? super T> c) 
		 * Comparator는 정렬대상이 '객체'일 때 사용가능 => 기본형 객체인 Integer을 사용해줘야한다
		 */
		
		for(int i = 0 ; i < k ; i++) {
			// ※ A원소가 더 작을경우를 대비해 대소비교 해줘야함 
			if(A[i] >= B[i])
				break ; 
			
			int temp = A[i] ; 
			A[i] = B[i] ; 
			B[i] = temp ; 
		}
		int answer = 0 ; 
		for(int i = 0 ; i < n ; i++) {
			answer += A[i] ; 
		}
		System.out.println(answer);
	} 
}
