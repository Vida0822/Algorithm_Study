package sorting;

public class SelectionSort { // O(n^2)

	public static void main(String[] args) {
		
		int n = 10 ; 
		int[] arr = {7, 5, 9, 0, 1, 6, 2, 4, 8 }; 
		
		for(int i = 0 ; i < n ; i++) { // 배열 크기만큼 작은 수 찾기 시행 
			int min_index = i ; // 가장 작은 원소가 들어갈 자리  
			
			// 가장 작은 수를 찾아서 
			for(int j = i+1 ; j < n ; j++) { 
				// 대소관계 비교 범위가 i가 증가함에 따라 그 뒤에것들만 비교 
				if(arr[min_index] > arr[j])
					min_index = j ; 
			}
			// 맨 앞이랑 스와프 
			int temp = arr[i] ; 
			arr[i] = arr[min_index] ; 
			arr[min_index] = temp; 
		}
		
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
