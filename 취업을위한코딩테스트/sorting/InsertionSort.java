package sorting;

public class InsertionSort { // O(n^2) 
	public static void main(String[] args) {
		
		int n = 10 ; 
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8} ; 
		
		for(int i = 1 ; i < n ; i++) {
			// 배열의 요소 갯수 만큼 반복한다 
			
			for(int j = i ; j > 0 ; j--) {
				// 각 요소마다 왼쪽 요소와 비교해가면서 
				
				if(arr[j] < arr[j-1]) { // 왼쪽요소가 크면 swap --> 비교 이어서 
					int temp = arr[j] ; 
					arr[j] = arr[j-1] ; 
					arr[j-1] = temp; 
				}else
					break ; // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤  
			}
		}
		for(int i = 0 ; i < n ; i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
