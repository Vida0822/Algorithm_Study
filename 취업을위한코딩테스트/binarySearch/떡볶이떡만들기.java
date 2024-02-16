package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class 떡볶이떡만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; // array 
		int m = sc.nextInt() ;  // target 
		
		int[] yum = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			yum[i] = sc.nextInt() ; 
		}
		Arrays.sort(yum);
		int max = yum[yum.length-1]; 
		// target을 감당할 수 있는가?유형 이진 탐색 문제 
		// 절단기의 높이를 m/2으로 설정한 후, 감당 가능하면 왼쪽 범위를 불가능하면 오른쪽 범위로 확대 
		int start = 0, end = max ;  
		int answer = 0 ; 
		while(start <= end) {
			
			int mid = (start+end)/2 ; 
			if(isPossible(yum, mid,m )) {
				answer = mid; 
				start = mid + 1  ;
			}else
				end = mid - 1 ; 
		}
		System.out.println(answer);
	} // main 
	
	public static boolean isPossible(int[] yum, int cut, int m) {
		int dduck = 0 ; 
		for(int i = 0 ; i < yum.length ; i++) {
			// 떡이 부족한 경우도 고려해줘야함 --> 안그러면 음수값이 누적
			if(yum[i] < cut)
				continue ; 
			
			dduck += (yum[i] - cut) ; 
			if(dduck >= m )
				return true ; 
		}
		return false ; 
	}
	
} // class 
 