package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HEEMIN
 * @date 2023. 10. 1.-오후 1:36:13
 *	@subject  bfs : 재귀함수 없이 queue라는 자료구조 이용  (한줄하고, 다음줄하고) 
 * @content 

 */
public class InGrid {
	
	
	// 필드 	
	public static int[][] grid = new int[][] {
		{1, 0, 1, 1, 1},
		{1, 0, 1, 0, 1},
		{1, 1, 1, 0, 1},
		{1, 1, 1, 1, 1},
		{0, 0, 1, 0, 1},		
	} ; 
	
	public static int[][] answer = new int[5][5] ; 
	public static int[][] visited = new int[5][5] ; 
	public static int order = 1; 
	public static Queue<Pair> q = new LinkedList<Pair>() ; 
	
	// 메서드 
	public static boolean inRange(int x , int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5 ; 
	} // inRange - 따로 빼는 이유 : 나중에 주어진 격자가 바뀌었을 때범위 수정을 여기서만 해주면 아래 메서드들에선 수정할게 x ! 유지보수 up ! 
	// 문제 조건에 영향받는 애들은 재활용성이 높은 메서드들과 구분하여 따로 메서드로 작성 
	
	public static boolean canGo(int x, int y) {
		if(!inRange(x,y)) { // 범위 밖이면 탐색 x 
			return false ; 
		}
		if(visited[x][y] == 1 || grid[x][y] == 0) { // 방문했거나 뱀이 있으면 탐색 x 
			return false  ; 
		}
		return true ; 		
	} // canGo
	
	public static void push(int x, int y) {
		answer[x][y] = order ++ ; 
		visited[x][y] = 1 ;
		q.add(new Pair(x, y)); 
		
		/* No enclosing instance of type InGrid is accessible. Must qualify the allocation with an enclosing instance of type InGrid (e.g. x.new A() where x is an instance of InGrid).
		 
		   : static 함수에서 참조하려는 클래스가 닫혀 있어 접근 못한다는 오류(보통 내부에 있는 클래스를 static 함수가 참조할 때 에러)
		    --> Static 변수가 붙은 변수나 클래스는 클래스가 메모리에 올라갈 때 자동으로 생성 (프로그램 실행 전 생성) 
		    	( vs 인스턴스 멤버 : 프로그램 실행하면서 생성) 
		    --> static 메서드가 실행 시점에 인스턴스 생성되는 Pair, 즉 참조하는 클래스보다 먼저 실행되므로 순서가 잘못됨 
		    => 해결: push 를 인스턴스 메서드로, 또는 Pair을 static 클래스로 만듬  	 
		 */
	} // push

	static class Pair{
		int x, y ;  // 필드
		
		public Pair(int x, int y) {
			this.x = x ; 
			this.y = y ; 
		} // 생성자 
	} // pair 
	
	
	
	public static void BFS() {
		int[] dx = new int[] {1, 0} ; 
		int[] dy = new int[] {0, 1} ; 
		
		while(!q.isEmpty()) {
			Pair curr = q.poll() ; 
			int x = curr.x, y= curr.y  ; 
			
			for (int i = 0; i < 2; i++) {
				int newX = x+dx[i] ; 
				int newY = x+dy[i] ; 
				
				if(canGo(newX, newY)) {
					push(newX, newY) ; 
				} // if 
			} // for 
		} // while 
	} // bfs 
	

	public static void main(String[] args) {
		push(0, 0);
		BFS() ; 
	} // main 

} // class 
