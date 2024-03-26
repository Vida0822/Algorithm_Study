package greedy;

import java.util.HashMap;
import java.util.Scanner;

public class 볼링공고르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int N = sc.nextInt() ; 
		int M = sc.nextInt() ; 
		
		HashMap<Integer, Integer> map = new HashMap<>() ; // weight, count
		for(int i = 0 ; i < N ; i++) {
			int K = sc.nextInt() ; 
			map.put(K, map.getOrDefault(K,0)+1) ; 
		}
		
		// 무게순 정렬 
		// 1 2x2 3x2   // 1  2x2  3  4x2 5  1x(n-1) 2x(n-1-2) 1x(n-1-2-1) 2x
		int answer = 0 ; 
		for(int weight : map.keySet()) {
			int count = map.get(weight) ; 
			N -= count ; 
			answer += count*N ;
		}
		System.out.println(answer); 
	} 

}
