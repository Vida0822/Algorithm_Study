import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map ; 
    public static int N ; 
    
    public static void main(String[] args) throws IOException {

        // step 1 : 지도 그리기  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) ; // N < 25 --> N^3 도 ok

        map = new int[N][N] ; 
        for(int i = 0 ; i < N ; i++){
            char[] ch = br.readLine().toCharArray() ; 
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(ch[j]+"") ; 
            }
        }
        
        // step 2 : 장애물 파악하기 
        int index = 1 ; 
        ArrayList<Integer> list = new ArrayList<>() ; 
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1){
                    index += 1 ; 
                    map[i][j] = index ; 
                    list.add(dfs(index,i, j, 1)) ;
                }
            }
        }

        // step 3 : answer 출력        
        //answer 1 : 장애물 불록수 
        System.out.println(index-1) ;

        // answer 2 : 각 블록에 속하는 장애물 수 오름차순 출력 
        Collections.sort(list) ; 
        for(int i = 0 ; i < list.size() ; i++)
            System.out.println(list.get(i)) ;    
    }
    
    public static int dfs(int index, int x, int y, int count){
        int[] dx = {-1, 1, 0, 0} ; 
        int[] dy = {0, 0, -1, 1} ; 

        for(int i = 0 ; i < 4 ; i++){
            int nx = x + dx[i] ;
            int ny = y + dy[i] ; 

            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue ; 
            
            if(map[nx][ny] == 1){
                map[nx][ny] = index; 
                count += 1 ; 
                count = dfs(index , nx, ny, count) ;
            }
        }
        return count; 
    }
}
