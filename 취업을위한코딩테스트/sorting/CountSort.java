package sorting;

public class CountSort { // O(N+K)
	
	public static final int MAX_VALUE = 9 ; 

	public static void main(String[] args) {
		int n = 15 ; 
		
		// 정렬 대상 배열 (제한 조건 : 모든 원소의 값은 0~9안에 속하는 자연수이다 )
		int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2} ; 

		// 도메인 배열 : 도메인에 포함될 수 있는 값 갯수(종류)를 크기로하는 List 생성
		int[] cnt = new int[MAX_VALUE+1] ; 
		
		// 정렬 대상 배열의 데이터를 하나씩 읽으며, 해당 도메인값의 등장횟수를 도메인 배열의 value값(등장횟수)에 반영
		for(int i = 0 ; i < n ; i++) { // 데이터들의 값을 하나씩 검사하면서
			int num = arr[i] ; // 7이 나오면 
			cnt[num] += 1 ; // 7번째 배열의 값(count) 1증가	
		}
		
		// 도메인 배열의 key값을 value값 만큼 반복해서 출력 --> TreeMap<>으로도 구현할 수 있지 않을까?(+동적으로 관리할 수 있는 장점 추가) 
		for(int i = 0 ; i <= MAX_VALUE ; i++) {
			for(int j = 0 ; j < cnt[i] ; j++) {
				System.out.print(i+" ");
			}
		}
	} // main 
} // class 
