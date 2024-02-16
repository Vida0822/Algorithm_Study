package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {
	public static final int INF = (int)1e9 ; 
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<>() ; // 그래프
	public static int[] d = new int[30000] ;  // 큰데이터 -> 다익스트라 필요 
	public static PriorityQueue<Node> pq = new PriorityQueue<>(); 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
	
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ; 
		int c=  sc.nextInt() ; 
		
		// part 1.그래프 만들기 
        for (int i = 0; i <= n; i++) { 
        	// 전체노드 (실제 데이터는 1~n에 담김) - '노드의' Index를 ArrayList, d의 포인터로 사용하기 때문 
            graph.add(new ArrayList<Node>());
        }
		for(int i = 0 ; i < m ; i++) { // 각 노드별 인접한 노드 정보 
			int x = sc.nextInt() ; 
			int y = sc.nextInt() ; 
			int z = sc.nextInt() ; 
			graph.get(x).add(new Node(y,z)) ; // x번 노드에서 y번 노드로 가는 비용이 z
		}
		Arrays.fill(d, INF) ; 
		
		
		// part 2.c에서 갈수있는 모든노드로의 최단거리 구하기 (d배열 채우기) 
		dikstra(c) ; 
		
		
		// part 3. 출력 
		int count = 0 ;
		int max = 0 ; 
		for(int i = 1 ; i <= n ; i++) {
			if(d[i] < INF) {
				count ++ ; 
				max = Math.max(max, d[i]) ; 
			}
		}
		System.out.println(count-1+" "+max); // 시작 노드 제외
	}
	
	
	public static void dikstra(int start) {
		pq.add(new Node(start, 0)) ; 
		d[start] = 0 ; 
	
		while(!pq.isEmpty()) {
			Node node = pq.poll() ; 
			int now = node.getIndex() ; // 현재 노드까지 인덱스 가져오기
			int dist = node.getDistance() ; // 현재 노드까지의 거리
	
			if( d[now] < dist) // 이미 검사한 노드일 때 
				continue ; 
		
			for(Node nextNode : graph.get(now) ) { // 인접 노드 검사 
				int cost = dist + nextNode.getDistance() ; // 현재 노드를 거쳐가는 거리 계산 
				if(cost < d[nextNode.getIndex()]) { 
					d[nextNode.getIndex()] = cost  ; 
					pq.add(new Node(nextNode.getIndex(), cost)) ; 
				}
			}
		} // while 
	} // dikstra
} // class 
