package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 10. 2.-오후 4:35:27
 *	@subject 뱀피하기 격자문제 
 * @content 


 */
public class SnakeEscape {

	public static final int MAX_NUM = 100 ; 
	public static int n, m ; 
	public static int[][] visited = new int[MAX_NUM][MAX_NUM] ; 
	public static int[][] grid = new int[MAX_NUM][MAX_NUM] ; 

	public static Queue<Pair> q = new LinkedList<Pair>() ; 

	
	
	
	public static boolean inRange(int newX, int newY) {
		
		return 0 <= newX && newX < n && 0 <= newY && newY < m  ; 
	 
	} // inRange 

	
	
	private static boolean canGo(int newX, int newY) {
		
		if(!inRange(newX, newY) ) {
			// 격자 범위 밖을 벗어남 
			return false ;
		}
		if(visited[newX][newY] == 1 || grid[newX][newY] == 0) {
			// 뱀이 있음 
			return false ;
		}
		return true;
	} // canGo




	public static void bfs() {

		int[] dx = {1, -1, 0, 0} ; 
		int[] dy = {0, 0, -1, 1} ;  // 동서남북 

		while (!q.isEmpty()) {

			// 탐색 시작위치 : queue값의 맨앞 
			Pair rootVertex = q.poll() ;  // 0,0 

			// 탐색 대상 : 각각 상하좌우 좌표값 
			for (int i = 0; i <= 3; i++) {

				int newX = rootVertex.x + dx[i] ; 
				int newY = rootVertex.y + dy[i] ; 


				if( canGo(newX, newY)) {
					visited[newX][newY] = 1 ;
					q.add(new Pair(newX, newY)) ; 
				} // if 	
			} //for 
			
		} // while
	} // bfs  


	public static class Pair{
		public int x ;
		public int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		} 		
	} // Pair 

	public static void main(String[] args) {

		// part 1. 뱀 격자 만들기 
		Scanner sc = new Scanner(System.in) ; 

		n = sc.nextInt() ; 
		m = sc.nextInt() ; 

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt() ; 
			} 
		} // for 

		// part 2. 탐색 시작 
		if(grid[0][0] == 1) {
			visited[0][0] = 1 ; 
			q.add(new Pair(0, 0) ) ; 
			bfs() ; 
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j]);
			} 
			System.out.println();
		} // for 

	} // main 



} // class
