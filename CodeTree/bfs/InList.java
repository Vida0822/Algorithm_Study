package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HEEMIN
 * @date 2023. 10. 1.-오후 1:19:14
 *	@subject bfs : 재귀함수 없이 queue라는 자료구조 이용 
 * @content  인접 리스트로 구현한 그래프에서 bfs  

 */
public class InList {
	
	public static final int VERTICES_NUM = 7 ;  // node 수 
 	public static final int EDGES_NUM = 7 ;  // edge 수 
 	
 	public static ArrayList<Integer>[] graph = new ArrayList[VERTICES_NUM+1] ; 
 	public static boolean[] visited = new boolean[VERTICES_NUM + 1];  
 	public static Queue<Integer> q = new LinkedList<Integer>() ;  // 검사를 아직 않은 인접 노드들을 담을 queue  

 	// part 4. 인접 노드들 수평 탐색하기 
 	public static void BFS() {
 		while(!q.isEmpty()) {
 			int currV = q.poll() ; 
 			
 			for (int i = 0; i < graph[currV].size(); i++) {
				int nextV = graph[currV].get(i) ; 
				
				if(!visited[nextV]) {
					System.out.println(nextV); 
					visited[nextV] = true ; 
					q.add(nextV) ; 
				} // if 
			} // for 		
 		} // while 
 	} // bfs 
 	
	public static void main(String[] args) {

		// part1. 노드 개수만큼 list 만들기 
		for (int i = 1; i < VERTICES_NUM; i++) {
			graph[i] = new ArrayList<Integer>(); 
		} // for 
		
		// part 2. 인접 노드들로 list 채우기 
		int[] startPoints = new int[] {1, 1, 1, 2, 4, 6} ; 
		int[] endPoints = new int[] {2, 3, 4, 5, 6, 7} ; 
		
		for (int i = 0; i < EDGES_NUM; i++) {
			int start = startPoints[i] ; 
			int end = endPoints[i] ; 
			
			graph[start].add(end) ; 
			graph[end].add(start) ; 
		}
		
		// part 3. 탐색 시작하기 
		int rootVertex = 1; 
		System.out.println(rootVertex);
		visited[rootVertex] = true ; 
		q.add(rootVertex) ; 
		BFS(); 

	} // main 
} // class 
