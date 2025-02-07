import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        // 1*3 영역의 땅 높이 동일하게 만듬 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 

        int[][] map = new int[3][3] ; 
        for(int i = 0 ; i < 3 ; i++){
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray() ; 
            for(int j = 0 ; j < 3 ; j++){
                map[i][j] = row[j] ; 
            }
        }

        int min = Integer.MAX_VALUE ; 
        
        for(int i = 0 ; i < 3 ; i++){
            ArrayList<Integer> rows = new ArrayList<>() ; 
            ArrayList<Integer> cols = new ArrayList<>() ; 
            
            for(int j = 0 ; j < 3 ; j++){
                rows.add(map[i][j]) ;  
                cols.add(map[j][i]) ;  
            }
            
            Collections.sort(rows) ; 
            Collections.sort(cols) ;
            
            if(rows.get(0) == rows.get(2) || cols.get(0) == cols.get(2)){
                System.out.println(0) ; 
                return ; 
            }
            min = Math.min(rows.get(2) - rows.get(0), min) ; 
            min = Math.min(cols.get(2) - cols.get(0), min) ; 
        }
        System.out.println(min);
    }
}
