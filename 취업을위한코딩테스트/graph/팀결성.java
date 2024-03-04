package graph;

import java.util.Scanner;

public class 팀결성 {
	public static int[] parent ; 
	
	public static void init() {
		for(int i = 0 ; i < parent.length ; i++) {
			parent[i] = i ; 
		}
	}
	
	public static void union(int s1, int s2) {
		int s1_root = find(s1) ; 
		int s2_root = find(s2) ; 
		
		if(s1_root <= s2_root)
			parent[s2] = s1_root ; 
		else
			parent[s1] = s2_root ; 
	}
	
	public static int find(int s) {
		if(parent[s] == s)
			return parent[s] ;
		return parent[s] = find(parent[s]) ; 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		
		int n = sc.nextInt() ; 
		parent = new int[n+1] ;
		init() ;
		
		int m = sc.nextInt() ;
		for(int i = 0 ; i < m ; i++) {
			int operation = sc.nextInt() ; 
			int s1 = sc.nextInt() ; 
			int s2 = sc.nextInt() ; 
			
			if(operation == 0)
				union(s1,s2) ; 
			else {
				if(find(s1) == find(s2))
					System.out.println("YES");
				else 
					System.out.println("NO");
			}
		}
	}
}
