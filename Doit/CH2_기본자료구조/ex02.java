package ch2_기본자료구조;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 8:54:27
 *	@subject 배열 
 * @content  배열 생성과 동시에 초기화 
 */
public class ex02 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5}; 
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a["+i+"] ="+a[i]);
		}

	}

}
