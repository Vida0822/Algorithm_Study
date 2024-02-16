package binarySearch;

import java.util.Scanner;

public class 부품찾기_계수정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 

		int n = sc.nextInt() ; 
		int[] arr = new int[1000001] ; // 모든 원소 도메인을 포함할 수 있는 크기의 리스트  
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt() ;
			arr[x] = 1 ; // x번 물품이 1개 있다 
		}
		int m = sc.nextInt() ; 
		int[] targets = new int[m] ;
		for(int i = 0 ; i < m ; i++) {
			targets[i] = sc.nextInt() ; 
		}
		
		for(int i = 0 ; i < m ; i++) {
			int target = targets[i]; 
			if(arr[target]==1) {
				System.out.println("yes ");
			}else {
				System.out.println("no ");
			}
		}
		

	}

}
