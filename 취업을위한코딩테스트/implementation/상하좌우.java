package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 상하좌우 {
	
	static int dx[] = {0 , 0, -1, 1 } ; // LRUD 
	static int dy[] = {-1, 1, 0, 0} ; // ※ 우하향으로 갈 수록 좌표값이 커진다 
	static int n ; 
	
	public static void main(String[] args) {
		
		// part 1. 격자 및 좌표 구현 
		// 격자는 이차원배열로, 좌표상 이동은 각각 dx, dy 배열로 구현하여 상하좌우 이동을 구현한다 
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		
		
		// part 2. 계획서 입력받기 
		sc.nextLine() ; // 버퍼 비우기 - sc.next()로 하면 다음 글자 먹힘
		/*
		 * next()는 개행 문자를 무시하고 입력받기 때문에 해당 명령어가 무시되서 버퍼에 \n 이 남아있게 된다 
		 * 이후의 nextInt() 등이 오면 개행문자를 무시하고 값을 가져오기 때문에 숫자만 정상적으로 가져오지만
		 * nextLine()은 공백문자, 개항문자 분리자를 포함하고, 개항문자를 보는 순간 입력을 종료시키기 때문에(개항문자까지의 문자열을 입력받는 메서드)이후의 값은 무시된다. 
		 * => 중간에 nextLine()을 넣어줘야한다.  
		 */
		String plan = sc.nextLine() ; 
		String[] moves = plan.split(" ") ; 
		String[] moveTypes = {"L", "R", "U", "D"};
		
		Pair A = new Pair(1, 1) ; 
		for(int i = 0 ; i < moves.length ; i++ ) {
			
			int index = 0 ; 
			/*
			switch(moves[i]) {
				case "L" : 
					index = 0 ; 
					break ; 
				case "R" : 
					index = 1 ; 
					break ; 
				case "U" : 
					index = 2 ; 
					break ; 
				case "D" : 
					index = 3 ; 
					break; 
			} // switch
			*/
			for(int j = 0 ; j < 4 ; j++) {				
				int newX = 0 , newY = 0;
				
				// 이동 계획을 하나씩 비교 하나씩 확인 
				if(moves[i] == moveTypes[j]) {
					newX = A.x + dx[index] ; 
					newY = A.y + dy[index] ; 				
				} // if 
				if(inRange(newX, newY)) {
					A = new Pair(newX, newY) ; 
				} // if 	
			}	 // for 
		} // for 
		System.out.println(A.x+" "+ A.y) ; 
	} // main 
	
	public static boolean inRange(int newX, int newY) {
		if(newX < 1 || newX > n) {
			return false ; 
		}
		if(newY < 1 || newY > n) {
			return false ; 
		}
		return true;
	} // inRange
} // class 


class Pair{
	int x ; 
	int y ; 
	public Pair(int x, int y) {
		this.x = x ; 
		this.y = y; 
	}
} // Pair
