package arrayShift ; 
import java.util.Scanner;

public class BombTower_MY2 {  
   public static int[] numbers = new int[100] ; 
   public static int n, m ; 
   public static int endOfArray ; 
   

    public static void main(String[] args) {
        // part 1. 타워 세우기 
        Scanner sc = new Scanner(System.in); 
        
        n = sc.nextInt();
        m = sc.nextInt() ; 
        endOfArray = n ; 
    
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt() ;    
        } 
        
        // part 2. 중복 체크 (중복값 누적으로 비교 ) --> 바로 자르기 
        int startInx = 0 ; 
        int endIdx = 0;   
        int same;
        
        for (int i = 0; i <endOfArray; i++) {  
            startInx = endIdx = i; 
            same = 1;
            
            for (int j = i+1; j < endOfArray; j++) {
                if(numbers[i] != numbers[j]) {
                    //break ; 
                    continue ; 
                }
                same ++; 
                endIdx ++;   // =j    
            } 
            //연속 아이템이 안나올 때까지 for문 돌리기
            if(same>=m) {
                makeZero(startInx, endIdx) ;    
                i = endIdx;
            }
        } // for 
            
        // part 4. 출력하기 
        if(endOfArray == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < endOfArray; i++) {
                if(numbers[i]==0)
                    continue;
                System.out.println(numbers[i]);
            } 
        }

    } // main 
   

public static void makeZero(int startIdx, int endIdx) {
    for (int i = startIdx; i <= endIdx; i++) { 
        numbers[i] = 0 ; 
    }            
}  
   
   
} // BombTower