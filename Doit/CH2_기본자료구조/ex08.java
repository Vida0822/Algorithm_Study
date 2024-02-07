package cH2_기본자료구조;

public class ex08 {
	
	public static void main(String[] args) {
		
		int counter = 0;  // 나눗셈의 횟수 
		int ptr = 0;  // 찾은 소수의 개수 
		int[] prime = new int[500] ;  // 소수를 저장하는 배열 
		
		prime[ptr++] = 2; 
		
		for (int n = 3; n <= 1000 ; n+=2) {
			int i ; 
			for ( i = 0; i < ptr; i++) {
				counter ++ ; 
				if(n%prime[i] == 0) {
					break ; 					
				} // if 
			} // i 
			if(ptr == i) {
				prime[ptr++] = n ; 
			} // if
		} // n 
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		} // for 
		
		System.out.println("나눗셈을 수행한 횟수: "+ counter);
		
		int[] a = {1,2,3,4};
		
	} // main 

} // class 
