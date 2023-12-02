package ch14_람다와스트림;

import java.util.stream.Stream;
import java.util.* ; 

/**
 * @author HEEMIN
 * @date 2023. 12. 2.-오후 2:02:24
 *	@subject 람다와 스트림 - flat() 사용 (중간 연산) 
 * @content 


 */
public class StreamEx04_flatMap {

	public static void main(String[] args) {

		/*
		 * 예제 1) 
		 */
		Stream<String[]> strArrStrm = Stream.of( // 배열을 요소값으로 갖는 스트림 
				new String[] {"abc", "def", "jki"}, 
				new String[] {"ABC", "DEF", "JKI"} 
				) ; 
		
//		Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream) ; // String배열 스트림의 요소인 각각의 배열에 대해 Arrays 클래스의 stream 함수를 적용해 반환 받은 값을 스트림의 요소로 매핑  
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream) ;
		
		strStrm.map(String::toLowerCase)
				.distinct()
				.sorted()
				.forEach(System.out::println);
		
		
		/*
		 * 예제 2) 
		 */
		String[] lineArr = {
				"Believe or not Ot is true" , 
				"Do or do not There is no try", 
		} ; 
		Stream<String> lineStream = Arrays.stream(lineArr) ;  // 배열 lineArr의 각 요소를 갖는 스트림을 생성 
		lineStream.flatMap(line -> Stream.of(line.split(" +"))) // +는 하나 이상의 공백을 의미 --> 하나 이상의 공백을 기준으로 분할 
						.map(String::toLowerCase)
						.distinct()
						.sorted()
						.forEach(System.out::println);
		System.out.println(); 
		
		
		/*
		 * 예제 3) 
		 */
		Stream<String> strStrm1 = Stream.of("AAA" , "ABC", "bBb", "Dd") ; 
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd") ; 
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2) ;  // 스트림 두개를 요소로 갖는 스트림 생성 
		Stream<String> strStream = strStrmStrm.map(s-> s.toArray(String[]::new )) //각각의 스트림을 String 배열로 변환 
																		.flatMap(Arrays::stream) ;  // String 배열 각각을 풀어해쳐서 Stream 함수 적용 (요소값 각각이 String 인 Stream 생성 ) 
		strStream.map(String::toLowerCase)
					.distinct()
					.forEach(System.out::println);
	} // main 
} // class 
