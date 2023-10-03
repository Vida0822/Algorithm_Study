package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 10. 3.-오전 11:48:37
 *	@subject 뱀 피해서 갈수 있는 가장 빠른 경로 
 * @content bfs 
n * m grid 
격자 : 방문 격자, 답 격자 , 뱀 격자 

 */
public class ShortestEscapeRoute {
	
	// 필드 
	public static final int MAX_N = 100 ; 
	public static int n, m ;
	
	public static int[][] visited = new int[MAX_N][MAX_N] ; 
	public static int[][] snakes = new int[MAX_N][MAX_N] ; 
	public static int[][] steps = new int[MAX_N][MAX_N] ; 
	
	public static Queue<Pair> q = new LinkedList<Pair>() ; 

	// 메서드 
	private static boolean canGo(int newX, int newY) {		
	
		if(!(0<= newX && newX < n && 0<= newY && newY < m) ) {			
			return false;
		}
		if(visited[newX][newY] == 1 || snakes[newX][newY] == 0) {
			return false ; 
		}
		return true ; 
	}  // canGo
	
	private static void bfs() {
		
		int dx[] = {1, -1, 0, 0} ; 
		int dy[] = {0, 0, 1, -1} ;  // 동서남북 
		
		while(!q.isEmpty()){
			Pair rootVertex = q.poll() ; 
			
			for (int i = 0; i < 4; i++) { // 4번 이동해야하니까 0 , 1 , 2 ,3 (배열 index 범위 지정 넘 어렵다 ㅠㅠ ) 
				
				int newX = rootVertex.x + dx[i]; 
				int newY = rootVertex.y + dy[i]; 
				
				if(canGo(newX, newY)) {
					visited[newX][newY] = 1 ; 
					steps[newX][newY] =steps[rootVertex.x][rootVertex.y] + 1 ;
					q.add(new Pair(newX, newY)) ; 
				} // if 
			} // for 
		} // while 
	} // bfs 
	

	public static class Pair{
		int x , y ;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		} 
	} // pair 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		m= sc.nextInt() ; 

		// part 1. 뱀 격자 만들기 (이동 격자) 
		for (int i = 0; i < n; i++) { // n = 99 
			for (int j = 0; j < m; j++) { // m=  99 
				snakes[i][j] = sc.nextInt() ;
			}
		} // for 
		
		// part 2 . 탐색 시작 
		visited[0][0] = 1 ; 
//		steps[0][0] = 1 ;
		/* '거리'니까, 이동 횟수를 구하는 것 ! 첫번째 좌표에서 '출발'이니까 해당 좌표에서 한칸 이동할때 거리는 '1' 
		 * --> 그 노드까지의 '거리'를 노드값으로 적어줘야하므로 첫번째 노드는 0 , 그 옆의 노드는 1  
			--> 첫번째 좌표의 노드에 적히는 최단거리는 0 ! 
		 */
		steps[0][0] = 0 ; 
		q.add(new Pair(0,0)) ; // 이걸 안해주니 애초에 q에 값이 없어 while문 실행 x (탐색 실행조차 못함)  
 		bfs() ; 
		
		// part 3. 출력 
		/*
		 * for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) {
		 * System.out.print(steps[i][j]); } System.out.println(); } // for
		 */		
		System.out.println(steps[n-1][m-1]==0? -1 : steps[n-1][m-1] );
	} // main 


} // class 
