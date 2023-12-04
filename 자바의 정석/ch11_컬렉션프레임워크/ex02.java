package ch11_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HEEMIN
 * @date 2023. 9. 5.-오전 11:02:47
 *	@subject ArrayList 
 * @content  ArrayList를 활용해 문자열 데이터 자르기 
 */

public class ex02 {

	public static void main(String[] args) {

		final int LIMIT = 10; 

		String source = "0123456789abcdefgh1jkpp" ;  // 23
		int length = source.length(); // 총 글자길이 

		List list = new ArrayList(length/LIMIT+LIMIT) ;  // * 올림로직! 	총글자길이/자를 개수 + 자를 개수 =>  크기를 약간 여유있게 잡기 위함 

		for(int i=0; i<length; i+=LIMIT) {  // (1) i=0  , (2) i = 10 (3) i=20 
			if(i+LIMIT < length) {  // 10 , 20 , 30 
				list.add(source.substring(i,i+LIMIT)) ;   // (1) 0, 10 잘라서 -> list1  , (2) 11~20 잘라서 -> list 2 
				
			}else { // (3) i = 20
				list.add(source.substring(i)) ; 
				// int subLen = length() = 23 : 문자열 총 길이(끝까지) - beginIndex(i=20) : 자를 차례 
				// ==> 20번째에서 끝까지 <-> 남은거 자르는 함수 
			} //if else 
		}//for 
		
		for (int i = 0; i < list.size(); i++) { // size() = 3 
			System.out.println(list.get(i));
		} // for 
	}
} // ex02
