import java.util.* ; 
import java.io.* ; 

class Main{
    
    public static final int INF = (int)1e9 ; 
    
    public static void main(String[] args) throws IOException{
        // n : 노드 
        // m : 간선 
        // 모든 도시의 쌍 (A,B) , A->B 필요 비용 최솟값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 
        int n = Integer.parseInt(br.readLine()) ;
        int m = Integer.parseInt(br.readLine()) ;
        
        int[][] distances = new int[n+1][n+1] ; 
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(i==j)
                    distances[i][j] = 0 ; 
                else
                    distances[i][j] = INF ; 
            } 
        }
            
        for(int i = 0 ; i < m ; i++){
            int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray() ; 
            distances[route[0]][route[1]] = Math.min(route[2] , distances[route[0]][route[1]]) ;   
        }
        
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                for(int k = 1 ; k < n+1 ; k++){
                    distances[i][j] = Math.min(distances[i][j], distances[i][k]+distances[k][j]) ; 
                }
            }
        }
        
        for(int i = 1 ; i < n+1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                if(distances[i][j] == INF)
                    System.out.print(0+" ") ; 
                else
                    System.out.print(distances[i][j]+" ") ;
            }
            System.out.println() ; 
        }
    }
}
