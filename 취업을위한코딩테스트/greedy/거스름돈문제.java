package greedy;

public class 거스름돈문제 {
	
	public static void main(String[] args) {	
		int n = 1260 ; // 손님에게 건네줘야할 거스름돈 
		int cnt = 0 ; 
		int[] coinTypes = {500, 100, 50, 10} ; 
		
		for(int coin : coinTypes) {
			cnt += n/coin ; 
			n %= coin ; 
		} // for 
		System.out.println(cnt);
	} // main
} // class 
