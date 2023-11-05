package ch06_sort;

/**
 * @author HEEMIN
 * @date 2023. 11. 3.-오전 10:38:42
 *	@subject 단순 정렬 
 * @content 단순 선택 정렬 

 */
public class Ex02_selectionSort {

	public static void main(String[] args) {
	
	} // main 
	
	static void selectionSort(int[] a , int n ) {
		for (int i = 0; i < n-1; i++) {
			int min = i ; 
			for (int j = i+1 ; j < n ; j++) {
				if(a[j] < a[min])
					min = j ; 
			} // for
			int temp = a[i] ; 
			a[i] = a[min] ; 
			a[min] = temp ; 
 		} 
	}
} // class 
