package graph; 

import java.util.*; 
class Dist implements Comparable<Dist>{
    int start ;
    int end ; 
    int cost ;

    public Dist(int start, int end, int cost){
        this.start = start ; 
        this.end = end ; 
        this.cost = cost ; 
    }
    
    @Override
    public int compareTo(Dist other){
        return this.cost - other.cost ; 
    }
}

public class 행성터널{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ; 
        int n = sc.nextInt() ; 
        int[][] xyz = new int[n][4] ; 
        
        // 그래프 만들기 ** : 모든 행성은 연결 될 수 있다
        // 보통은 특정 출발 노드 -> 도착 노드 + 비용이 주어지는데 
        // 여기선 출발 노드의 위치, 도착 노드의 위치로 각 노드간의 비용을 내가 구해야한다 
        // 좌표 입력받기 
        for(int i = 0 ; i < n ; i++){
        	xyz[i][0] = i ; 
            xyz[i][1] = sc.nextInt() ; 
            xyz[i][2] = sc.nextInt() ; 
            xyz[i][3] = sc.nextInt() ; 
        }
        
        // 그래프 만들기 
        ArrayList<Dist> Dists = new ArrayList<Dist>(); 
        for(int i = 1 ; i <= 3 ; i++) {
        	int p = i ; 

        	Arrays.sort(xyz, (o1, o2) -> (o1[p] - o2[p]));
        	
        	for(int j = 0 ; j < n-1 ; j++) {
        		int p1 = xyz[j][0] ; 
        		int p2 = xyz[j+1][0] ; 
        		int cost = Math.abs( xyz[j][i] - xyz[j+1][i] ) ; 
        		
        		Dists.add(new Dist(p1,p2, cost)) ; 
        	}	
        }
        
        // 간선 정렬 
        Collections.sort(Dists) ; 
        
        // 테이블 만들기 
        int[] parent = new int[n] ; 
        for(int i = 0 ; i < n ; i++){
            parent[i] = i ; 
        }
        
        // 크루스칼 알고리즘 수행 
        int answer = 0 ; 
        for(int i = 0 ; i < Dists.size() ; i++){
            int start = Dists.get(i).start ; 
            int end = Dists.get(i).end ; 
            int cost = Dists.get(i).cost ; 
            
            if(find(parent, start) == find(parent, end))
                continue ; 
            
            union(parent , start, end); 
            answer += cost ; 
        }
        System.out.println(answer) ; 
     }
    
    public static int find(int[] parent, int x){
        if(parent[x] == x)
            return x ; 
        return parent[x] = find(parent, parent[x]) ; 
    }
    
    public static void union(int[] parent, int x, int y){
        int root_x = find(parent, x) ; 
        int root_y = find(parent, y) ; 
        
        if(root_x != root_y)
            parent[root_y] = root_x ; 
    }
    
}