package ch14_람다와스트림;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author HEEMIN
 * @date 2023. 12. 5.-오전 11:53:57
 *	@subject  스트림 최종연산 -  groupingBy()
 * @content 


 */
public class StreamEx08_groupingBy {

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
		 * 1) 단순 그룹화 : 반별 
		 */
		Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student::getBan)) ; 
		for(List<Student> ban : stuByBan.values()) {
			for(Student s : ban) {
				System.out.println(s);
			}
		}


		/*
		 * 2) 단순 그룹화 : 성적별 
		 */
		Map<Student.Level, List<Student>> stuByLevel  // 레벨별 학생 그룹 
		= Stream.of(stuArr)
		.collect(Collectors.groupingBy(	s ->{ // s : 스트림의 요소인 Student (요소를 하나씩 검사하면서)  
			if(s.getTotalScore() >= 200) return Student.Level.HIGH ;  // 그 학생의 총점이 200점이 넘으면 High 그룹 
			else if(s.getTotalScore() >= 100) return Student.Level.MID ; // MID 그룹
			else		return Student.Level.LOW ; // Low 그룹 
		})) ;  

		TreeSet<Student.Level> keySet = new TreeSet<Student.Level>(stuByLevel.keySet()); // 레벨별 학생 그룹에서 키들(레벨들)만 가져와서 TreeSet에 넣어둠 (3개의 요소가 들어감) 

		for(Student.Level key : keySet) { // 레벨을 순회 
			System.out.println("["+key+"]");

			for(Student s : stuByLevel.get(key)) // 레벨별 학생 List에서 학생들을 하나씩 꺼내서 출력 
				System.out.println(s); 
			System.out.println();
		}


		/*
		 * 3) 단순 그룹 + 통계 (성적별 학생수) 
		 */
		Map<Student.Level, Long> stuCntByLevel 
		= Stream.of(stuArr) // 학생들을 요소로 갖는 스트림 
		.collect(Collectors.groupingBy(s->{
			if(s.getTotalScore() >= 200) return Student.Level.HIGH ; 
			else if(s.getTotalScore() >= 100) return Student.Level.MID ;
			else	return Student.Level.LOW ; 
		}, Collectors.counting())) ; 

		for(Student.Level key : stuCntByLevel.keySet())
			System.out.printf("[%s] - %d명, " ,key, stuCntByLevel.get(key)); 
		System.out.println();

		for(List<Student> level: stuByLevel.values()) { // 레벨별 학생 - 리스트 3개 --> 리스트 하나씩 꺼내와서 
			System.out.println(); 
			for(Student s : level) { // 학생들 출력 
				System.out.println(s);
			}
		}

		/*
		 * 4) 다중 그룹화 (학년별, 반별) 
		 */
		Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = 
				Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student::getHak, 
						Collectors.groupingBy(Student::getBan))) ; 

		for(Map<Integer, List<Student>> hak : stuByHakAndBan.values()) { // 학년별 <반,  학생List> 뽑아서 
			for(List<Student> ban : hak.values()) { // 반별 학생 리스트를 뽑아서 
				System.out.println();
				for(Student s: ban) // 그 학생 리스트를 출력 
					System.out.println(s); 
			}
		}

		/*
		 * 5) 다중 그룹화(학년별, 반별) + 통계 (1등) 
		 */
		Map<Integer, Map<Integer, Student>> topStuByHakAndBan = 
				Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student::getHak, 
						Collectors.groupingBy(Student::getBan,
								Collectors.collectingAndThen( // 수집후에는 
										Collectors.maxBy(Comparator.comparingInt(Student::getTotalScore)) // 또다른 수집... max 
										, Optional::get
										)
								)
						)) ; 
		for(Map<Integer, Student> ban : topStuByHakAndBan.values())
			for(Student s : ban.values())
				System.out.println(s); 

		/*
		 * 6) 다중 그룹화 (학년별, 반별 성적그룹) 
		 */
		Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s -> s.getHak() +"-"+s.getBan(), 
						Collectors.mapping(s->{
							if(s.getTotalScore() >= 200) return Student.Level.HIGH ; 
							else if(s.getTotalScore() >= 100) return Student.Level.MID ;
							else	return Student.Level.LOW ; 
						}, Collectors.toSet())
					));
		Set<String> keySet2 = stuByScoreGroup.keySet() ; 
		
		for(String key : keySet2) {
			System.out.println("["+key+"]"+stuByScoreGroup.get(key));
		}



	}

}
