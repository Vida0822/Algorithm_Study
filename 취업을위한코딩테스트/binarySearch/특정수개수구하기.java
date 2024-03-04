package binarySearch;

import java.util.Scanner;

public class 특정수개수구하기 { // O(N log N)으로 
	
	// 찾는 값 target이 처음 나오는 index
	public static int lowerBound(int[] arr, int target, int start, int end) {
		int found = 0 ; 
		while(start<end) {
			int mid = (start+end)/2 ; 
			if(arr[mid] >= target) {				
				found = mid; 
				end = mid ; 
			}
			else // 중간값이 target보다 작으면 
				start = mid+1 ;  // 오른쪽 탐색 --> target과 처음으로 같아지는 중간값 반환
		}
		return found ; // arr[mid] >= target && start == end
	}
	
	// 찾는 값 target 보다 커지는 값의 index 
	public static int upperBound(int[] arr, int target, int start, int end) {
		int found = 0 ; 
		while(start<end) {
			int mid = (start+end)/2 ;
			if(arr[mid] > target) {
				found = mid ;				
				end = mid ;
			}else // 중간값이 target 값보다 작거나 같은 경우  
				start = mid+1 ;  // 오른쪽 탐색 --> target값보다 처음으로 커지는 중간값 반환  
		}
		return found ; // arr[mid]>target && start == end 
	}
	

	public static int countByRange(int[] arr, int leftValue, int rightValue) {
		int rightIndex = upperBound(arr, rightValue, 0, arr.length) ; 
		int leftIndex = lowerBound(arr, leftValue, 0, arr.length) ; 
		return rightIndex - leftIndex ; 
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int x = sc.nextInt() ; 
		
		int[] nums = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			nums[i] = sc.nextInt(); 
		}
		
		int cnt = countByRange(nums, x, x) ; 
		if(cnt == 0) System.out.println(-1);
		else	System.out.println(cnt);

	}
}
