package arrayShift;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 4:29:43
 *	@subject 직사각형 요소들 회선하기  
 * @content 

 [ 유의사항 ] 
* 가장자리를 왼쪽, 아래, 오른쪽, 위 이렇게 4개의 부분으로 shift해야 문제를 깔끔하게 해결 할 수 있다 
 	: container belt를 4개라고 생각 (끝값끼리 맞추기) 
*shift 로직 --> 격자 장난감 생각 (하나 빼고 돌리기)
* 인접한 숫자들과의 평균으로 바꾸는 작업은 동시에 일어나야하므로 평균 구하면서 새로운 배열에 기록한뒤 마지막에 그값 다시 복사  

 */
public class Two_Dimensional_Wind_Ans {
	
	public static final int MAX_M = 100; 
	public static final int MAX_N = 100; 
	public static final int DIR_NUM = 5; 
	
	// 전역 변수 선언 --> 다른 메서드들의 작업이 반영되기 위함 (반환 , 주입 필요 x) 
	public static int n, m ,q ; 

	public static int[][] a = new int[MAX_N+1][MAX_M+1] ;
	public static int[][] tempArr = new int[MAX_N+1][MAX_M+1] ;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		n = sc.nextInt() ; 
		m = sc.nextInt() ; 
		
		
	//part 1 . 격자 만들기 
		// => 일부로 1부터 채워줌 = (x=0) 은 비어있는 상태
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= m; col++) {
				a[row][col] = sc.nextInt() ; 
			}
		} // for 
		
	// part 2. 바람 정보 받기 
		q = sc.nextInt() ; 
		
		// 새로운 격자 만들지 x 
		// --> 밑에선 기존의 격자를 활용해 그 시작값만 지정해주는거임
		// (새로운 배열을 만들어 0 부터 시작하는 구조 x -->그러면 matching 작업 추가되어 복잡해짐 ) 
		while (q-->0) {
			int r1, c1, r2, c2 ; 
			r1 = sc.nextInt() ; 
			c1 = sc.nextInt() ; 
			r2 = sc.nextInt() ; 
			c2 = sc.nextInt() ; 
			
	// part 3 . 회전하기 = shift 하기 + 평균 대체하기 
			 rotate(r1, c1, r2, c2);
			 setAverage(r1, c1, r2, c2);

		} // while 
		 
	// part 4. 출력하기 
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= m; col++) {
				System.out.print(a[row][col]+" ");
			}
			System.out.println();
		} // for 	
	} // main 

	
	
	private static void rotate(int startRow, int startCol, int endRow, int endCol) {
		
		int temp = a[startRow][startCol] ;  // 지정된 바람격자 맨 왼쪽 모서리 값 temp 에 저장 
		
		/* 
		 * container belt를 4개라고 생각 (끝값끼리 맞추기)
		 => 이렇게 격자 위에서 회전하는 것은 하나의 statement로 처리하는 것이 아닌 각 면을 나눠 각각 statement로 처리하는게 깔끔 
		 => 4 면을 돌리는게 아니라, 한면 shift --> 그다음면 shift  --> 그다음면 shift    --> 그다음면 shift   
		 => rotate = 각각의 shift * 4 
		*/
		 // 1) 직사각형 가장 왼쪽 열을 위로 한 칸씩 shift 합니다. 
		for (int row = startRow; row < endRow; row++) {
			a[row][startCol] = a[row+1][startCol] ; 
		} // --> 맨 왼쪽 아래 빔
		
		// 2) 직사각형 가장 아래 행을 왼쪽으로 한 칸씩 shift 합니다.
		for (int col = startCol; col < endCol; col++) {
			a[endRow][col] = a[endRow][col+1] ; 
		} // --> 맨 오른쪽 아래 빔 
		
		// 3)  직사각형 가장 오른쪽 열을 아래로 한 칸씩 shift 합니다.
		for (int row = endRow; row > startRow; row--) {
			a[row][endCol] = a[row-1][endCol] ; 
					// row 가 작을수록 위에있음 
		} // --> 맨 오른쪽 위 빔 
		
		// 4)  직사각형 가장 위 행을 오른쪽으로 한 칸씩 shift 합니다.
		for (int col = endCol; col < startCol; col--) {
			a[startRow][col] = a[startRow][col-1] ; 
		} // --> 맨위 두번째 칸 빔 
		
		// temp를 가장 왼쪽 위 모서리를 기준으로 바로 오른쪽 칸
		a[startRow][startRow+1] = temp ; 

	} // rotate
	

	// 평균값으로 요소 대체하는 메서드 
	private static void setAverage(int startRow, int startCol, int endRow, int endCol) {
		
		for (int row = startRow; row <= endRow; row++) {
			for (int col = startCol; col <= endCol; col++) {
				// 해당 위치(row, col) 인접한 칸들로 평균을 구해서, 임시격자의 동일한 위치에 값 넣어주기 --> 반복해서 임시배열 꽉 채우기 
				tempArr[row][col] = average(row, col) ;
			}
		} // for 
		
		for (int row = startRow; row <= endRow; row++) {
			for (int col = startCol; col <= endCol; col++) {
				// 그렇게 완성된 임시배열 값 하나씩 읽어와 원래의 배열에 입력 (임시 배열과 동일한 row, col로 위치를 일치시키는게 포인트) 
				a[row][col] = tempArr[row][col] ; 
			}
		} // for 
	} // setAverage


	// 인접한 숫자들과의 평균값을 계싼해줌 
	private static int average(int x, int y) {
		
		// 인접한 요소들과의 좌표값 차이 --> 배열로 index로 두 배열 매칭하면 원래값에서 x,y좌표 변화값 도출  
		int[] dx = new int[] {0,1,-1,0,0}; 
		int[] dy = new int[] {0,0,0,1,-1}; 
		
		int sum = 0, cnt = 0; 
		
		for (int dir = 0; dir < DIR_NUM; dir++) {
			// 5로 한번에 처리하되, 모서리인 경우 없는 칸을 계산하지 않게 분기 
			int nx = x+dx[dir] , ny = y +dy[dir] ;  // (x,y) + (0,0) , (1,0) , (-1,0), (0,1), (0, -1) 
			if(isRange(nx,ny)) {
				sum += a[nx][ny] ; 
				cnt++ ; 
			}
		}// for 
		
		return sum/cnt ; // 합계는 DIR_NUM이 아니라 실제로 요소값이 조회된 회수로 나눠야하므로 분기안에 cnt 표함해서 활용 
	} // average


	// 인접한 칸들이 격자를 벗어나는지 확인 
	private static boolean isRange(int x, int y) {
		
		// 4가지 경우 고려해줘야함 ! (검사값 좌표가 격자 세로
		return 1<= x && x <=n && 1<= y && y<= m; // ?? 질문 왜 범위값을 이렇게 잡았지 (화욜일에 다시 따져보고 질문) 
	} // isRange
	
	
}
