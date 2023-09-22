package cH2_기본자료구조;

/**
 * @author HEEMIN
 * @date 2023. 9. 11.-오후 5:18:22
 *	@subject 배열 
 * @content  확장 for 문 --> index 값이 필요하지 않음 


 */
public class c_2 {

	public static void main(String[] args) {
		
		double[] a = {1.0, 2.0,3.0,4.0,5.0,} ; 
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a["+i+"]= "+a[i]);
		} // for 
		
		double sum = 0 ; 
		
		for (double i : a) { // : - ~의 안에있는 (in)    ---> a in i , a 안에 있는 i  (를 처음부터 끝까지 모든 요소를 다 스캔한다) 
			sum += i ;  
		} // for 
		
		System.out.println("모든 요소의 합은 "+ sum + "입니다. ");

	} // main 
} // class 
