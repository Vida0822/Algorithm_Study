package dfs_bfs ; 
import java.util.* ; 

class 감시피하기{
    public static int N ; 
    public static String[][] board ; 
    public static void main(String[] args){
        
        // 입력 
        Scanner sc = new Scanner(System.in); 
        N = sc.nextInt() ; 
        board = new String[N][N] ; 
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                board[i][j] = sc.next() ; 
            }
        }
        // dfs 
        boolean result = buildObstacle(0,0) ; 
        
        // 출력 
        if(result)
            System.out.println("YES") ; 
        else
            System.out.println("NO") ; 
    }
    
    public static boolean buildObstacle(int count, int start ){
        // 종료조건 
        if(count == 3){
            for(int i = 0 ; i < N ; i++){  	
                for(int j = 0 ; j < N ; j++){
                    if(board[i][j].equals("T"))
                        if(catchS(i, j))
                            return false; 
                }
            }
            return true; 
        }
        
        // 백트래킹 
        for (int i = start; i < N * N; i++) {
            int x = i / N;
            int y = i % N;
            if (board[x][y].equals("X")) {
                board[x][y] = "O";
                if (buildObstacle(count + 1, i + 1)) { // 재귀 호출 시 시작 인덱스를 다음으로 옮김
                    return true;
                }
                board[x][y] = "X";
            }
        }
        return false;
    }
    
    public static boolean catchS(int x, int y){
        
        for(int i = y ; i >= 0 ; i--){
            if(board[x][i].equals("S"))
                return true ;
            if(board[x][i].equals("O"))
                break; 
        }
        for(int i = y ; i < N ; i++){
            if(board[x][i].equals("S"))
                return true ;
            if(board[x][i].equals("O"))
                break; 
        }
         for(int i = x ; i >= 0 ; i--){
            if(board[i][y].equals("S"))
                return true ;
            if(board[i][y].equals("O"))
                break; 
        }
        for(int i = x ; i < N ; i++){
            if(board[i][y].equals("S"))
                return true ;
            if(board[i][y].equals("O"))
                break; 
        }
        return false; 
    }
}