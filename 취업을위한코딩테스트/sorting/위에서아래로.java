package sorting;

import java.util.Scanner;

public class 위에서아래로 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int[] arr = new int[n] ; 
		
		for(int i = 0 ; i < n ;i++) {
			arr[i] = sc.nextInt() ; 
			
			a: for(int j = i ; j > 0 ; j--) {
				if(arr[j] > arr[j-1]) {
					int temp = arr[i] ; 
					arr[i] = arr[i-1] ; 
					arr[i-1] = temp; 
				}else {
					break a; 
				}
			}
		}	
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i]);
		}
	}
}
