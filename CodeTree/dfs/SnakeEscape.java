package dfs;

import java.util.Scanner;

public class SnakeEscape {

	// part 1. 격자 준비
	public static final int MAX_N = 100 ; 
	public static int n , m  ; 

	public static int [][] snakes = new int[MAX_N][MAX_N] ; 
	public static int [][] visited = new int[MAX_N][MAX_N] ; 

	// part 2 . dfs 시작  
	private static void dfs(int x, int y) {

		int[] dx = {1, 0} ; 
		int[] dy = {0, 1} ; 

		for (int i = 0; i < 2; i++) {
		
			int newX = x + dx[i] ; 
			int newY = y + dy[i] ; 

			if(canGo(newX, newY)){
				visited[newX][newY] = 1 ; 
				dfs(newX, newY) ; 					
			} // if 
		} // for 
	} // dfs 

	// part 3. 조건 검사 --> 기능 수행 
	private static boolean canGo(int x, int y) {
		if(x>= n || y >= m)
			return false ; 
		if(visited[x][y] == 1 || snakes[x][y] == 0)
			return false ; 
		return true;
	} // canGo

	public static void main(String[] args) {
		// 뱀 격자 만들기 
		Scanner sc = new Scanner(System.in) ; 

		n = sc.nextInt() ; 
		m = sc.nextInt() ;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				snakes[i][j] = sc.nextInt(); 
			}	
		} // for 

		visited[0][0] = 1 ; 
		dfs(0,0)  ; 
		
		/*
		if(visited[n-1][m-1] == 1) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		*/
		System.out.println(visited[n-1][m-1]); 
		// 해당 값 자체가 1 또는 0이기 때문에 굳이 분기를 줄 필요없이 그대로 출력하면 된다! 
	} // main 
} // class
