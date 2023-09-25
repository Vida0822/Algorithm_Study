package dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 25.-오전 7:03:49
 *	@subject dfs 
 * @content  양방향 그래프에서의 dfs (인접 리스트로) 
 * 
 */
public class BidirectedGraph_List {
	
	// part 1. 배열 만들기 
	public static final int MAX_N = 1000 ; 
	public static ArrayList<Integer>[] graph = new ArrayList[MAX_N+1] ; 
	// 배열을 index 값 활용위해 1부터 채우니까 최대값 1000개의 노드를 받는 경우는 크기 1001의 배열을 만들어야함 
 	public static boolean[] visited = new boolean[MAX_N+1]  ; 
 
	public static int m, n ; 
	public static int count =0 ; 
	
	
	// part 3. dfs 아래노드 탐색하기 
	private static void dfs(int vertex) {
		
		for (int i = 0; i < graph[vertex].size(); i++) {
			
				int currN = graph[vertex].get(i)  ; 
			
				if(!visited[currN]) {
					
					count++ ; 
					visited[currN] = true ;
					dfs(currN) ; 		
					
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
		
		for (int i = 1 ; i <= n; i++) {
			graph[i] = new ArrayList<Integer>(); 
		}
		
		for (int i = 1; i <= m; i++) {
					
			x = sc.nextInt(); 
			y = sc.nextInt(); 		
			
			graph[x].add(y) ; 
			graph[y].add(x) ; 
			
		} // for 
		
		visited[1] = true ; 
		dfs(1) ; 
		
		System.out.println(count);
		
		
	
	} // main



} // class
