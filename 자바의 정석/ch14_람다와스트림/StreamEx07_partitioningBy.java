package ch14_람다와스트림;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HEEMIN
 * @date 2023. 12. 5.-오전 11:54:03
 *	@subject  스트림 최종연산 -  partitioningBy()
 * @content 


 */
public class StreamEx07_partitioningBy {

	public static void main(String[] args) {
		
		Student[] stuArr = {
				new Student("나자바" ,true, 1,  3 , 300), 
				new Student("김지미" , false, 1, 1 , 250), 
				new Student("김자바" , false, 1, 1 , 200), 
				new Student("안자바" , true, 1, 2 , 100), 
				new Student("박자바" , false , 1 , 2 , 150), 
				new Student("소자바" , true, 1, 1 , 200), 
				new Student("나자바" , false , 1 , 3 , 290), 		
				
				new Student("나자바" ,true, 2,  3 , 300), 
				new Student("김지미" , false, 2, 1 , 250), 
				new Student("김자바" , false, 2, 1 , 200), 
				new Student("안자바" , true, 2, 2 , 100), 
				new Student("박자바" , false , 2 , 2 , 150), 
				new Student("소자바" , true, 2, 1 , 200), 
				new Student("나자바" , false , 2 , 3 , 290), 		
		} ; 
		/*
		 * 1) 단순분할 (성별로 분할) 
		 */
		Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr) // 배열로 스트림을 만들고 
																		.collect(Collectors.partitioningBy(Student::isMale)) ; 
		// 각 배열 요소에 isMale()을 적용해 그 값(true/false)를 기준으로 요소들을 모음 
		// 조건식(Predicate) : 결과값으로 true/false가 반환되는 식 
		List<Student> maleStudent = stuBySex.get(true) ; 
		List<Student> femaleStudent = stuBySex.get(false) ;
		
		// for(element variable : iterable elements ) --> iterable elements 에서 하나씩 꺼내서 variable을 꺼냄 
		for(Student s : maleStudent) 	System.out.println(s); // toString()
		for(Student s : femaleStudent) 	System.out.println(s);
		
		/*
		 * 2) 단순분할 + 통계 (학생 수) 
		 */
		Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(Collectors.partitioningBy(Student::isMale,  Collectors.counting())) ;   // Predicate, Collector(각 그룹별로 모아서 어떤 작업을 수행?) 

		System.out.println("남학생 수 :" + stuNumBySex.get(true));
		System.out.println("여학생 수 :" + stuNumBySex.get(false));
		
		/*
		 * 3) 단순분할 + 통계(성별 1등) 
		 */
		Map<Boolean, Student> topScoreBySex2 = Stream.of(stuArr)
														.collect(Collectors.partitioningBy(Student::isMale, 
																Collectors.collectingAndThen(
																		Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)), Optional::get
																		)
																)) ; 
		System.out.println("남학생 1등 : "+topScoreBySex2.get(true));
		System.out.println("여학생 1등 : "+topScoreBySex2.get(false));
		
		
		/*
		 * 4) 다중 분할 (100점 이하) 
		 */
		Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = Stream.of(stuArr)
																						.collect(Collectors.partitioningBy(Student::isMale, 
																								Collectors.partitioningBy(s->s.getTotalScore() <= 100))); // 100점을 넘지 못한 그룹과(true), 100점을 넘은 그룹(false) 
		
		List<Student> failedMaleStu = failedStuBySex.get(true).get(true) ; 
		List<Student> failedFemaleStu = failedStuBySex.get(false).get(true) ; 
		
		for(Student s : failedMaleStu) System.out.println(s );
		for(Student s : failedFemaleStu) System.out.println(s );
	
		

	}

}
