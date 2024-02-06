package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * bfs by queue 
 * : Queue 자료구조 이용 (Queue에서 계속 빼기)  
 */
public class 미로탈출_bfs {
	
    public static int n, m;
    public static int[][] graph = new int[201][201];
    
    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
	
    public static int bfs(int x , int y) {
    	Queue<Pair> q = new LinkedList<Pair>() ;
    	q.offer(new Pair(x, y)) ; 
    	
    	while(!q.isEmpty()) {
    		
    		// 큐의 첫번째 노드 가져오기 
    		Pair pair = q.poll() ; 
    		x = pair.x ; 
    		y = pair.y ; 
    		
    		for(int i = 0 ; i < 4 ; i++) {
    			int nx = x+dx[i] ; 
    			int ny = y+dy[i] ; 
    			
    			if(nx < 1 || nx > n || ny <1 || ny > m ) // 범위 벗어나면 
    				continue ; // 해당 좌표는 큐에 추가하지 않는다 (검사대상에 포함 x) 
    		
    			if(graph[nx][ny] == 0) // 괴물이 있으면 
    				continue ;  // 해당 좌표는 큐에 추가하지 않는다 
    			
    			if(graph[nx][ny]==1) { //해당 노드를 처음 방문하면 
    				
    				// 방문 표시 + 기능(최단거리 update) 
    				/*
    				 * bfs 라 가능 ! 
    				 	특정 좌표에서 바로 인접한 애들먼저 차례로 방문하기 때문에 해당 좌표의 특수값을 바로 그 인접노드들에 변형해서 반영할 수 있음
    				 */
    				graph[nx][ny] = graph[x][y]+1 ; // 현재 노드 + 1칸을 해당 노드의 최단 거리로 설정 
    	
    				
    				// 인접 노드 추가 
    				q.offer(new Pair(nx, ny)) ;
    			}// else{} : graph[nx][ny] > 1  - 방문한적이 있으면 
    		}
    	}
    	return graph[n][m] ; 
    }
    
	public static void main(String[] args) {
		
		// 1. 그래프 만들기 
		Scanner sc = new Scanner(System.in) ; 
		n  = sc.nextInt() ; 
		m = sc.nextInt(); 
		graph = new int[n+1][m+1] ; 
		
		for(int i = 1 ; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				graph[i][j] = sc.nextInt();  
			}
		}
		
		// 2. bfs 수행 
		System.out.println(bfs(1,1));
	}
}

class Pair{
	int x ; 
	int y ; 
	
	public Pair(int x , int y) {
		this.x = x ; 
		this.y = y ; 
	}
}
