package cH2_기본자료구조;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 8:42:57
 *	@subject  배열 
 * @content  배열의 특성 


 */
public class ex01 {

	public static void main(String[] args) {
		
		int [] a = new int[5]; 
		
		a[1] = 37; 
		a[2] = 51 ; 
		a[4] = a[1] *2 ; 
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a["+i+"]="+a[i]);
	
		} // for 
	} // main 

}
