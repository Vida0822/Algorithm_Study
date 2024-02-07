package cH3_배열검색;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 13.-오전 9:38:01
 *	@subject 선형 검색 - while문 무한루프
 * @content 종료조건 2개 (검색 실패, 검색 성공) 충족 여부 각각 분기로 판단

 */
public class ex01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		
		// part1 . 배열 만들기 
		System.out.print("요솟수: "); 
		int num = sc.nextInt() ; 
		int[] x = new int[num] ; 
		
		for (int i = 0; i < num; i++) { // length 보다 이게 나을듯? 이미 변수로 있으니 (근데 유지보수 생각해 배열 개수 변화할 것을 생각하면 length로 하는게 동적으로 값 입력되서 더 나을 듯 !) 
			System.out.print("x["+i+"]: ");
			x[i] = sc.nextInt();  // 배열 채우기 
		} // for 

		// part2. 키값 입력받기 
			System.out.print("검색할 값 : ");
			int key = sc.nextInt() ; 
			
		// part 3. 검색하기 			
			int idx = seqSearch(x, num, key) ; 
			
			if(idx == -1 )
				System.out.println("그 값의 요소가 없습니다.");
			else
				System.out.println("그 값은 x["+idx+"]에 있습니다. ");
			
	} // main 
	
	 // 검사 대상 배열, 끝값 , 찾을 값  => 반환값 : 그 요소의 위치, 즉 index
	static int seqSearch(int[] a, int n , int key ) {
		int i = 0 ; 
		
		while(true) {
			if(i==n)
				return -1 ; 
			if(a[i] == key)
				return i ;  
			
			i ++ ; 
		} // while 
	} // seqSearch 

} // ex01 
