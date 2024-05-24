package dfs_bfs;

import java.util.* ;
import bfs.SnakeEscape.Pair; 

public class 인구이동_2{
    
    public static int[][] A ; 
    public static boolean[][] visited ; 
    public static int N , L , R ; 
    
    public static void main(String[] args){
    	
        // input 
        Scanner sc = new Scanner(System.in) ; 
        N = sc.nextInt() ; 
        L = sc.nextInt() ; 
        R = sc.nextInt() ; 
    
        A = new int[N][N] ; 
        for(int i = 0 ; i < N ; i++){ // O(N^2)
            for(int j = 0 ; j < N ; j++){
                A[i][j] = sc.nextInt() ; 
            }
        }
    
        int answer = 0 ; 
        while(true){ // 인구 이동이 없을 때까지 
            visited = new boolean[N][N] ; 
            boolean flag = false ;
            
            for(int i = 0 ; i < N ; i++){ // O(N^2)
                for(int j = 0 ; j < N ; j++){
                    if(visited[i][j])
                        continue; 
                    
                    visited[i][j] = true ; 
                    if(openWalls(new Pair(i,j)))
                        flag = true ; 
                }
            } // for
            if(!flag)
                break ; 
            
            answer++ ; 
        } // while 
        
        System.out.println(answer) ;
    } // main 
    
    public static boolean openWalls(Pair start){
        
        Queue<Pair> q = new LinkedList<>() ; 
        q.offer(start) ; 
        
        ArrayList<Pair> nations = new ArrayList<>() ; 
        nations.add(start) ; 
        int total = A[start.x][start.y] ;
        
        int[] dx = {-1, 1, 0, 0} ; 
        int[] dy = {0, 0, -1, 1} ;        
        while(!q.isEmpty()){
            Pair p = q.poll() ; 
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = p.x + dx[i] ; 
                int ny = p.y + dy[i] ; 
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue ;
                if(visited[nx][ny])
                    continue ;       
                
                int diff = Math.abs(A[nx][ny]-A[p.x][p.y]) ;    
                if(diff < L || diff > R)
                    continue ;
                
                total += A[nx][ny] ; 
                q.offer(new Pair(nx, ny));   
                nations.add(new Pair(nx, ny)) ; 
                
                visited[nx][ny] = true ; 
            }
        } // while
        
        if(nations.size() != 1){
            move(nations, total) ; 
            print(A) ; 
            return true;
        }
        return false ; 
    }
    
    public static void move(ArrayList<Pair> nations, int total){
        
        for(int i = 0 ; i < nations.size() ; i++){
            Pair pair = nations.get(i) ; 
            
            A[pair.x][pair.y] = total / nations.size(); 
        }       
    }
    
    public static void print(int[][] A) {
    	for(int i = 0 ; i < N ; i++) {
    		for(int j = 0 ; j < N ; j++) {
    			System.out.print(A[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
