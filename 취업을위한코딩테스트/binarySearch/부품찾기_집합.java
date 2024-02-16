package binarySearch;

import java.util.HashSet;
import java.util.Scanner;

public class 부품찾기_집합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		
		HashSet<Integer> s = new HashSet<>() ; 
		for(int i = 0 ; i < n ; i++) {
			int x = sc.nextInt() ;
			s.add(x) ;
		}
		int m = sc.nextInt() ; 
		int[] targets = new int[m] ;
		for(int i = 0 ; i < m ; i++) {
			targets[i] = sc.nextInt() ; 
		}

		for(int i = 0 ; i < m ; i++) {
			if(s.contains(targets[i]))
				System.out.print("yes ");
			else
				System.out.println("no ");
		}
	}

}
