package dfs;

/**
 * @author HEEMIN
 * @date 2023. 9. 23.-오후 7:28:16
 *	@subject DFS 
 * @content  '행렬'에서 탐색 

 */
public class InMatrix {
	
	public static final int VERTICES_NUM = 7 ;  // 노드개수 
	public static final int EDGES_NUM = 6 ;  
	
	public static int[][] graph = new int[VERTICES_NUM+1][VERTICES_NUM+1]; 
	// 노드개수 x 노드개수 2차원 배열 만듬 : 1열에 적힌 숫자들 (출발점) --> 1행에 적힌 숫자들 (도착점)  -- 서로서로 방문 but 인접한 것만 (1인것만) go 가능  
 	public static boolean[] visited = new boolean[VERTICES_NUM+1] ; 
	
 	
 	public static void DFS(int vertex) { 
 		// 1번 ~ 7번이 출발지점이 되어서 각각 dfs 수행해야함 --> vertex('꼭지점') : DFS 출발 지점  
 		
 		for (int currV = 1; currV <= VERTICES_NUM; currV++) { 
 			// 출발점 vertex에서 다른 노드 1번 ~ 7번으로의 탐색 수행해야함 (for문의 목적) --> currV : 도착 지점 
 			
 			if(graph[vertex][currV] == 1 && !visited[currV]) { 
 				// vertext에서 currV로 가는길이 열려있으면 <-> 두 노드가 인접해있으면  && currV를 방문 한적 없으면
 				
 				System.out.println(currV);  // currV 출력 (기능) 
 				visited[currV] = true;  // 해당 노드는 출력했으면 기능 완료 ! --> 방문여부 true로 설정해 다신 그 노드 탐색 안해게끔 함  
 				DFS(currV) ; // 아래 노드가 있는지 계속 탐색 <-> 재귀함수 호출 ('메서드의 첫부분으로 돌아간다')  
 									// 		--> 도착지검인 currV가 출발지점이 되어 DFS(for문) 수행  ** 
 			} // if 
		} // for 
 	} // DFS

 	/* 출발지점 1번 --> 7번 :재귀함수 
    							; 첫 출발점에서 인접한 점으로 이동해, 거기서 다시 dfs 수행하는거니까 순차적이지 않음
 								ex) 1번 노드 인접 : 4번 --> 4번부터 dfs 수행 => 1 --> 4 : 순차적이지 않잖아?  
 	 	도착지점 1번 --> 7번 : 반복문 
 								; 출발점에서 다른 노드로 방문탐색 하는 것 ! 인접한지 여부는 배열값 (1 or 0)으로 구분하니까 반복문에선 그냥 순차적으로 돌아주면 됨 
 								ex) 1번 노드 --> 2번 : 0 -> 탐색 x / 1번 --> 3번 : 0 -> 탐색 x /  1번 --> 4번 : 1 --> 탐색 o    
 	 */ 	
 	
	public static void main(String[] args) {
		
		// <배열로 그래프 표현하기> 
		// [main --> 만들어진 행렬(2차원 배열)에 '인접' 반영하기]  (main은 문제를 반영 , 메서드는 모든 인접행렬에서 dfs하는거에 해당 )  
		// 1. 문제 조건을 보고 출발점, 도착점 추출 --> 각각 배열로 만들기 
		// 2. 반복문 돌면서 출발점[i] --> 도착점[i] 인접여부 확인해 1 또는 0으로 배열 채우기 (행 : 출발점 , 열 : 도착점)  
		// 3. 양방향 그래프니까 대칭으로 만들기 	ex)  1 --> 3 갈수 있음 : ' (1,3) = 1 ' <->  3 --> 1 갈 수 있음 : ' (3,1) = 1 ' 
		// 4. 탐색 시작하기 : dfs 메서드 호출 

		// 1. 
		int[] startPoints = new int[] {1,1,1,2,4,6} ; 
		int[] endPoints = new int[] {2,3,4,5,6,7} ; 
		
		// 2. 
		for (int i = 0; i < EDGES_NUM; i++) {
			int start = startPoints[i] ; 
			int end = endPoints[i] ; 
			
			graph[start][end] = 1; 
			
			// 3. 
			graph[end][start] = 1; 
			
		} // for 
		
		// 4. 
		int rootVertex = 1;  // 최초로 dfs 수행할 출발점(vertex) 
		System.out.println(rootVertex);  // 기능 수행 
		visited[rootVertex] = true;  // 해당 노드는 방문 처리 
		DFS(rootVertex);  // dfs 시작  : 인접한 노드들 탐색 시작!  

	} // main 
} // class 
