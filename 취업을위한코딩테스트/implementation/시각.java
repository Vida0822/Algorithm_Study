package implementation;

import java.util.Scanner;

public class 시각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int answer = 0 ; 
		int seconds = 60*60*(n+1) ; 
		
		// 초 증가 --> 다시 시간, 분 , 초로 변환하는게 아니라 시간, 분, 초 각각에서 1씩 증가시켜주고 (진짜 시겨 원리처럼, 초를 다채우면 분++ 분을 다채우면 시++) 
		// 굳이 문자열로 변환하지 않고 몫, 나머지를 이용해 숫자를 그대로 계산 
		for(int h = 0 ; h <= n ; h++) {
			for(int m = 0 ; m < 60 ; m++) {
				for(int s = 0 ; s < 60 ; s++) {
					if(h%10 ==3 || m/10 == 3 || m%10 == 3 || s/10 == 3 || s%10 == 3 )
						answer ++ ; 
				}
			}
		}
		System.out.println(answer);
	} // main 
} // class 
