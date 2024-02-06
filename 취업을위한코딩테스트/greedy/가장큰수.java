package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 가장큰수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ;  // 숫자 종류의 갯수 
	 	int m = sc.nextInt(); // 더하는 횟수 
		int k = sc.nextInt(); // 연속해서 등장할 수 있는 최대 횟수  
		
		// part 1. 숫자 종류 입력 받기 
		int[] arr = new int[n] ; 
		for (int i = 0; i < n ; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		// part 2. 더할 숫자 준비 
		/*
		 * 사용한 아이디어: 가장 큰 숫자를 계속 더해주면서 최대 연속횟수를 초과하지 않게끔만 두번째로 큰 숫자를 중간중간 넣어준다  
		 */
		Arrays.sort(arr); 
		
		int first = arr[n-1] ; 
		int second = arr[n-2] ; 
		
		// part 3. 수학적 아이디어로 변환 - 해당 두 숫자의 반복되는 횟수 구하기 
		int cnt = (m / (k+1)) * k ; // 가장 큰 숫자가 반복되는 횟수 
		cnt += m % (k+1) ; // 수열을 완성시키지 못한 숫자들은 자동적으로 가장 큰 수 -> 가장 큰 수 등장 횟수에 포함 
		
		// part 4. 정답 구하기 - 횟수만큼 숫자 더하기 
		int result = 0 ; 
		result += cnt * first ; // 첫번째로 큰 숫자 * 등장 횟수 
		result += (m - cnt) * second ;  // 두번째로 큰 숫자 * 등장 횟수 (최종 등장 횟수 - 첫번째 수수자 등장 횟수) 
		
		System.out.println(result) ;
		
		
	}

}
