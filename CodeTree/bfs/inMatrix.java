package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HEEMIN
 * @date 2023. 10. 1.-오후 12:32:41
 *	@subject bfs : 재귀함수 없이 queue라는 자료구조를 이용 
 * @content  인접 행렬로 표현한 그래프에서 bfs 

 */
public class inMatrix {
	
	public static final int VERTICES_NUM = 7 ;  // node 수 
 	public static final int EDGES_NUM = 7 ;  // edge 수 
 	
	// 그래프를 행렬로 표현 
	public static int[][] graph = new int[VERTICES_NUM+1][VERTICES_NUM+1] ;  // 연결여부를 나타내는 인접행렬 
	public static boolean[] visited = new boolean[VERTICES_NUM+1] ;  // 각 노드의 방문 여부를 표시하는 배열 
	public static Queue<Integer> q = new LinkedList<Integer>() ;  // 인접 노드 자체를 담을 queue
	
	
 	// part 3. 인접 노드들 수평 탐색하기 
	public static void BFS() {
		
		while(!q.isEmpty()) { // queue 안비어있으면 
			int currV = q.poll();  // queue에 있던값 빼서 : 맨 앞에 있는 값 <-> 맨 처음 담은 값 <-> 검사한 위치 
			
			for (int nextV = 1; nextV <= VERTICES_NUM;  nextV++) {
				
				if(graph[currV][nextV] == 1 && !visited[nextV]) {
					// 그 검사완료 위치에서 다른 노드들 하나씩 순회하면서 연결되어있고, 그 노드를 방문 안했으면 
					System.out.println(nextV); // 기능 수행 
					visited[nextV] = true ;  // 해당 노드 방문 체크 
					q.add(nextV) ; // queue에 추가 (다음 검색 노드에 추가) : 숫자가 순차적으로 올라가므로 수평 인접 값들 순서로 담기고, 그 순서로 검사 
				} // if 	
			} // for 
			
			// queue 안비어있으면 다시 while문 수행 
			
		} // while 
	} // BFS


	public static void main(String[] args) {
		
		// part 1. 인접 행렬 만들기 
		int[] startPoints =  new int[] {1, 1, 1, 2, 4, 6} ;
		int[] endPoints = new int[] {2, 3, 4, 5, 6, 7} ; 
		// 연결된 애들끼리 짝지어서 돌릴거임 <-> 연결되있는건 이미 기정사실 (확인 필요 ㅌ ) 
		
		for (int i = 0; i < EDGES_NUM; i++) {
			int start = startPoints[i] ; 
			int end = endPoints[i] ; 
			
			graph[start][end] = 1 ;
			graph[end][start] = 1 ;			 
		}  // for 
		
		// part 2. 탐색 시작하기 
		int rootVertext = 1 ; 
		System.out.println(rootVertext); // 탐색 시작위치 (& 기능) 
		visited[rootVertext] = true ; // 방문 완료 
		q.add(rootVertext) ;   // 인접노드 (자기자신 포함) 목록에 추가 
		BFS() ; 
	
	} // main 
} // class 
