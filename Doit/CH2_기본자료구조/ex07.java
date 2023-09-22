package cH2_기본자료구조;

/**
 * @author HEEMIN
 * @date 2023. 9. 11.-오후 4:19:51
 *	@subject 배열 
 * @content  1,000 이하의 소수를 나열 


 */
public class ex07 {

	public static void main(String[] args) {
		
		int counter = 0; 
		
		for (int n = 2; n < 1000; n++) { // 나누어지는 수 (1--> 1000)
			int i ; 
			for ( i = 2; i < n; i++) { // 나누는 수 : 2부터 나누어지는 숫자까지 ex) 59 --> %2, %3, %,4 .... % 58 
				counter ++ ;  // 몫이 나올때까지 나눈 횟수  <-> 몫이 나오는 숫자까지 얼마나 갔니? 
				if(n%i == 0) 
					break ; // 몫이 나오면 그 수는 소수가 아님 --> 반복문 종료  
			} // i  
			if(n==i)  // 끝까지 반복문을 수행했다면 
				System.out.println(n); // 소수 출력 
		} // n 

		System.out.println("나눗셈을 수행한 횟수 : " + counter);
		
	} // main 

} // class 
