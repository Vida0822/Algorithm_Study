package shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ; 

		int[][] graph = new int[n+1][n+1] ; 
		// int[][] graph = new int[n+1][n+1] ; 
		// --> graph 배열을 사용하지 않고 graph를 그대로 변형시켜야하는 이유 
		// : 한번 더 짧은 거리로 갱신된 경로는 그 이전의 경로값을 사용할 일이 없다. (그 뒤의 최단경로와 현재의 짧아진 경로를 비교해 갱신하는 거므로 ) 

		// 그래프 만들기 
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt() ; 
			int b = sc.nextInt() ; 
			int c = sc.nextInt() ;

			if(c < graph[a][b]) 
				graph[a][b] = c ; 
		}

		// graph 테이블 초기화 
		for(int i = 1 ; i <= n ; i++) {
			Arrays.fill(graph[i], 100001);
		}

		// 점화식 수행
		for(int k = 1 ; k <= n ; k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]); 
				}
			}
		}

		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				System.out.print(graph[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
