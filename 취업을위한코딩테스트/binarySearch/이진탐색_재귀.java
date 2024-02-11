package binarySearch;

import java.util.Scanner;

public class 이진탐색_재귀 {
	
	public static int binarySearch(int[] arr , int target, int start, int end) {

		// 종료조건 1) 찾고자하는 값이 없음 
		if(start > end) return -1 ; 
		
		int mid = (start+end)/2 ; 
		if(arr[mid] == target) return mid ; // 종료조건 2) 값을 찾음
		
		// 중간점의 값보다 찾고자하는 값이 작은경우, 중간점 왼쪽으로 끝점을 옮겨 다시 이진 탐색 
		else if(arr[mid] > target) return binarySearch(arr,target, start, mid-1);
		else return binarySearch(arr, target, mid+1, end) ; 		
	}
} // class
