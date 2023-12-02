package ch14_람다와스트림;

import java.io.* ; 
import java.util.stream.* ; 

/**
 * @author HEEMIN
 * @date 2023. 12. 2.-오후 1:52:02
 *	@subject 람다와 스트림  - map()의 사용 (중간 연산)  
 * @content 


 */
public class StreamEx02_map {

	public static void main(String[] args) {
		
		File[] fileArr = {
				new File("ex1.java") , //  public File(String pathname) {} 
				new File("ex1.bak") , 
				new File("ex2.java") , 
				new File("ex1") , 
				new File("ex1.txt") , 		
		} ; 
		Stream<File> fileStream = Stream.of(fileArr) ; 
		
		// map()으로 Stream<File>을 Stream<String>으로 변환 
		Stream<String> filenameStream = fileStream.map(File::getName);  // 스트림의 각 요소에 File 클래스의 getName 메서드를 각각 적용하여 나온 요소들로 mapping해서 새로운 String 스트림으로 변환 
		filenameStream.forEach(System.out::println) ; // 모든 파일 이름을 출력 
		
		/*
		 * map(s -> s.substring(s.indexOf('.')+1 ) ) : 각 요소에 적용할 Function으로 람다식을 직접 넣어준것 
		 * map(String::toUpperCase)  : 각 요소에 적용할 Function으로 특정 클래스의 메서드를 참조해서 알려준 것 
		 */
		fileStream = Stream.of(fileArr) ; 
		fileStream.map(File::getName) // 파일 이름 String Stream 생성 
					.filter(s -> s.indexOf('.') != -1 ) // 요소를 하나씩 검사하면서확장자가 없는 파일은 요소에서 제외 
					.map(s -> s.substring(s.indexOf('.')+1 )) // 요소를 하나씩 검사하면서 확장자만 추출 
					.map(String::toUpperCase) 
					.distinct()
					.forEach(System.out::print) ; 
		System.out.println(); 
 
	} // main 
} // class 
