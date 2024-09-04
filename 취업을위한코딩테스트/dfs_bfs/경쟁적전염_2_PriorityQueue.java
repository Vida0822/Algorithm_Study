package dfs_bfs; 
import java.util.* ; 
// 바이러스 종류 : 1 ~ K 
// ㄴ 1초마다 상하좌우 방향으로 증식 (낮은 종류의 바이러스부터)
//    --> 증식 과정 중 특정 칸에 어떤 바이러스가 존재한다면, 그곳엔 다른 바이러스 X 
// answer : s 초가 지난 후 특정 위치 (x,y)에 존재하는 바이러스 존재 출력 (바이러스 없으면 0)

class Virus2 implements Comparable<Virus2>{
	
    int index ; 
    int x ; 
    int y ; 
    int sec; 
    
    public Virus2(int index, int x, int y, int sec){
        this.index = index ; 
        this.x = x ; 
        this.y = y ; 
        this.sec = sec ; 
    }
    
    public int compareTo(Virus2 other){
        if(this.sec == other.sec)
            return this.index - other.index ;   
        return this.sec - other.sec ; // 초가 낮은것부터
    }
}
public class 경쟁적전염_2_PriorityQueue{
    public static int N ; 
    public static int K ; 
    public static int[][] lab ; 
    
    public static int S, X, Y ;
    public static PriorityQueue<Virus2> q = new PriorityQueue<>() ;  
    
    public static int[] dx = {-1, 1, 0, 0} ; 
    public static int[] dy = {0, 0, -1, 1} ; 
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in) ; 
        N = sc.nextInt() ; // ~ 200  
        K = sc.nextInt() ; // ~ 1000
        
        lab = new int[N][N] ; 
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                lab[i][j] = sc.nextInt() ;    
                if(lab[i][j] != 0)
                    q.offer(new Virus2(lab[i][j], i, j, 0)) ;        
            }
        }
             
        S = sc.nextInt() ; // ~ 10000  
        spread() ; 
        
        X = sc.nextInt() ; // ~ N 
        Y = sc.nextInt() ; 
        
        for(int i = 0 ; i < N ; i++) {
        	for(int j = 0 ; j < N ; j++) {
        		System.out.print(lab[i][j]+" ");
        	}
        	System.out.println();
        }
        System.out.print(lab[X-1][Y-1]) ; 
    }
    
    // bfs --> virus 자체가 우선순위가 있기 때문에 해당 좌표부터 먼저 검사해줘야한다.  
    public static void spread(){
     
       while(!q.isEmpty()){
           Virus2 virus = q.poll() ; 
           
           if(virus.sec == S)
               break ;
           
           for(int i = 0 ; i < 4 ; i++){
               int nx = virus.x + dx[i] ; 
               int ny = virus.y + dy[i] ; 
               
               if(0 <= nx && nx < N && 0 <= ny && ny < N){
                   if(lab[nx][ny] == 0){
                       lab[nx][ny] = virus.index ;
                       q.offer(new Virus2(virus.index, nx, ny, virus.sec+1)) ; 
                   }       
               }
           }
       }  
    }
}