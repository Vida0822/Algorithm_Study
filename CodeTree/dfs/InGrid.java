package dfs;

/**
 * @author HEEMIN
 * @date 2023. 9. 26.-오전 7:53:39
 *	@subject 격자 안에서 dfs 탐색 
 * @content  인접 행렬이나 인접 리스트를 만들 필요 없다 


 */
public class InGrid {
	
	public static int[][] grid = new int[][] {
		{1,0,1,1,1,},
		{1,0,1,0,1,},
		{1,1,1,0,1,},
		{1,1,1,1,1,},
		{0,0,1,0,1}
	} ; 
	
	public static int[][] answer = new int[5][5]; 
	public static int[][] visited = new int[5][5]; 
	public static int order = 1; 
	
	public static boolean inRange(int x, int y) {
		return 0<= x && x < 5 && 0<=y && y<5 ; 
	}
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x, y))
			return false ; 
		if(visited[x][y] == 1 || grid[x][y] == 0)
			return false ; 
		return true ; 
	}
	
	public static void DFS(int x, int y) {
		int[] dx = new int[] {1,0}; 
		int[] dy = new int[] {0,1};
		
		for (int i = 0; i < 2; i++) {
			int newX = x+dx[i]; 
			int newY = y+dy[i]; 
			if(canGo(newX, newY)) {
				answer[newX][newY] = order ++ ; 
				visited[newX][newY] = 1 ;
				DFS(newX, newY) ; 
			} // if 
		} // for 
		
	} // dfs 
	

	public static void main(String[] args) {
		answer[0][0] = order ++ ; 
		visited[0][0] = 1; 
		DFS(0, 0);

	} // main 
} // class 
