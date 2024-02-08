package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 성적이낮은학생순 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		ArrayList<Student> students = new ArrayList<Student>(); 
	
		for(int i = 0 ; i < n ; i++) {
			String name = sc.next() ;
			int score = sc.nextInt() ; 
			students.add(new Student(name, score)) ; 
		}
		Collections.sort(students); // Collections.sort --> 내장된 비교기를 사용해 정렬함 
		//students.sort(Comparator.reverseOrder()); // ArrayList.sort --> 비교기를 매개변수로 넣어줘야함 

		for(int i = 0 ; i < students.size() ; i++) {
			System.out.println(students.get(i).getName());
		}
	} // main 
} // class 

class Student implements Comparable<Student>{
	private String name ; 
	private int score ; 
	
	public Student(String name , int score) {
		this.name = name ; 
		this.score = score ; 
	}
	
	@Override
	public int compareTo(Student other) {
		// this와 매개변수로 넘어온 other과 비교 (양수가 나오면 this가 우선, 음수가 나오면 other이 우선)
		// ==> 양수가 나오면 other이 먼저, 음수가 나오면 this가 먼저 나온다 
		if(this.score < other.score)
			return -1 ;  
		return 1 ; 
	}
	
	public String getName() {
		return this.name ; 
	}
}