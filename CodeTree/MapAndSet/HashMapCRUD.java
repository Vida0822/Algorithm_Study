package MapAndSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 11. 1.-오전 7:25:11
 *	@subject  Hash Table에서 데이터를 다뤄보자 
 * @content 


 */
public class HashMapCRUD {
	
	public static int n ; 
	public static HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(); 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt(); 
		
		for (int i = 0; i < args.length; i++) {
			String command = sc.next() ; 
			
			if(command.equals("add")) {
				int k = sc.nextInt() ; 
				int v =  sc.nextInt() ; 
				m.put(k, v) ; 
			}else if(command.equals("remove")) {
				int k = sc.nextInt() ; 
				m.remove(k);  
			}else {
				int k = sc.nextInt() ; 
				if(!m.containsKey(k))
					System.out.println("None");
				else
					System.out.println(m.get(k));
			}
			
		}

	}

}
