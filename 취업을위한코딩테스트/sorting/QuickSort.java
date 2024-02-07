package sorting;

public class QuickSort { // O(NlogN)
	
	public static void quickSort(int[] arr, int start, int end) {
		// 퀵 정렬은 재귀함수로 구현한다 
		
		// 종료조건 
		if(start >= end) // 원소가 1개인 경우  
			return ; 
		
		int pivot = start ; 
		int left = start + 1 ; // 왼쪽부터 피봇보다 작은지 검사 
		int right = end ; // 오른쪽부터 피봇보다 큰지 검사 
		
		while(left <= right) { // '인덱스'가 교차할 때까지 
			while(left <= end && arr[left] <= arr[pivot]) 
				// 피봇보다 작은 데이터의 index 뽑고 
				left++ ;
			// 검사 index가 end를 맞닦드리면 반복 종료 
			
			while(right > start && arr[right] >= arr[pivot])
				// 피봇보다 큰 데이터의 index를 뽑아서 
				right-- ; 
			// 검사 index가 start를 맞닦드리면 반복 종료 
			
			// 1) pivot을 기준으로 큰값, 작은 값 분류 
			if(left <= right) {
				int temp = arr[left] ; 
				arr[left] = arr[right] ; 
				arr[right] = temp ; 
			
			// 2) 엇갈렸다면 피봇과 작은 데이터를 교체 ※ 엇갈린 상태로 index가 고정되었으므로 left가 아니라 right가 pivot보다 작은 값임  
			// 		=> 그루핑 
			}else {
				int temp = arr[pivot] ; 
				arr[pivot] = arr[right]; 
				arr[right] = temp ; // pivot값이 right 위치에 들어감 
			}
		}
		// 3) 피봇을 기준으로 왼쪽, 오른쪽 리스트를 각각 퀵정렬 수행 (재귀함수 호출)
		quickSort(arr, start, right-1) ; // start ~ pivot-1 퀵 정렬 
		quickSort(arr, right+1, end) ; // pivot+1 ~ end 퀵정렬 	
	} // quickSort
	
	public static void main(String[] args) {
		int n = 10 ; 
		int[] arr = {7,5,9,0,3,1,6,2,4,8} ; 
		
		quickSort(arr, 0, n-1); // 전체를 대상으로 퀵정렬 수행 
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i]+" ");
		}
	} // main
} // class 
