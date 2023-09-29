package ch3_배열검색;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 17.-오후 4:16:03
 *	@subject Arrays.binarySearch() 
 * @content  기본형 배열 이진검색 


 */
public class ex05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		
		System.out.print("요솟수: "); 
		int num = sc.nextInt() ; 
		int[] x = new int[num] ; 
		
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
		
		int idx = Arrays.binarySearch(x, key) ;  // x 배열에서 key값을 찾아주는 binarySearch() 
		
		if(idx < 0 ) // 이런건 api를 잘 읽어봐야 활용할 수 있겠지? 삽입포인트 hint는 음수로 반환 <-> 검색이 안되서 음수인 삽입 포인트 hint 가 반환되면, 검색 실패 의미 
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println("그 값은 x["+idx+"]에 있습니다. ");
		
	} // main 

} // class 
