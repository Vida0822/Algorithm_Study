package cH1_기본알고리즘;

/**
 * @author HEEMIN
 * @date 2023. 9. 9.-오후 10:49:49
 *	@subject 반복 
 * @content  구구단 출력하기 


 */
public class ex16 {

	public static void main(String[] args) {
		
		System.out.println("-----구구단 곱셈표-----") ;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j < 9; j++) {
				System.out.printf("%3d", i*j);
			}
			System.out.println();
		}		
	} // main 
}
