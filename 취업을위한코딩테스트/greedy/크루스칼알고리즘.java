package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 크루스칼알고리즘 {
	public static void union(int[] parent, int a, int b) {
		int a_parent = find(parent, a) ; 
		int b_parent = find(parent, b) ;
		
		if(a_parent < b_parent)
			parent[b_parent] = a_parent ; 
		else
			parent[a_parent] = b_parent ; 
	} // union 
	
	public static int find(int[] parent , int i) {
		if (parent[i] == i) 
            return i;
        return parent[i] = find(parent, parent[i]);
       
	} // find 
	
	public static void main(String[] args) {
		int[][] graph = {{1, 2, 6}, {1, 3 , 3}, {1, 4, 1}, {2, 5, 4}, {3, 4, 2}, {3, 5, 5} , {4, 5, 7}} ; 
		int[] parent = new int[6] ; 
		int total = 0; // 최소 신장 트리의 가중치 총합
		
		// 초기상태
		for(int i = 0 ; i < parent.length ; i++) {
			parent[i] = i ; 
		}
		
		// 가중치 기준으로 정렬 
		Arrays.sort(graph, new Comparator<int[]>() { // int 배열을 정렬하는 기준을 넣어줌
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2] ;  // o1이 더 작으면 음수 --> o1이 앞선다 (오름차순) 
			}
		});
		
		// 최소 신장 비용 구하기 
		for(int i = 0 ; i < graph.length;  i++) {
			if(find(parent, graph[i][0]) != find(parent, graph[i][1])) {
				total += graph[i][2] ; 
				union(parent, graph[i][0], graph[i][1]) ; 
			}
		}
		System.out.println("최소 비용 신장 트리 가중치의 합은" + total);
	} // main  
} // class 
