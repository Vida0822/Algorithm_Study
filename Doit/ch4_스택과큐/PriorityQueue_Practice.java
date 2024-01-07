package ch4_스택과큐;

import java.util.Comparator;
import java.util.PriorityQueue; 

/**
 * @author HEEMIN
 * @date 2024. 1. 7.-오전 11:05:47
 *	@subject 우선순위 큐 
 * @content 우선순위가 가장 높은 데이터에만 관심이 있고 얘만 연산대상이 됨
 - heap 로직을 사용한 우선순위 큐 --> java.util.PriorityQueue
 - method : add(E), size(), isEmpty(), peek() - 삭제 x , poll() - 삭제 o  

 */
public class PriorityQueue_Practice {

	public static void main(String[] args) {
		
		/*
		 * 1) 트릭으로 우선순위 변경 
		 */
		// default : 최솟값을 높은 우선순위로 잡는다 
		// => 간단히 최댓값을 우선순위로 뽑으려면 트릭 사용 가능 : 실제값에 -를 붙여서 최댓값을 최소값을 만듬 
		// 반환할 때 다시 - 를 붙여서 원래의 데이터로 반환 
	
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		pq.add(-2) ; 
		pq.add(-9) ; 
		pq.add(-5) ; 
		
		System.out.println(pq.peek());  
		System.out.println(-pq.peek()); 
		// but 이렇게 보단 생성자에 Comparator 를 넣어주는게 better : public PriorityQueue(Comparator<? super E> comparator) 

	
		/*
		 * 2) 비교기로 우선순위 변경
		 */
		PriorityQueue<Integer> pq1 
		= new PriorityQueue<>(Comparator.naturalOrder()) ; 
		// 큐 안에서 오름차순으로 정렬되어 있다 <-> 맨앞에 있는 최솟값이 제일 먼저 빠지므로 우선순위가 가장 높다 
		PriorityQueue<Integer> pq2 
		= new PriorityQueue<>(Comparator.reverseOrder()) ;
		// 큐 안에서 내림차순으로 정렬되어있다 <-> 맨 앞에 있는 최댓값이 제일 먼저 빠지므로 우선순위가 가장 높다  
		
		pq1.add(2);
		pq1.add(10);
		pq1.add(102);
		
		pq2.add(3);
		pq2.add(40); 
		pq2.add(59) ; 
		
		System.out.println(pq1.poll()); // 2   
		System.out.println(pq2.poll()); // 59 
		
	}
}