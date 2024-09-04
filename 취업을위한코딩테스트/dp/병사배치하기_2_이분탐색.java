package dp;
import java.util.* ; 

public class 병사배치하기_2_이분탐색 { // O(N log N) 
	
	// 이중 for문' dp : 앞의 모든 원소를 탐색 --> 이 과정을 log(N) 으로 줄여보자 
	// 핵심 원리 : dp 배열에 채워진 원소의 값들이 LIS 배열 자체를 의미하지는 않더라도
	// 			dp 배열의 길이 자체는 LIS 길이와 일치한다. 
	
	public static int[] dp ; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt(); 
		
		int[] soilders = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			soilders[i] = sc.nextInt(); 
		}
		
		dp = new int[n] ; 
		
		int LIS = 0 ; 
		
		for(int i = 0 ; i < n ; i++) {
			
			if(soilders[i] > dp[LIS]) 
				dp[LIS++] = soilders[i] ; 
			else {
				// 해당 비교값보다 큰 값들 중 가장 작은 값을 찾아서 
				int idx = lowerbound(soilders[i] , 0, LIS) ;
				
				// 교체 --> 가장 작은 증가 폭을 갖는 부분 수열이 되게끔 시시각각 갱신하는 원리가 길이를 늘리는 원리 (greedy) 
				// ㄴ LIS를 구성하는 정보는 다음 검사 대상의 원소가 포함될 수 있게끔하는 (길이를 늘릴 수 있는) 최상의 정보 
				// '교체'이기 때문에 해당 dp원소의 최종 길이는 변하지 않는다. but 단지 각각의 원소를 최대한 작은 값으로 바꿔주면서 그 뒤의 원소들은 더 작은 비교 대상을 가지게 됨 (수열에 포함될 확률이 더욱 커짐) 
				/*
				 * arr : 10 50 20 30 15 16 20 
				 * Step 1. dp : 10 50  --> 이대로였으면 30을 끝 원소와 비교했을 때 포함되지 못함 
				 * Step 2. dp : 10 20 --> 50을 20으로 교체함으로써 30이 원소로 포함될 수 있게끔 최적화 
				 * Step 3. dp : 10 20 30  --> 성공적으로 30 포함 
				 * Step 4. dp : 10 15 30  --> 20을 15로 대체 
				 * Step 5. dp : 10 15 16 --> 30을 16으로 대체 --> 30이었으면 뒤의 원소인 20이 수열에 포함되지 못했음, 만약 그 이전의 20이 15로 교체되지 않았다면 10 16 30으로 뒤 원소 20이 포함되지 못했음
				 * Step 6. dp : 10 15 16 20 --> 최장 증가 길이 수열 
				 * 
				 * ※ dp 배열 자체가 최장증가부분수열을 의미 X --> 가능성을 의미 
				 * 
				 * O(log N) : 해당 숫자가 들어갈 위치를 정렬된 배열에서 이분탐색으로 찾고(O nlogn), 교체 (O 1) 
				 */
				dp[idx] = soilders[i] ; 				
			}
		}
		System.out.println(LIS);		 
	}
	
	// upperbound : 찾고자 하는 값(obj) 이하가 처음 나타나는 위치 <-> obj값보다 큰 값들 중 가장 작은 값 
	// lowerbound : 찾고자 하는 값(obj) 이상이 처음 나타나는 위치 <-> obj 값보다 작은 값들 중 가장 큰 값 
	public static int lowerbound(int num, int start, int end) {
		
		int res = 0 ; 
		
		while(start <= end) { 
			int mid = (start+end)/2 ; 
			
			if(num <= dp[mid]) {
				res = mid ; 
				end = mid -1 ; 
			}else
				start = mid+1 ; 	 
		}
		return res ;
	}

}
