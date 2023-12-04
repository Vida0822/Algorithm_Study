package ch14_람다와스트림;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author HEEMIN
 * @date 2023. 12. 4.-오후 10:07:05
 *	@subject 스트림 - 최종연산 
 * @content 
	스트림의 최종연산 : 스트림의 요소를 소모해 결과를 생성하는 연산이다.

 */
public class StreamEx05_최종연산 {

	public static void main(String[] args) {
		String[] strArr = { 
				"Inheritance", "Java", " Lambda", "stream",
				"OptionalDouble","IntStream", "count", "sum"
		} ; 
		Stream.of(strArr).forEach(System.out::println);
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length() == 0 ) ; // 스트림의 각 요소를 검사하면서 조건식에 만족하는 요소가 하나도 없으면 true를 bool Stream에 쌓음
		System.out.println("noEmptyStr="+ noEmptyStr); // true 
		
		Optional<String> sWord = Stream.of(strArr).filter(s->s.charAt(0) == 's').findFirst() ; 
		System.out.println("sWord = " + sWord.get()); // stream 
		
		
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length) ; // 각 String의 길이를 요소로 갖는 IntStream 
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length) ; // 각 String의 길이를 요소로 갖는 IntStream 
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length) ; // 각 String의 길이를 요소로 갖는 IntStream 
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length) ; // 각 String의 길이를 요소로 갖는 IntStream
		
		int count = intStream1.reduce(0, (a,b) -> a+1) ; // 스트림의 요소를 하나씩 얻어와 b에 담고, 람다식 (a,b)를 적용한 값을 a에 대입 -> 다음 스트림 요소를 b에 담아오고, 람다식 (a,b)를 적용한 값을 a에 대입 
		int sum = intStream2.reduce(0, (a,b) -> a+b) ; 
		OptionalInt max = intStream3.reduce(Integer::max) ; 
		OptionalInt min = intStream4.reduce(Integer::min) ; 
		
		System.out.println("count = "+ count);
		System.out.println("sum = "+ sum);
		System.out.println("max = "+ max.getAsInt());
		System.out.println("min = "+ min.getAsInt());
		

	}

}
