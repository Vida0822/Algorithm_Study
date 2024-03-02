package graph;

import java.util.Scanner;

public class UnionFind_Simple {
	
	public static int v, e ;
	public static int[] parent = new int[100001] ;
	
	// find 연산: 특정한 원소가 속한 집합이 어떤 집합인지 알려주는 연산 
	public static int find(int x) {
		if(x == parent[x] ) return x ; 
		return parent[x] = // 추가(경로 압축) : 해당 노드의 루트 노드가 바로 부모노드가 된다
				find(parent[x]); 
	}
	
	// union 연산 : 2개의 원소가 포함된 집합을 하나로 합치는 연산
	public static void union(int a, int b){
		int a_root = find(a) ;  // 루트 
		int b_root = find(b) ;  // 루트 
		
		// 작은쪽의 노드를 부모로 설정 (나중에 개선됨) 
		if(a_root<b_root) parent[b] = a_root ; 
		else parent[a] = b_root ; 
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in) ; 
		v = sc.nextInt() ; 
		e = sc.nextInt() ; 
		
		// 부모테이블 초기회 (부모를 자기자신)
		for(int i = 1 ; i <= v ; i++) {
			parent[i] = i ; 
		}
		

	}

}
