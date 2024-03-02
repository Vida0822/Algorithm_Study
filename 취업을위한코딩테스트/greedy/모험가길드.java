package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 모험가길드 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		
		int[] fighters = new int[n] ; 
		for(int i = 0 ; i < n ; i++) {
			fighters[i] = sc.nextInt() ; 
		}
		
		// 1. 모험가 길드원 정렬 
		Arrays.sort(fighters) ; // 1 2 2 2 3 
		
		// 2. 가장 적은 모험가부터 검사하면서 그룹 내 모험가 점수 <= 그룹 인원 되는 순간 그룹수++ 
		int group = 0 ; 
		int m_num = 0 ;
	//	int max_score = 0 ; 
		for(int fighter : fighters) {
			m_num++ ; 
			
			if(fighter <= m_num) {
				group++; 
				m_num = 0 ; 
			}
		} // for
		
		System.out.println(group);
	}
}
