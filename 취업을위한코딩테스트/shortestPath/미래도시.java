package shortestPath;

import java.util.* ; 

public class 미래도시 {
	public static final int INF = (int)1e9 ; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt() ; // 회사(노드) 
		int m = sc.nextInt() ; // 다리(간선) 
		System.out.println("n:"+n);
		System.out.println("m:"+m);
		
		// N : 100 --> O(N^3) 괜찮
		int[][] graph = new int[101][101] ; 
        
        // part 1. 그래프 만들기 
		for(int i = 1 ; i <= n ; i++ ) {
			Arrays.fill(graph[i], INF );  // 아직 경로를 모름 
			graph[i][i] = 0 ;  // 갈 수 없음 
		}
		for(int i = 1 ; i <= m ; i++) {		
			int from = sc.nextInt();
			int to = sc.nextInt(); 
			graph[from][to] = 1 ; // 가중치 x : 갈수 있다, 없다 
			graph[to][from] = 1 ; // 양방향 그래프 
		} // for 
	
        // part 2. dp(점화식) : 모든 경로 구하기		
		for(int i = 1 ; i <= n ; i++) {
			for(int a = 1 ; a <= n ; a++) {
				for(int b = 1 ; b <= n ; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]) ;  
				}
			}
		} // for 
		
		// part 3. 특정 경로의 거리 추출
        int x = sc.nextInt() ; // 물건 판매 (나중) 
		int k = sc.nextInt() ; // 소개팅 (먼저)
		System.out.println((graph[1][k] + graph[k][x]) >= INF? -1 : graph[1][k] + graph[k][x] );
		// == INF인 경우 안됨 
	} // main 
} // class 

