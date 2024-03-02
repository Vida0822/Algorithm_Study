package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {
	
	// 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] indegree = new int[100001];
    
    // 리스트형 그래프 (각 노드로부터 연결된 노드들)
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
    
    // 위상 정렬 함수 
    public static void topologySort() {
    	ArrayList<Integer> result = new ArrayList<>(); 
    	Queue<Integer> q = new LinkedList<>(); 
    	
    	for(int i = 1 ; i <= v ; i++) {
    		if(indegree[i] == 0)
    			q.offer(i);
    	}
    	
    	while(!q.isEmpty()) { // 노드들 하나씩 확인 - O(V) 
    		int now = q.poll() ; 
    		result.add(now) ;
    		
    		// 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
    		for(int i = 0 ; i < graph.get(now).size() ; i++) { // 간선들 하나씩 확인 - O(E)
    			indegree[graph.get(now).get(i)] -= 1 ;
    			
    			if(indegree[graph.get(now).get(i)] == 0)
    				q.offer(graph.get(now).get(i)) ; 
    		}
    	}
    	for(int i = 0 ; i < result.size() ; i++) {
    		System.out.print(result.get(i)+ " ");
    	}
    }

	public static void main(String[] args) {
		
		// 그래프 만들기 
		Scanner sc = new Scanner(System.in) ; 
		v = sc.nextInt() ; 
		e = sc.nextInt() ; 
		
		for(int i = 0 ; i <= v ; i++) {
			graph.add(new ArrayList<Integer>()) ; 
		}
		
		for(int i = 0 ; i < e ; i++) {
			int a = sc.nextInt() ; 
			int b = sc.nextInt() ; 
			graph.get(a).add(b); // 정점 A에서 B로 이동 가능 
			indegree[b] += 1 ; // 진입 차수 1증가 	
		}
		topologySort() ; 
	}

}
