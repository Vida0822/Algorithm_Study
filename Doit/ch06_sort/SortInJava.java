package ch06_sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author HEEMIN
 * @date 2023. 11. 5.-오후 4:33:32
 *	@subject
 * @content 
	정렬은 가장 기본적인 알고리즘이기 때문에 사실상 모든 프로그래밍 언어는 라이브러리를 제공한다 

 */

public class SortInJava {
		
	public static void main(String[] args) {
			
		 Fruit[] fruits = new Fruit[10] ; 
		 Arrays.sort(fruits , Fruit.nameComparator ); 
		 // 만들어준 비교기(정렬 기준)를 정렬할 배열과 함께 넘겨준다 
		 // --> 이 배열의 객체들을 정렬할 때 이 비교기의 'compareTo()' 메서드를 활용해서 정렬한다 
		 Arrays.sort(fruits , Fruit.quantComparator ); // 'generic programming' 
		 // 일반적으로 이 Comparator의 정의는 그 클래스 안에 static member로 가지고 있는것이 적합하다 ! 
	}
} 

