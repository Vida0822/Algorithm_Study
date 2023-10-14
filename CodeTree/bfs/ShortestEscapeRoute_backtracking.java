package bfs;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 10. 3.-오전 11:48:37
 *	@subject 뱀 피해서 갈수 있는 가장 빠른 경로 
 * @content  dfs  & backtracking


 */
public class ShortestEscapeRoute_backtracking {

	// 필드 
	public static final int MAX_N = 100 ; 
	public static int n, m ;

	public static int[][] visited = new int[MAX_N][MAX_N] ; 
	public static int[][] snakes = new int[MAX_N][MAX_N] ; 

	public static int ans = Integer.MAX_VALUE ; 

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

	public static void backTracking(int x , int y , int cnt) {

		// dfs' version : 모든 경로를 재귀함수로 탐색하며 각 경로의 최단 경로를 갱신 
		/*
		if(x == n-1 && y == m-1 ) {
			ans = Math.min(ans, cnt) ;   
			return ; 
		} // if 
		*/
		
		// backtracking  (가지치기) ' version 
		// 만약 해당 노드까지의 거리가 갱신해둔 최단 경로를 넘으면 탐색 중지 
		if(cnt >= ans) {			
			return ;  
		}
		// 끝까지 갔으면 최단 경로를 해당 경로의 거리수로 갱신 
		if(x == n-1 && y == m-1 ) {
			ans = cnt ;  // 여러 경로들을 재귀함수로 탐색하며 각 경로의 최단 경로를 갱신 
			return ; 
		} // if 

		int dx[] = {1, -1, 0, 0} ; 
		int dy[] = {0, 0, 1, -1} ;  // 동서남북 

		for (int i = 0; i < 4; i++) { // 4번 이동해야하니까 0 , 1 , 2 ,3 (배열 index 범위 지정 넘 어렵다 ㅠㅠ ) 

			int newX = x + dx[i]; 
			int newY = y + dy[i]; 

			if(canGo(newX, newY)) {
				visited[newX][newY] = 1 ;
				backTracking(newX, newY, cnt+1) ; 
				visited[newX][newY] = 0 ;
			} // if 
		} // for 
	} // backTracking 


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
		backTracking(0, 0, 0);

		// part 3. 출력 
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans );
	} // main 
} // class 
