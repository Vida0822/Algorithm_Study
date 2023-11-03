package MapAndSet;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author HEEMIN
 * @date 2023. 11. 2.-오전 8:35:35
 *	@subject TreeMap 
 * @content  Introduction 문제 


 */
public class FindTheRatio {
	public static int n ; 
	public static TreeMap<String, Integer> dictionary 
	= new TreeMap<String, Integer> () ; 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		n = sc.nextInt()  ; 
		
		for (int i = 1; i <= n; i++) {
			String word = sc.next(); 
			
			if(dictionary.containsKey(word)) {
				int count  = dictionary.get(word) ; 
				dictionary.replace(word, count + 1) ; 
			}else {				
				dictionary.put(word, 1);
			}
		} // for 
		
		Iterator<Entry<String, Integer>> it = dictionary.entrySet().iterator() ; 
		
		while(it.hasNext()) { 
			Entry<String, Integer> wordCount = it.next() ; 
			//String word = it.next().getKey() ; // it.next()를 할때마다 다음값으로 넘어감 !!  한번만 호출해야함 ! 
			// double ratio = (double)(it.next().getValue()) / n  * 100 ; 
			String word =wordCount.getKey() ; // it.next()를 할때마다 다음값으로 넘어감 !!  한번만 호출해야함 ! 
			double ratio = (double)(wordCount.getValue()) / n  * 100 ; 
			
			System.out.printf("%s : %.4f \n" , word, ratio);
			 
		} // while 
	} // main 
} // class 
