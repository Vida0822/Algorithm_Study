package ch14_람다와스트림;

import java.util.* ; 
import java.util.stream.* ; 


/**
 * @author HEEMIN
 * @date 2023. 12. 2.-오후 1:52:21
 *	@subject 람다와 스트림 - sorted()의 사용 (중간 연산)  
 * @content 


 */
public class StreamEx01_정렬 {
	
	public static void main(String[] args) {
		
		Stream<Student> studentStream = Stream.of(
				new Student("이자바" , 3 , 300 ) , 
				new Student("김자바", 1, 200) , 
				new Student("안자바", 2, 150 ), 
				new Student("나자바", 3, 190)
				); 
		
		studentStream.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println); // 각 요소에 대해 Sytem.out 클래스에 있는 println 메서드를 적용한다 
	} // main 
} // class

class Student implements Comparable<Student>{
	String name ; 
	int ban; 
	int totalScore ; 
	
	Student(String name, int ban , int totalScore){
		this.name = name ;
		this.ban = ban  ; 
		this.totalScore = totalScore ; 
	} // 생성자 
	
	public String toString() {
		return String.format("[%s, %d , %d]",name, ban, totalScore) ; 
	} // toString
	
	// getter 
	String getName() {
		return name ; 
	}
	int getBan() {
		return ban ; 
	}
	int getTotalScore() {
		return totalScore ; 
	}
	
	// compare 
	public int compareTo(Student s ) {
		return s.totalScore - this.totalScore; 
		// 총점 내림차순을 기본정렬로 한다 
		/* 
		 * if this.totalScore < s.totalScore --> 양수 
		 * <-> s(큰것)를 앞으로 두고 this(작은것)를 뒤로 둔다 <-> 내림차순 
		 */
	}
}


