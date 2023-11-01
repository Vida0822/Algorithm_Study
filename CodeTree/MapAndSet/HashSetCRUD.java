package MapAndSet;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 11. 1.-오전 9:11:53
 *	@subject HashSet Basic 
 * @content 


 */
public class HashSetCRUD {

	public static int n ; 
	public static HashSet<Integer> s = new HashSet<Integer>() ; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt(); 
		
		for (int i = 0; i < n; i++) {
			String command = sc.next(); 
			
			int x = sc.nextInt() ; 
			
			if(command.equals("add")) {
				s.add(x); 
			}else if(command.equals("remove")) {
				s.remove(x) ; 
			}else {
				if(s.contains(x))
					System.out.println("true");
				else
					System.out.println("false");	
			}
		} 

	}

}
