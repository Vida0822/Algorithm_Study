package shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
	public static final int INF = (int) 1e9 ; 
	public static int n, m ; 
	public static int[][] graph = new int[501][501] ; // 행렬형태 그래프
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		// 초기 조건 : 그래프 생성 (dp 초기조건)    
		for(int i = 0 ; i < 501; i++) {
			Arrays.fill(graph[i], INF); // 무한으로 채우고 
		}
		
		for(int a = 1 ; a <= n ; a++) {
			for(int b = 1; b <= n ; b++) {
				if(a==b) graph[a][b] = 0;  // 자기자신으로는 갈 수 X 
			}
		}
		
		for(int i = 0 ; i < m ; i++) { // 갈수 있는 곳은 거리 입력받음
			int a = sc.nextInt() ; 
			int b = sc.nextInt() ; 
			int c = sc.nextInt() ;
			graph[a][b] = c; 
		}
		
		// 점화식 (알고리즘 수행)
		for(int k = 1 ; k <= n ; k++) { // 각각의 노드에 대해 
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]) ; 
				}
			}
		}		
	} // main 
} // class 
