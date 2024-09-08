/*
A[] : N개의 수로 이루어져있음 
ㄴ 연산자 N-1개가 주어짐 --> 하나씩 끼워 넣어서 수식을 만듬 
--> 만들 수 있는 식의 결과 중 최대, 최소를 도출 

※ 음수/양수 시 음수 -> 양수 후 나누기한 몫에 음수를 취함 
*/
package dfs_bfs; 
import java.util.* ; 

public class 연산자끼워넣기{
    public static int N ; 
    public static int[] A ; 

    public static int add, sub, mul, div; 
    public static int max = (int) -1e9 ;
    public static int min = (int) 1e9 ; 
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ; 
        N = sc.nextInt() ; 
        
        A = new int[N] ; 
        for(int i = 0 ; i < N ; i++){
            A[i] = sc.nextInt() ; 
        }
        // 넣다 뺐다 dfs로 모든 가능한 수식 조합을 만든 뒤,
        // 수식을 끝까지 다봤을때? 종료하고 해당 수식 계산 후 max, min 값 업데이트        
        
        add = sc.nextInt() ; 
        sub = sc.nextInt() ; 
        mul = sc.nextInt() ; 
        div = sc.nextInt() ; 
        
        dfs(1,A[0]) ;   
        
        System.out.println(max);
        System.out.println(min);
    }
    
    public static void dfs(int turn, int result){
        if(turn == N){
            max = Math.max(max, result) ; 
            min = Math.min(min, result) ; 
            return ; 
        }
              
        if(add > 0){
        	add -= 1  ; 
            dfs(turn+1, result + A[turn]) ; // 복잡하게 문자열로 치환하지 말고 바로 계산해서 넘겨주기 (문자열 치환시 나중에 순차 탐색하며 재계산해야함) 
            add += 1; 
        }        
        if(sub > 0){
            sub -= 1 ;  
            dfs(turn+1, result - A[turn]) ; 
            sub += 1 ;
        }
        if(mul > 0){
            mul -= 1 ;
            dfs(turn+1, result * A[turn]) ; 
            mul += 1 ;  
        }
        if(div > 0){
            div -= 1 ;
            dfs(turn+1, result / A[turn]) ; 
            div += 1 ;  
        }
        return ; 
    }
}