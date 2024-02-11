package binarySearch;

public class 이진탐색_반복 {
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		while(start <= end) {
			// 보통 재귀함수의 대체로 while 반복문을 사용한다
			int mid = (start+end)/2 ; 
			
			// 종료조건 
			if(arr[mid] == target)
				return mid ; // 반복문을 나가는 것이 아닌 함수를 종료 
			else if(arr[mid] > target) 
				end = mid-1 ; 
			else
				start = mid +1 ;
		}
		return -1; 
	}

} // class 
