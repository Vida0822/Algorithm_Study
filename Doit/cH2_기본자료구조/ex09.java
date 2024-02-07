package cH2_기본자료구조;

public class ex09 {

	public static void main(String[] args) {
		
		int counter = 0 ; 
		int ptr = 0 ; 
		int[] prime = new int[500] ; 
		
		prime[ptr++]  = 2 ;
		prime[ptr++]  = 3 ;
		
		for (int n = 5; n <= 1000; n += 2) {
			boolean flag = false; 
			
			for (int i = 1; i < prime[i]*prime[i]; i++) {
				counter += 2; 
				if(n% prime[i] == 0 ) { 
					flag = true ; 
					break ; 
				}// if 
			} // for 
			if(!flag) {
				prime[ptr++] = n ; 
				counter ++ ; 
			}
		} // for 
		
		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		} // for 
		
		System.out.println("곱셈과 나눗셈을 수행한 횟수 : "+ counter);
		

	}

}
