package dp ; 

import java.util.* ; 

class 병사배치하기_1_이중for{
    public static int N ; 
    public static ArrayList<Integer> soilders = new ArrayList<>() ; 
    public static int[] dp ; 
    public static void main(String[] args){
        
     
        // 전투력이 높은 병사가 앞쪽에 오도록 내림차순 배치 
        Scanner sc = new Scanner(System.in) ; 
        N = sc.nextInt() ;
        dp = new int[N] ; 
        
        for(int i = 0 ; i < N ; i++){
            soilders.add(sc.nextInt()) ;
        }
        
        // 오름차순으로 변환 
        Collections.reverse(soilders); 
        
        /*dp */
        /*
        최장부분증가수열 
        : {6,2,5,1,7,4,8,3} 이라는 배열이 있을 때, LIS는 {2,5,7,8} 이 된다. 
        --> 증가하는 부분 수열 중 가장 길이가 긴 것
        ㄴ> 도출 방법 : DP 이용 --> dp[i] = i번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이(최대 값) 
        */ 
        
        // 초기조건 
        for(int i = 0 ; i < N ; i++){
            dp[i] = 1 ; 
        }
        
        
        // 주어진 배열에서 인덱스를 한 칸씩 늘려가면서, 
        // 내부 반복문으로 k보다 작은 인덱스들을 하나씩 살펴봄 (soilders[i] < soilders[k]) 
        // dp[i] 업데이트 : Max 비교
        // 1. 추가하지 않고, 즉 그 smaller 값을 포함시키지 않고 기존의 dp 사용 ex) 그 smaller 값을 포함시키면 그 사이의 값들이 더 많이 못 오는 경우 
        // 2. 그 smaller 값을 추가해 현재 dp[i]+1 (길이 증가 )
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(soilders.get(j) < soilders.get(i))
                    dp[i] = Math.max(dp[i], dp[j]+1) ; 
            }
        }
        
        int max = 0 ; 
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max, dp[i]) ; 
        }
        System.out.println(N - max) ; 
    }
}