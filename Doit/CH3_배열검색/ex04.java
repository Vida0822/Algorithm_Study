package CH3_배열검색;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 3:16:01
 *	@subject 이진 검색 첫실습 
 * @content 


 */
public class ex04 {
	
	static int binSearch(int[] a , int n , int key) {
		int pl = 0 ;  // 처음 검색 시작할 땐 끝값이 pl, pr ! 
		int pr = n-1 ; 
		
		do {
			int pc = (pl+pr) / 2;  // pc 는 중앙값 (버림) 
			
			if(a[pc] == key)
				return pc ;  // 찾은 key값의 index 반환 ! 
			else if(a[pc] < key) // 찾는 key값이 중앙값보다 크면
				pl = pc + 1 ; // 검색 범위를 중앙값 뒤로 옮김 
			else
				pr = pc - 1 ;  // 찾는 key값이 중앙값보다 작으면 검색 범위를 중앙값 앞으로 옮김 ! 
			
		}while(pl <= pr) ;  // 검색범위의 종료조건 -- 검색값이 없어 pl보다 pr이 커짐

		return -1 ; // 검색 실패 종료조건을 만족해 반복문을 빠져나오면 -1 return 
		
	} // binSearch
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		// 요소수 입력받아 배열 생성 
		System.out.print("요솟수: ");
		int num = sc.nextInt(); 
		int[] x = new int [num] ; 
		
		// 배열 요소값 입력받음 
		System.out.println("오름차순으로 입력하세요."); 
		
		System.out.print("x[0]: " );
		x[0] = sc.nextInt() ; 
		
		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x["+i+"]: ");
				x[i] = sc.nextInt() ; 
			}while(x[i] < x[i-1]) ; // 앞의 요소보다 작으면 (정렬이 아니면) 다시 입력받기 
		} // for 
		
		// 검색 
		System.out.print("검색할 값: ") ;
		int key = sc.nextInt() ; 
		
		int idx = binSearch(x, num, key); 
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println("그 값는 x["+idx+"]에 있습니다.");
		
	} // main 

} // class 
