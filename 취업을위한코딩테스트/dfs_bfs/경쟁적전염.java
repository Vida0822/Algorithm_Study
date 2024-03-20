package dfs_bfs;

import java.util.Scanner;

public class 경쟁적전염 {
	public static int n, k, s ; 
	public static int[][] lab ; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt() ; 
		k = sc.nextInt() ; 
		
		// making labatory 
		lab = new int[n][n] ; 
		for(int i = 0 ; i < n ; i++) 
			for(int j = 0 ; j < n ;j++)
				lab[i][j] = sc.nextInt() ; 
		
		s = sc.nextInt() ; 
		virus(1) ;  
		
		int x = sc.nextInt() ; 
		int y = sc.nextInt() ; 
		System.out.print(lab[y-1][x-1]);
	}
	
	public static boolean virus(int virusNum) {
		
		// 종료 조건 
		if(virusNum > k)
			return false;
		
		// 해당 번호에 해당하는 바이러스 퍼트리기 
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(lab[i][j] == virusNum) {
					spreadVirus(virusNum , i, j) ; 
				}
			}
		} 
		return virus(virusNum+1) ; 
	}
	
	
	public static void spreadVirus(int virusNum, int x, int y) {
		// bfs -> 가능한 끝까지 퍼트리는게 아닌 가까운 쪽부터 증식하다가 중간에 끊길 수도 있으므로 bfs로 처리해줘야함 
		
		int[] dx = {1, -1, 0, 0} ; 
		int[] dy = {0, 0, 1, -1} ;
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i] ; 
			int ny = y + dy[i] ; 
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue ; 
			if(lab[nx][ny] == 0) {
				lab[nx][ny] = virusNum ; 
				/*시간+1 코드 */ 
				spreadVirus(virusNum,nx,ny) ; 
			}
		}
	}
}
