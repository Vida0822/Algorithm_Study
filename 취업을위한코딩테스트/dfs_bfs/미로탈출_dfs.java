package dfs_bfs;

import java.util.Scanner;

/*
 * dfs by Stack 
 * : 재귀함수를 이용해 구현 
 */
public class 미로탈출_dfs {
	
	static int n , m ; 
	static int[][] visited = new int[1000][1000] ; 
	static int[][] graph = new int[1000][1000] ; 
	static int answer = 10000 ;
	static int[] dx = {-1 , 1 , 0 , 0 }; 
	static int[] dy = {0 , 0 , -1 , 1 }; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n  = sc.nextInt() ; 
		m = sc.nextInt(); 
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				graph[i][j] = sc.nextInt();  
			}
		}
		dfs(1, 1, 1) ; 
		System.out.println(answer) ;

	} // main 
	
	
	static void dfs(int x, int y , int count){
		
		// 종료조건 
		if(x == n && y == m) {
			answer = Math.min(answer, count) ;
			return ; 
		}
		if(x < 1 || x > n || y < 1 || y > m )
			return ; 
		
		if(graph[x][y] == 0) 
			return ; 
		else {			
			// 방문 처리 
			graph[x][y] = 0 ; 
			
			// 기능 (경로 수 증가) 
			count++ ; 
			
			// 인접 노드 쌓기 
			for(int i = 0 ; i < 4 ; i++ ) {
				int nx = x + dx[i] ;
				int ny = y + dy[i] ;
				
				dfs(nx, ny, count) ; 
			}
		}
	}
} // class 
