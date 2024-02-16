package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 부품탐색_이진탐색 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 

		int n = sc.nextInt() ; // 1,000,000 --> 매우 큼 : 이진 탐색 고려
		int[] arr = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt() ; 
		}
		Arrays.sort(arr);
		
		int m = sc.nextInt() ; 
		int[] search = new int[m] ; 
		for(int i = 0 ; i < m ; i++) {
			search[i] = sc.nextInt() ; 
		}
		
		for(int i = 0 ; i < m ; i++) {
			if(binarySearch(arr, 0, arr.length-1 , search[i] )!=-1)
				System.out.print("yes ");
			else 
				System.out.print("No ");
		}
				
	}
	public static int binarySearch(int[] arr , int start, int end, int target) {
		
		if(start > end) return -1 ; 
		
		int mid = (start+end)/2 ;
		if(arr[mid] == target) return mid ; 
		else if(arr[mid] < target) return binarySearch(arr, mid+1, end, target ) ; 
		else return binarySearch(arr, start, mid-1, target) ; 
		
	}

}
