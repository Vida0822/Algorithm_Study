package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 프림알고리즘 {

	public class Node_Prim implements Comparable<Node_Prim>{
		int index ; 
		int cost ; 
		
		public Node_Prim(int index, int cost) {
			this.index = index ; 
			this.cost = cost ; 
		}
		@Override
		public int compareTo(Node_Prim other) {
			return this.cost - other.cost; 
		}	
	}
	
	public List<List<Node_Prim>> graph = new ArrayList<>() ; 
	
	public int solution(int n, int[][] costs) {
		
		// 초기화 (그래프 만들기) 
		for(int i = 0 ; i < n ; i++) {
			graph.add(new ArrayList<>()) ; 
		}
		for(int i = 0 ; i < costs.length ; i++) {
			int from = costs[i][0] ; 
			int to = costs[i][1] ; 
			int val = costs[i][2] ; 
			
			graph.get(from).add(new Node_Prim(to, val)); 
			graph.get(to).add(new Node_Prim(to, val)) ; 
		}
		
		// 프림 알고리즘 
		boolean[] visited = new boolean[n] ; // 각 노드만큼 크기의 방문여부배열
		PriorityQueue<Node_Prim> q = new PriorityQueue<>() ; 
		q.add(new Node_Prim(0,0)) ; // 검사 시작 노드 
		
		int answer = 0 ; 
		while(!q.isEmpty()) {
			Node_Prim cur = q.poll() ; // 가중치가 가장 작은 노드 반환 
			if(visited[cur.index]) continue ; 
			
			visited[cur.index] = true ; 
			answer += cur.cost ;  
			// a 노드에 부속된 간선 중 가능 작은 값이므로 answer에 누적 
			// b 노드로 확대 
			
			// 인접 노드 큐에 추가  
			for(int i = 0 ; i < graph.get(cur.index).size(); i++) {
				int next = graph.get(cur.index).get(i).index ; 
				int cost = graph.get(cur.index).get(i).cost ; 
				if(visited[next]) continue ; // 해당 인접 노드는 큐에 추가 X 
				q.add(new Node_Prim(next, cost)) ; 
			} // for 
		} // while
		return answer ; 
	} 
}
