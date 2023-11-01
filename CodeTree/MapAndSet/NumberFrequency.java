package MapAndSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 11. 1.-오전 7:45:41
 *	@subject HashMap 
 * @content 해당 요소들 중 숫자가 몇번 등장하는지 

 */
public class NumberFrequency {
	
	public static int m ; 
	public static int n ;
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>() ; 
	

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in) ; 
		n = sc.nextInt(); 
		m = sc.nextInt();
		
		// part 1. map 만들기 
		for (int i = 0; i < n; i++) {
			int key = sc.nextInt() ; 
			
			if(map.containsKey(key)) { // <숫자, 등장횟수> 
				map.put(key, map.get(key) + 1) ; 
			} else {
				map.put(key, 1) ; 
			}
		} // for 
		
		
		// part 2. 질의 하기 
		for (int i = 1 ; i <= m; i++) {
			int key = sc.nextInt() ; 
			
			System.out.print(map.getOrDefault(key, 0 ) );
			System.out.println(" ");
			
		}
		
		

	} // main  
} // class
