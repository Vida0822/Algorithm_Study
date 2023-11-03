package MapAndSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

/**
 * @author HEEMIN
 * @date 2023. 11. 1.-오전 9:20:01
 *	@subject HashSet 
 * @content  데이터가 일치하는지 비교 


 */
public class DataComparision {

	public static int n ,  m ; 
		
	public static HashSet<Integer> h1 = new HashSet<Integer>() ; 
    public static HashSet<Integer> h2 = new HashSet<Integer>() ; 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 

		n = sc.nextInt() ; 
		int[] arr1 = new int[n] ;  
				
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt() ; 
			h1.add(arr1[i]) ; 
		}
		
		m = sc.nextInt() ; 
		int[] arr2 = new int[m] ; 
		
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt()  ; 
			h2.add(arr2[i]) ; 
		}
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print( (h1.contains(arr2[i])? 1 : 0) + " "); 
		}
	} // main 
} // class 
