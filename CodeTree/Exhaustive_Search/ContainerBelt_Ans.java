package Exhaustive_Search;

import java.util.Scanner;

public class ContainerBelt_Ans {
	
	public static final int MAX_N = 200; 
	
	public static int n,t ;
	
	public static int[] u = new int[MAX_N + 1] ;  // upper belt 
	public static int[] d = new int[MAX_N + 1] ;  // down belt 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		
		// part 1. 컨테이너 벨트 채우기 
		n = sc.nextInt() ; 
		t = sc.nextInt() ; 
		
		for (int i = 0; i < n; i++) {
			u[i] = sc.nextInt() ; 
		} // up for 
		
		for (int i = 0; i < n; i++) {
			d[i] = sc.nextInt() ; 
		} // down for 
		
		// part 2 컨테이너 벨트 돌리기 
		while(t-- > 0) { // 1. 비교 -> 2. 감산  ex) t=1 --> t>0 : true & t -- => t=0  ;  반복문 실행 
			
			// 1) temp 저장 
			int temp = u[n-1] ; 
			
			// 2) 오른쪽으로 왼쪽 숫자 당겨오기 
			for (int i = n-1; i >= 1; i--) {
				u[i] = u[i-1] ; // i >= 0 --> Out Of Index 
			}
			u[0] = d[n-1] ; // 아래쪽 소실 값은 temp 에 담아주는게 아니라 그냥 바로 upper 에 대입해버림 
			
//			for (int i = n-1; i >= 1; i++) {
			// out of index 나오는 이유 : 빼야하는데 값을 더해 영원히 i>=1 은 true
			// ==> 그러다 index 200 초과하는 순간 out of Bound
			
			for (int i = n-1; i >= 1; i--) {
				d[i] = d[i-1] ; 
			}
			d[0] = temp ; 
			
		} // 초가 다 닳을 때까지 t 번 반복 
		
		// part 3. 출력 
		for (int i = 0; i < n; i++) {
			System.out.print(u[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			System.out.println(d[i] + " ");
		}
		System.out.println();
		
		
	} // main 
	

	
} // ContainerBelt_Ans
