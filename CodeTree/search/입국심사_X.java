package search;

import java.util.Arrays;

public class 입국심사_X {
	public long solution(int n, int[] times) {
        
		long answer = 0;
        
		Arrays.sort(times);

		int[] checking = new int[times.length] ; 
		for (int i = 1; i <= n ; i++) {
			checking[i] = 1 ; 
		} 
		if(n < times.length) {
			answer = times[n] ; 
		}else {
			answer = times[times.length -1] ; 
		}
        
        
        while(n>= 0) {
        	answer ++ ; 
        	
        	int emptyIndex = Arrays.binarySearch(checking, 0) ; 
        	int checkingIndex = Arrays.binarySearch(checking, 1) ; 
        	
        	
        	
        	
        } // while 

        
        
        return answer;
    }
}
