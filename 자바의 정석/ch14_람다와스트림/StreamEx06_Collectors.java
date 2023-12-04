package ch14_람다와스트림;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HEEMIN
 * @date 2023. 12. 4.-오후 10:20:58
 *	@subject 스트림 최종연산 - collect() 
 * @content  미리 만들어둔 Collectors 클래스로 수집 방법을 지정하자 
1. 컬렉션으로 변환 

 */
public class StreamEx06_Collectors {

	public static void main(String[] args) {
			
		/*
		 * 1) List로 변환 
		 */
		Student[] stuArr = {
				new Student("이자바" , 3 , 300), 
				new Student("김자바" , 1 , 200), 
				new Student("안자바" , 2 , 100), 
				new Student("박자바" , 2 , 150), 
				new Student("소자바" , 1 , 200), 
				new Student("나자바" , 3 , 290), 		
		} ; 
	
		// 학생 이름만 뽑아서 List<String>에 저장 
		List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList()) ; 
		System.out.println(names);
		
		/*
		 * 2) Map으로 변환 
		 */
		Student[] stuArr2 = Stream.of(stuArr) // Array --> Stream 
							.toArray(Student[]::new);  // Stream --> Array 

		for(Student s : stuArr)
			System.out.println(s);
		
		// 스트림을 Map<String, Student>로 변환. 학생 이름이 key 
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s->s.getName(), p->p)); 
		
		for(String name : stuMap.keySet())
			System.out.println(name+"-"+stuMap.get(name));
		
		/*
		 * 3) 통계 정보 
		 */
		long count = Stream.of(stuArr).collect(Collectors.counting()); 
		long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(Student::getTotalScore)) ;
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);
		
		totalScore = Stream.of(stuArr).collect(Collectors.reducing(0, Student::getTotalScore , Integer::sum)) ; // identity, Function mapper , BinaryOperator
		System.out.println("totalScore = "+totalScore  );
		
		Optional<Student> topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore))); 
		System.out.println("topStudent = "+ topStudent.get()); //  [이자바, 3 , 300]

		IntSummaryStatistics stat = Stream.of(stuArr).collect(Collectors.summarizingInt(Student::getTotalScore)); 
		System.out.println("stat=" + stat); // IntSummaryStatistics{count=6, sum=1240, min=100, average=206.666667, max=300}
		
		/*
		 * 4) joining 
		 */
		String stuNames = Stream.of(stuArr).map(Student::getName).collect(Collectors.joining(",", "{", "}")) ; 
		System.out.println("stuNames=" + stuNames); // {이자바,김자바,안자바,박자바,소자바,나자바}
				
	}
}
