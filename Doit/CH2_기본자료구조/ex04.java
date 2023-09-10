package CH2_기본자료구조;

import java.util.Random;
import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 10.-오후 9:08:10
 *	@subject 배열 
 * @content 난수로 배열 채우기 


 */
public class ex04 {
	
	static int maxOf(int[] a) {
		
		int max = a[0] ; 
		
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max)
				max=a[i] ; 
		}
		return max ; 
	} // maxOf
	
	public static void main(String[] args) {
		
		Random random = new Random() ; 
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = sc.nextInt() ; 
		
		int[] height = new int[num]; 
		
		System.out.println("킷값은 아래와 같습니다.");
		for (int i = 0; i < num; i++) {
			height[i] = 100+random.nextInt(90);  // new Random().nextInt(n) --> 0부터 n-1 사이의 난수 
			System.out.println("height["+i+"]:" + height[i]);
		} // for 
		
		System.out.println("최댓값은 "+maxOf(height)+"입니다. ");
	
	} // main 
 }
