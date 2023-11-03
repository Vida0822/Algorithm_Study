package MapAndSet;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
// import java.security.KeyStore.Entry;
import java.util.Map.Entry; 
// The import java.util.Map.Entry collides with another import statement
/* 
 * 다른 패키지에 있는 같은 이름의 class를 호출해야하는 경우 생기는 에러 
 * 해결방법 
 * 1) static으로 변수화 시켜 호출
 * 2) 풀패키지 네임을 다 써서 활용  : 적게 사용하는 패키지를 작성 
 */
/**
 * @author HEEMIN
 * @date 2023. 11. 2.-오전 8:21:11
 *	@subject TreeMap Basic
 * @content 


 */
public class TreeMapCRUD {
	
	public static int n ; 
	public static TreeMap<Integer, Integer> m =  new TreeMap<Integer, Integer>() ; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		n  = sc.nextInt() ; 
		
		for (int i = 0; i < n; i++) {
			String command = sc.next(); 
			
			if(command.equals("add")) {
				int k  = sc.nextInt() ; 
				int v = sc.nextInt(); 
				m.put(k, v) ; 
			} else if(command.equals("find")) {
				int k = sc.nextInt(); 
				m.remove(k) ; 
			}else if(command.equals("find")) {
				int k = sc.nextInt(); 
				if(!m.containsKey(k))
					System.out.println("None");
				else
					System.out.println(m.get(k));
			}else {
				if(m.isEmpty()) {
					System.out.println("None");
					continue ; 
				}
				Iterator<Entry<Integer, Integer>> it  = m.entrySet().iterator() ; 
				while(it.hasNext()) {
					Entry<Integer, Integer> entry = it.next(); 
					System.out.print(entry.getValue()+" ");
				}
				System.out.println();
			}	
		} // for 
		
		
		
		

	} // main 

} // class 
