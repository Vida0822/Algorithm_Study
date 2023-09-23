package dfs;

import java.util.ArrayList;

/**
 * @author HEEMIN
 * @date 2023. 9. 23.-오후 8:28:58
 *	@subject dfs 
 * @content  인접 리트스(연결 리스트)로 ! 

 */
public class InList {
	
	public static final int VERTICLES_NUM = 7 ; 
	public static final int EDGES_NUM = 6 ; 

	public static ArrayList<Integer>[]  graph = new ArrayList[VERTICLES_NUM + 1] ;
	// String[] --> String 배열 : 배열의 각 요소가 String  /  ArrayList[] --> ArrayList 배열 : 배열의 각 요소가 List  
	public static boolean[] visited = new boolean[VERTICLES_NUM + 1] ; 
	
	// part 2. dfs 수행   
	/* 
	 	ArrayList[] 의 요소 : dfs 탐색 시작점 
	 	 --> 재귀함수로 돌음  (인접한 노드로 dfs 넘어가는건 순차적이지 않으니까)
	  	ArrayList[] 의 요소인 ArrayList의 각 요소 : 탐색할 도착점 
	  	  --> for문으로 돌음 (인접한 노드 도는건 순차적이니까 - 그 과정에서 '인접 노드의' dfs 들어갔다 빠져나오는 것)  
	 */
	
	// dfs 탐색 시작점 'vertex'--> 재귀함수 인수로 넘겨줌/넘어옴
	public static void DFS(int vertex) {
	
		// List 배열의 index ==  dfs 탐색 시작점  vertex 
		// 		ㄴ dfs 지점의 ArrayList 'graph[vertex]' 하나씩 돌면서 검사  : size()
		for (int i = 0; i < graph[vertex].size(); i++) {
	
			// 해당 List의 각 요소 : 인접한 노드들 
			int currV = graph[vertex].get(i) ; 
			
			// visited 배열 사용법은 동일 
			if(!visited[currV]) {
				
				// 방문 안한 노드면 기능 실행 후 visited 값 바꾸기 
				System.out.println(currV); 
				visited[currV] = true ; 
				
				// 그 노드 아래값들 먼저 검사 후 빠져나옴 
				DFS(currV) ;  
			} // if 	
		}// for 
	} // DFS 
	
	// part 1. 연결 리스트 만들기  
	public static void main(String[] args) {
		
		// 1. 노드 개수만큼의 크기를 가진 List 배열 생성 : 각 노드 == dfs 시작점 == 배열의 index   
		for (int i = 1; i <= VERTICLES_NUM ; i++) {
			graph[i] = new ArrayList<Integer>() ; 
		} // for
		
		// 2. 문제에 나타난 그래프 모양 보고 시작점들과 끝점 일치시켜서 각각 배열로 표현 
		int[] startPoints = new int[] {1,1,1,2,4,6} ; 
		int[] endPoints = new int[] {2,3,4,5,6,7} ; 
		
		// 3. 반복문 돌면서 시작점(배열 index)의 ArrayList에 도착점을 요소로 넣기 
		// --> 각 배열 요소(ArrayList)엔 인접한 노드값만 담김 ( index 3 --> 1, 2 )  
		for (int i = 0; i < EDGES_NUM ; i++) {
			int start = startPoints[i] ; 
			int end = endPoints[i] ; 
			
			graph[start].add(end) ; 
			
		// 4. 양방향 그래프이므로 대칭시켜주기 : index 1 --> 3 인접 
			graph[end].add(start) ; 
		} // for 
		
		// 5. 탐색 시작하기  : dfs 메서드 호출 
		int rootVertex = 1 ;  // 최초로 dfs 탐색 시작할 노드값 (문제에 제시 또는 가장 작은 값부터 시작) 
		System.out.println(rootVertex);  // 기능 실행 (출력) 
		visited[rootVertex] = true;  // 해당 노드는 탐색(방문)한 거니까 배열값 --> true 
		DFS(rootVertex); // 인접(아래) 노드 탐색 시작 : 
	
	} // main 
} // class 
