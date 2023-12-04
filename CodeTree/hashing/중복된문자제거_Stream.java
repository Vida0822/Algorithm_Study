package hashing;
import java.util.* ; 
import java.util.stream.*; 
 
public class 중복된문자제거_Stream {
	
	public String solution(String my_string) {
		return my_string.chars() // String의 각 문자의 아스키 코드 값을 요소로 가지는 IntStream 반환 
				.mapToObj(Character::toString)
				/* Character 클래스의 toString으로 해당 아스키 코드 값들을 각각 문자열로 변환  
					=> 각 문자가 요소값인 String 스트림 생성 
					※ 바로 저 String을 Stream으로 변환하지 않은 이유 
						: 문자 단위로 분리되는게 아니라 저 String 자체가 하나의 요소값이 됨
						==> 문자단위로 먼저 잘라 그걸 요소값으로 갖는 스트림을 만들고  - chars() 
								그걸 각각 문자열로 변환해줘야함 
				*/
				.distinct()  // 중복된 문자 제거 
				.collect(Collectors.joining()) ; // 스트림의 요소들을 다 연결해 하나의 문자열 반환 
	}

}
