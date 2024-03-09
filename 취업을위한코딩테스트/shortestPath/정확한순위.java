package shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class 정확한순위 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ;

		// 1. 방향 그래프로 간주 
		// 2. 한 노드에서 다른 노드 각각으로 올 수 있는, 
		// 	또는 갈 수 있는 경로가 다른 노드들 모두에 존재한다면, 해당 학생은 순위를 알 수 있다 

		int[][] graph = new int[n+1][n+1] ;

		// 그래프 만들기 
		for(int i = 1 ; i <= n ; i++) {
			Arrays.fill(graph, 100000);
		}
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt() ; 
			int b = sc.nextInt() ; 
			graph[a][b] = 1 ; // 경로 존재 
		}

		
		// 알고리즘 수행 (점화식) 
		for(int k = 1 ; k <= n ; k++) { 
			for(int i = 1 ; i <= n ; i++) { 
				for(int j = 1 ; j <= n ; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]) ; 
				}
			}
		}

		// answer 도출 
		int answer = 0 ;
		for(int i = 1 ; i <= n ; i++) {
			int count = 0 ;
			for(int j = 1 ; j <= n ; j++) {
				if(graph[i][j] != 100000 || graph[j][i] != 100000) 
					count ++ ; 
			}
			if(count == n) {
				answer++ ; 
			}
		}
		System.out.println(answer);
	}
}
