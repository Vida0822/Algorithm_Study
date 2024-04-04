package shortestPath;
import java.util.*; 

class Rupy implements Comparable<Rupy>{
    int x ; 
    int y ;
    int cost ; 
    
    public Rupy(int x, int y, int cost){
        this.x = x ; 
        this.y = y ;
        this.cost = cost ; 
    }
    @Override
    public int compareTo(Rupy other){
        return this.cost - other.cost ;     
    }
}

public class Gelda{
    // move in minimum cost (0,0) -> (n-1, n-1)
    public static void main(String[] args){
        //bfs + Node class + PriorityQueue 
        Scanner sc = new Scanner(System.in);
        
        int k = 1 ; 
        while(true){
            int n = sc.nextInt() ; 
            if(n==0) break ;
            
            int[][] cave = new int[n][n] ; 
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    cave[i][j] = sc.nextInt() ; 
                }
            }
            int answer = bfs(new Rupy(0,0,0), cave, n) ;
            System.out.println("Problem "+k+": "+answer) ; 
            k++ ; 
        }
    }
    public static int bfs(Rupy start, int[][] cave, int n){
        
        int[][] dist = new int[n][n] ; 
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i] , 125*125*10) ; 
        }
        
        PriorityQueue<Rupy> path = new PriorityQueue<>() ; 
        path.offer(start) ; 
        dist[start.x][start.y] = cave[0][0] ; 

        int[] dx = {1, -1 , 0, 0} ;
        int[] dy = {0, 0, 1, -1} ;         
        while(!path.isEmpty()){
            Rupy rupy = path.poll() ; 
            int x = rupy.x ; 
            int y = rupy.y ; 
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i] ; 
                int ny = y + dy[i] ; 
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue ;
                
                if(dist[nx][ny] > dist[x][y] + cave[nx][ny]){
                    dist[nx][ny] = dist[x][y] + cave[nx][ny] ; 
                    path.offer(new Rupy(nx, ny, dist[nx][ny])) ; 
                }
            }
        }
        return dist[n-1][n-1] ; 
    }
}