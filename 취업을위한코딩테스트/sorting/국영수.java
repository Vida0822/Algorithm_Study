package sorting;
import java.util.*; 

class StudentScore implements Comparable<StudentScore>{
    String name ; 
    int kor ; 
    int eng ; 
    int math ; 
    
    public StudentScore(String name, int kor, int eng, int math){
        this.name = name ; 
        this.kor = kor ; 
        this.eng = eng ; 
        this.math = math ; 
    }
    @Override 
    public int compareTo(StudentScore other){ // 객체 정렬 기준 구현은 'compareTo()' 
        // 구조 암기
        if(this.kor != other.kor)
            return other.kor - this.kor ; 
        if(this.eng != other.eng)
            return Integer.compare(this.eng, other.eng) ; // 기본형 정렬 기준 주현은 'compare()'
        if(this.math != other.math)
           return other.math - this.math ; 
        return this.name.compareTo(other.name) ; 
    }
}

class 국영수{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    int N = sc.nextInt()  ;
    
    PriorityQueue<StudentScore> pq = new PriorityQueue<>() ; 
    for(int i = 0 ; i < N ; i++){
        String name = sc.next(); 
        int kor = sc.nextInt() ; 
        int eng = sc.nextInt() ; 
        int math = sc.nextInt() ; 
        
        pq.offer(new StudentScore(name, kor, eng, math)) ; 
    }
    while(!pq.isEmpty())
        System.out.println(pq.poll().name) ; 
    }
}