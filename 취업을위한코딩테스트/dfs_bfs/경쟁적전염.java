package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Virus implements Comparable<Virus>{
	int index;  
	int second ; 
	int x; 
	int y; 
	
	Virus(int index, int second, int x, int y){
		this.index = index ;
		this.second = second ; 
		this.x = x ; 
		this.y = y ; 
	}
	@Override 
	public int compareTo(Virus other) {
		return this.index - other.index ; 
	}
}

public class 경쟁적전염 {
	public static int n , k ; 
	public static int[][] graph = new int[200][200] ; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		k = sc.nextInt() ; 
		
		// 그래프 만들기 & 검사할 바이러스 삽입 
		ArrayList<Virus> viruses = new ArrayList<>() ; 
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				graph[i][j] = sc.nextInt(); 
	
				// 전염 시작점 바이러스들 모아놓고 (0초) 
				if(graph[i][j] != 0)
					viruses.add(new Virus(graph[i][j], 0 , i, j)); 
			}
		}
		Collections.sort(viruses) ; // 낮은 번호 바이러스부터 
		
		int s = sc.nextInt() ; 
		bfs(viruses,s) ; 

		int x = sc.nextInt() ; 
		int y = sc.nextInt() ; 
		System.out.println(graph[x-1][y-1]) ; 
	}
	
	public static void bfs(ArrayList<Virus> viruses, int s) {
		
		// 큐 만들기 (전염 시작 바이러스들 정렬)  : 1 , 2, 3
		Queue<Virus> q = new LinkedList<>() ; 
		for(int i = 0 ; i < viruses.size() ; i++) {
			q.offer(viruses.get(i)) ; 
		}
		
		while(!q.isEmpty()) { // 1 상하좌우 -> 2 상하좌우-> 3 상하좌우-> 1 -> 2 -> 3 -> ... 
			Virus virus = q.poll() ; 
			
			if(virus.second == s) 
				break ; 
			
			int[] dx = {-1, 1, 0, 0} ; 
			int[] dy = {0, 0, -1, 1} ;
			for(int i = 0 ; i < 4 ; i++) { // 1초마다 상하좌우로 증식 
				int nx = virus.x + dx[i] ; 
				int ny = virus.y + dy[i] ; 
				
				if(nx < 0 || nx >= n || ny < 0 || ny >=n)
					continue ; 
				if(graph[nx][ny] == 0) {
					graph[ny][ny] = virus.index; 
					q.offer(new Virus(virus.index, virus.second+1 , nx, ny)) ;
				}
			}
		}
	}
}
