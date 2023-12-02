package ch14_람다와스트림;

/**
 * @author HEEMIN
 * @date 2023. 12. 2.-오후 1:52:44
 *	@subject 람다와 스트림 - mapToInt() 사용 (중간 연산)  
 * @content  기본형 스트림(Intream , LongStream 등) 은 통계정보와 관련된 유용한 메서드를 제공한다 


 */

import java.util.* ; 
import java.util.stream.* ; 

public class StreamEx03_mapToInt {

	public static void main(String[] args) {
		
		Student[] stuArr = {
				new Student("이자바" , 3 , 300), 
				new Student("김자바" , 1 , 200), 
				new Student("안자바" , 2 , 100), 
				new Student("박자바" , 2 , 150), 
				new Student("소자바" , 1 , 200), 
				new Student("나자바" , 3 , 290), 
				
		} ; 
		
		Stream<Student> stuStream = Stream.of(stuArr) ; 
		
		stuStream.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
		
		stuStream = Stream.of(stuArr) ; 
		IntStream stuScoreStream = stuStream.mapToInt(Student :: getTotalScore) ; // 학생 스트림의 각 요소에 Student 클래스의 getTotalScore을 각각 적용하셔 반환한 값을로 IntStream을 생성  
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics() ; 
		System.out.println("count=" + stat.getCount()) ; 
		System.out.println("sum="+stat.getSum() ); 
		System.out.printf("average = %.2f%n", stat.getAverage() ) ; 
		System.out.println("min= "+ stat.getMin()) ; 
		System.out.println("max = " + stat.getMax()) ; 
	
	} // main 
} // class 
