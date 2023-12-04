package ch14_람다와스트림;

public class Student implements Comparable<Student>{
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
	
	// grouping 기준 
	enum Level{
		HIGH, MID, LOW // 성적을 상, 중, 하 세단계로 분류 
	}
}