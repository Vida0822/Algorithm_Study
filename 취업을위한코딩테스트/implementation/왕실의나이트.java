package implementation;

import java.util.Scanner;

public class 왕실의나이트 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		String[] coordinate = sc.next().split("") ;  // a1 
		int x = coordinate[0].codePointAt(0) - 96 ;  
		/*
		 * 자바 인코딩은 '아스키 코드'를 기준으로 하고 있다. 
		 * ㄴ 암기 <A : 65 / a : 97 >
		 */
		int y = Integer.parseInt(coordinate[1]); 
		
		int[] dx = {2, 2, -2, -2,1, -1, 1 , -1} ; 
		int[] dy = {1, -1, 1 , -1,2, 2, -2, -2} ; 
		int length = dx.length;
		
		int answer = 0 ; 
		for(int i = 0 ; i < length ; i++) {
			int newX = x + dx[i] ; 
			int newY = y + dy[i] ; 
			
			if(canGo(newX, newY)) {
				answer++; 
			}
		}
		System.out.println(answer);
	} // main  
	public static boolean canGo(int newX, int newY) {
		if(newX<1 || newX > 8 || newY<1 || newY > 8)
			return false; 
		return true ; 
	}
} // class 
 
