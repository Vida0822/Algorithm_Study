package dfs_bfs;

import java.util.Scanner;

public class 음료수얼려먹기 {
	
	public static int[][] graph = new int[1000][1000] ; 
	public static int n , m ; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		// 그래프 만들기 
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m ; j++) {
				graph[i][j] = sc.nextInt() ; 
			}
		}
				
		int answer = 0 ; 
		for(int i = 0 ; i < n ; i++) { 
			for(int j = 0 ; j < m ; j++) {
				if(dfs(i, j))  // 검사하는 노드가 0이면 아이스크림++ & 그 칸과 연결된 다른 칸들도 다 포함(방문 후 비연결 표시) 
					answer++ ;  // 방문한 배열, 비연결 노드면 false가 나와서 증가 x
			}
		}
		System.out.println(answer);
	} // main
	
	static boolean dfs(int x, int y) { // 같은 클래스내의 메서드를 호출하더라도 인스턴스를 생성하거나, 정적 메서드여야한다. 
		/*
		 * dfs 메서드 구조 중요 
		 * 1) 종료조건 
		 * 2) 방문 표시 
		 * 3) 기능
		 * 4)  
		 */
		
		// 종료조건
		if(x <= -1 || x >= n || y <= -1 || y >= m)
			return false; 
		
		if(graph[x][y] == 1){  // 방문했거나 연결되어있지 않음 
			return false ; 

			/*
			 * 방문 배열을 따로 사용하지 않고 그래프 값에 1을 그대로 표시 
			 * => 만약 그래프가 어떤 값 요소를 가지지 않고 단순히 1(갈수 없음),0(갈수있음) 만 표시되어있다면 방문한 노드를 '갈수없는' 값으로 바꾸어 다시 방문하지 않도록 처리 
			 */
			
			
		}else { // 연결되어있음 
			
		// 방문 표시 	
			graph[x][y] = 1; 
				
		// 인접 노드 스택에 쌓기 (재귀 호출하기) 
			dfs(x-1, y) ; 
			dfs(x+1, y) ; 
			dfs(x, y-1) ; 
			dfs(x, y+1) ; 
			
			return true ; 
		}
	} // dfs
} // class 
