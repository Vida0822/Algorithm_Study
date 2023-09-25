package dfs;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 25.-오전 7:03:49
 *	@subject dfs 
 * @content  양방향 그래프에서의 dfs (인접 배열로) 
 * 
 */
public class BidirectedGraph_Matrix {
	
	// part 1. 배열 만들기 
	public static final int MAX_N = 1000 ; 
	public static int[][] graph = new int[MAX_N+1][MAX_N+1] ; 
	public static boolean[] visited = new boolean[MAX_N+1]  ; 
 
	public static int m, n ; 
	public static int count =0 ; 
	
	
	// part 3. dfs 아래노드 탐색하기 
	private static void dfs(int vertex) {
		
		for (int otherNodes = 1; otherNodes <= n; otherNodes++) {
			
			if(visited[otherNodes] != true &&graph[vertex][otherNodes] == 1) {
				count++ ; 
				visited[otherNodes] = true ;
				dfs(otherNodes) ; 		
			} // if
			
		} // for 
	} // dfs

	public static void main(String[] args) {
		
		// part 2. 인접배열 (2차원 배열) 채우기 
		Scanner sc = new Scanner(System.in) ; 
		
		int x, y ; 
		
		// 한줄로 출력? 
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		for (int i = 1; i <= m; i++) {
			x = sc.nextInt(); 
			y = sc.nextInt(); 		
			
			graph[x][y] = 1 ;
			
			graph[y][x] = 1 ;
		} // for 
		
		visited[1] = true ; 
		dfs(1) ; 
		
		System.out.println(count);
		
		
	
	} // main



} // class
