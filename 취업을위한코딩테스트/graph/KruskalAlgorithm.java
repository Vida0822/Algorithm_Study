package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	private int distance ; 
	private int nodeA; 
	private int nodeB ; 
	
	public Edge(int distance, int nodeA, int nodeB) {
		this.distance = distance ; 
		this.nodeA = nodeA; 
		this.nodeB = nodeB; 
	}
	
	public int getDistance() {
		return this.distance ; 
	}
	public int getNodeA() {
		return this.nodeA ;
	}
	public int getNodeB() {
		return this.nodeB ; 
	}
	
	@Override 
	public int compareTo(Edge other) {
		if(this.distance < other.distance) {
			return -1 ;
		}
		return 1 ; 
	}
}

public class KruskalAlgorithm {
	
	public static int v, e ; 
	public static int[] parent = new int[100001] ; 
	public static ArrayList<Edge> edges = new ArrayList<>() ; 
	public static int result = 0 ; 
	
	public static int find(int x) {
		if(x == parent[x]) return x ; // 루트노드일때만 여기 걸림 
		return parent[x]  = find(parent[x]) ; 
	}
	
	public static void union(int a, int b) {
		a = find(a); 
		b = find(b) ; 
		if(a < b) parent[b] = a; 
		else parent[a] = b ;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
        
        for(int i = 0 ; i < e ; i++) {
        	int a = sc.nextInt() ; 
        	int b = sc.nextInt() ; 
        	int cost = sc.nextInt() ;
        	edges.add(new Edge(cost, a, b)); 
        }
        
        Collections.sort(edges); // O(E log E) 
        
        // 간선 개수만큼 확인하며 
        for(int i = 0 ; i < edges.size() ; i++) {
        	int cost = edges.get(i).getDistance() ; 
        	int a = edges.get(i).getNodeA() ; 
        	int b = edges.get(i).getNodeB() ; 
        	
        	if(find(a) != find(b)) {
        		union(a,b) ; 
        		result += cost ; 	
        	}
        }
        System.out.println(result);
	}
}
