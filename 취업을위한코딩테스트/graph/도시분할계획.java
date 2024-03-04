package graph;

import java.util.*;

public class 도시분할계획 {
	
	public static int[] parent  = new int[100001]; 
	public static ArrayList<Edge> edges = new ArrayList<>() ; 
	public static int n, m ;
	public static int result = 0 ; 
	
	public static int find(int x) { // (int x , int[] parent) 
		if(x == parent[x]) return x ;
		return parent[x] = find(parent[x]) ;
		// 이부분 문제 : 담아놓고 반환하지 않음 
		// static이 아닌 그냥 전달받은 매개변수를 변화시키는 것 --> 실제로 호출해준 곳의 parent 배열엔 아무 영향 주지 x 
		// ㄴㄴ 전달할 때 배열(참조형)을 전달하기 때문에 그 매개변수를 갱신하면 자동으로 해당 주소의 배열이 변경됨 
 	}
	
	public static void union(int x, int y) {
		int x_root = find(x) ; 
		int y_root = find(y) ; 
		/* 
		if(x_root < y_root)
			parent[y] = x_root ; 
		else
			parent[x] = y_root ; 
		ㄴ 이렇게 하면 안되는 이유 : union연산은 각 집합의 '루트노드'의 '부모'를 다른쪽 루트노드로 설정해주는 것 
		=> 이렇게 하면 그냥 x,y의 부모가 루트노드로 됨 (해당 노드의 '이동'인셈) -->  
		*/
		if(x_root < y_root)
			parent[y_root] = x_root ; 
		else
			parent[x_root] = y_root ; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		// 부모 테이블 초기화 
		for(int i = 1 ; i <= n ; i++) {
			parent[i] = i ; 
		}
		
		// 그래프 만들기 
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt() ;
			int b = sc.nextInt() ; 
			int c = sc.nextInt() ;
			edges.add(new Edge(c, a, b)) ;		
		}
		// 간선 가중치 오름차순 정렬 
		Collections.sort(edges);
		
		// 크루스칼 알고리즘 : 최소비용신장트리 만들기 
		int last = 0 ; 
		for(int i = 0 ; i < edges.size(); i++) { 
			// 마지막 간선은 더하지 않는다(분리) 
			// --> x : 얘는 분리가 아님, 마지막으로 검사한 간선이 꼭 사용되는 간선이라고 볼 수 없기 때문
			// => 최소신장비용트리를 먼저 만들고, 구성 간선 중 가장 큰 걸 빼줘야함
			int cost = edges.get(i).getDistance() ; 
			int nodeA = edges.get(i).getNodeA() ; 
			int nodeB = edges.get(i).getNodeB() ; 
			
			if(find(nodeA) != find(nodeB)) {
				union(nodeA, nodeB) ; 
				result += cost ; 
				last = cost ;  
			}
		}
		System.out.println(result-last);
	}
}
