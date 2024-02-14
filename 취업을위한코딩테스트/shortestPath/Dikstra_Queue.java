package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Dikstra_Queue { // O(ElogV) 

	public static final int INF = (int) 1e9 ;  // 무한 (10억) 
	
	// 노드갯수, 간선갯수, 시작노드번호 
	public static int n , m , start ; 
	// 그래프 ; 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열 
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>() ; 
	// 방문 여부 배열 
	public static boolean[] visited = new boolean[100001] ; 
	// 최단 거리 테이블 (계속 갱신됨) 
	public static int[] d = new int[100001] ; 
	
	
	// 최단 경로 구하기 (전체 과정) 
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>() ; 
		pq.offer(new Node(start,0)) ; // 시작 노드로 가기 위한 최단 경로는 0 
		d[start] = 0 ; 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll() ; // 가장 짧은 최단거리 노드 꺼내기 
			int dist = node.getDistance() ; 
			int now= node.getIndex() ; 
			
			// 현재 노드가 이미 처리된 적이 있는 노드라면 무시
			if(d[now] < dist) continue ; 
			
			for(int i = 0 ; i < graph.get(now).size() ; i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance() ; // 인접 노드들 방문 
				
				// 현재 노드를 거치는 거리가 더 짧은 경우 
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					// 최단 거리 갱신 
					d[graph.get(now).get(i).getIndex()] = cost ; 
					// 해당 인접 노드 큐에 추가 (왜 더 짧아야 추가?? ) 
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost)); 
				} // if 
			} // for 
		} // while
	} // dijkstra
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt() ; 
			int b = sc.nextInt() ; 
			int c = sc.nextInt() ; 
			graph.get(a).add(new Node(b,c)) ; 
			// a번 노드에서 b번 노드로 가는 비용이 c라는 의미
		}
		// 최다너리 테이블을 모두 무한으로 초기화 
		Arrays.fill(d, INF) ; 
		
		// 다익스트라 알고리즘 수행 
		dijkstra(start); 
		
		// 모든 노드로의 최단 거리 출력 
		for(int i = 1 ; i <= n ; i++) {
			if(d[i] == INF) { // 도달할 수 없는 경우 
				System.out.println("INFINITY");
			}
			System.out.println(d[i]);
		}
	} // main 
} // class 
