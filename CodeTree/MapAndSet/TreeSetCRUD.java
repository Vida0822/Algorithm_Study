package MapAndSet;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author HEEMIN
 * @date 2023. 11. 2.-오후 8:36:20
 *	@subject TreeSet 
 * @content TreeSet Basic 


 */
public class TreeSetCRUD {
	
	public static int n ; 
	public static TreeSet<Integer> s = new TreeSet<Integer>() ;  // treeMap 사용 : V 값으로 더미객체 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt() ; 
		
		for (int i = 0; i < n ;  i++) {
			String command = sc.next() ; 
			int x ; 
			
			if(command.equals("add")) {
				x = sc.nextInt(); 
				s.add(x)  ; 
			}else if(command.equals("remove")) {
				x = sc.nextInt(); 
				sc.remove(); 
			}else if(command.equals("find")) {
				x = sc.nextInt() ; 
				if(s.contains(x))
					System.out.println("true");
				else
					System.out.println("false");
			}else if(command.equals("lower_bound")) {
				x = sc.nextInt(); 
				if(s.floor(x) != null)
					System.out.println(s.floor(x));
				else
					System.out.println("None");
			}else if(command.equals("upper_bound")) {
				x = sc.nextInt() ; 
				if(s.higher(x)!= null)
					System.out.println(s.higher(x));
				else
					System.out.println("None");
			}else if(command.equals("largest")) {
				if(!s.isEmpty())
					System.out.println(s.last());
				else
					System.out.println("None");
			}else if(command.equals("smallest")) {
				if(!s.isEmpty())
					System.out.println(s.first());
				else
					System.out.println("None");
			} // if 
		} // for 
	} // main 
} // class 
