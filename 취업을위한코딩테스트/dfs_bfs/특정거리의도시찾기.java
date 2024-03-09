package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 특정거리의도시찾기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		int n = sc.nextInt() ; 
		int m = sc.nextInt() ;
		int k = sc.nextInt() ; 
		int x = sc.nextInt() ;
		
		// 그래프 만들기 
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ;
		for(int i = 0 ; i <= n ; i++) {
			graph.add(new ArrayList<>()) ; 
		}
		
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt() ;
			int b = sc.nextInt() ; 
			graph.get(a).add(b) ; 
		}
		
		// x로부터 최단거리 갱신 
		int[] dp = new int[n+1] ; 
		Arrays.fill(dp, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x) ; 
		dp[x] = 0 ;
		
		while(!q.isEmpty()) {
			int cur = q.poll() ; 
			for(int i = 0 ; i < graph.get(cur).size(); i++) {
				int next = graph.get(cur).get(i) ; 

				//if(dp[cur] + 1 < dp[next]) {
				if(dp[cur] == -1) { // 아직 방문하지 않은 도시라면
					dp[next] = dp[cur] + 1 ; // 최단 거리 갱신 
					q.offer(next); 
				}		
			}
		}
		
		// 답 출력
		for(int i = 1 ; i <= n ; i++) {
			if(k == dp[i])
				System.out.println(i);
		}
	}
}
