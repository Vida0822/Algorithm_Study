package ch06_sort;

import java.util.Scanner;

public class Ex01_BubbleSort {
	
	public static void swap(int[] a, int idx, int idx2) {
		int t = a[idx] ;  // '교환' : temp 변수에 넣어두기 
		a[idx] = a[idx2] ; 
		a[idx2] = t ; 
	} // swap 
	
	public static void bubbleSort(int[] a, int n) {
		
		int k = 0 ;

		while(k < n-1 ) {
			int last = n-1 ; 
			for (int i = n-1 ; i >  k ;  i-- ) {
				if(a[i-1] > a[i]) {
// 					swap(a, i-1 , i) ; 				
					int t = a[i-1] ; 
					a[i-1] = a[i] ; 
					a[i] = t ; 
					
 					last = i ; 
				}
			k= last; 
			}	
		}
	} // bubbleSort

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 

		System.out.println("버블 정렬(버전1) ");
		System.out.print("요솟수 : ");
		int nx = sc.nextInt() ; 
		int[] x = new int[nx]; 
		
		for (int i = 0; i < nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = sc.nextInt() ; 
		}	
		bubbleSort(x, nx) ; 
	}
}
