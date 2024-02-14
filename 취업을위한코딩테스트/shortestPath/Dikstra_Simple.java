package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node{
	private int index ; 
	private int distance ; 
	
	public Node(int index, int distance) {
		this.index = index;  // 노드 번호 
		this.distance = distance ;  // 간선 가중치 ; 이전 노드에서 현재 노드까지의 거리  
	}
	
	public int getIndex() {
		return this.index ; 
	}
	public int getDistance() {
		return this.distance ; 
	}
} // Node 

public class Dikstra_Simple { // O(V^2) , 전체 노드 갯수 5000개 이하 
	/* 
	 * 핵심 : (방문하지 않은 노드 중 가장 최단 거리가 짧은 노드를 선택) x 반복 
	 */

	public static final int INF = (int) 1e9 ;  // 무한 (10억) 
	
	// 노드갯수, 간선갯수, 시작노드번호 
	public static int n , m , start ; 
	// 그래프 ; 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열 
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>() ; 
	// 방문 여부 배열 
	public static boolean[] visited = new boolean[100001] ; 
	// 최단 거리 테이블 (계속 갱신됨) 
	public static int[] d = new int[100001] ; 
	
	// 방문하지 않는 노드 중, 가장 최단거리가 짧은 노드의 번호를 반환 - O(V) 
	public static int getSmallestNode() { 
		int min_value = INF; 
		int index = 0 ; // 가장 최단거리가 짧은 노드(인덱스) 
		
		for(int i = 1 ; i <= n ; i++ ) {
			if(d[i] < min_value && !visited[i]) {
				min_value = d[i]; 
				index = i ; 
			}
		}
		return index ; 
	} // getSmallestNode

	// 최단 경로 구하기 (전체 과정) 
	public static void dijkstra(int start) {
		// 시작 노드에 대해서 초기화 
		d[start] = 0 ; 
		visited[start] = true; 	
		// 시작 노드에 인접한 노드들 최단 거리 갱신  
		for(int j = 0 ; j < graph.get(start).size() ; j++) { 
			d[graph.get(start).get(j).getIndex()] 
					= graph.get(start).get(j).getDistance() ; 
		}
		for(int i = 0 ; i < n-1 ; i++) {
			int now = getSmallestNode(); // 최단거리가 가장 짧은 노드를 꺼내서 
			visited[now] = true ; // 방문 처리 
			
			// 현재 노드와 연결된 다른 노드를 확인 
			for(int j = 0 ; j <graph.get(now).size() ; j++) {
				int cost = d[now] // 현재 노드까지의 최단 거리 
						+ graph.get(now).get(j).getDistance(); // 현재 노드에서 해당 노드까지의 거리
				if(cost < d[graph.get(now).get(j).getDistance()]) {
					// 현재 노드를 거치는게 기존 최단 거리보다 더 짧다면
					d[graph.get(now).get(j).getIndex()] = cost ; // 최단거리 갱신
				}
			}
			
		}	
	}
	
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
