package ch4_스택과큐;

import java.util.* ; 

/**
 * @author HEEMIN
 * @date 2024. 1. 7.-오후 12:22:08
 *	@subject 우선순위 큐 - custom Comparator 를 활용해서 우선순위 부여하기 
 * @content 
우선순위 큐에 '객체'를 넣을 때, 어떤 기준으로 정렬, 즉 우선순위를 부여할지는 직접 Comparator를 구현해야한다
(물론 이문제에선 정수형 우선순위 큐를 만들어 입력받은 점 x, y를 넣어주는 방법도 있겠지만, 이러면 원래 쌍을 다시 가져올 수 없다
좀 더 객체 지향적 프로그래밍에서는 (x,y) 쌍을 객체로 묶어 한번에 넣어주고 특정기준으로 정렬하게끔하는게 나은 코드 
(그러면 실제 값을 가져올 수 도 있으니) 
 */

class Pair implements Comparable<Pair>{
	// "곱이 최대가 되는 경우를 원하기 때문에, 이 곱이 우리가 원하는 우선순위에 들어가야합니다" 
	
	int x, y ; 
	
	public Pair(int x, int y) {
		this.x = x; 
		this.y = y ; 
	}
	
	@Override
	public int compareTo(Pair p) { // x*y 기준 내림차순 
		/*
		 * !! 암기 !! 현재 객체(this) vs 함수로 넘어온 객체 
		 - 현재객체가 정렬기준 더 뒤에 나와야하면 0보다 큰 값 반화 
		 - 현재 객체가 정렬기준 더 앞에 나와야하면 0보다 작은 값 반환 
		 - 현재 객체가 정렬기준 상 넘어온 객체와 동일하다면 값 0 반환 
		 */
		
		//return p.x * p.y - this.x*this.y ; (
		if(this.x * this.y > p.x * p.y) {
			// 1. 내가 더 큼 --> 2. 내림차순이니까...그럼 앞에 나와야함 
			return -1 ; // 	ㄴ> 3. 0보다 작은 값 반환 
		}else if(this.x * this.y < p.x * p.y) {
			// 1. 내가 더 작음 --> 2. 내림차순이니까... 그럼 뒤에 나와야함 
			return 1 ; // 		ㄴ 3. 0보다 큰 값 반환 
		}else {
			return 0 ;
		}
		// => return p.x * p.y - this.x*this.y  
		// 'this'만 기준으로 보자 : 내가 더 크면 음수반환(앞으로 밀림), 내가 더 작으면 양수 반환(뒤로 밀림) 
	}
	
	
}
public class CustomComparator활용 {

	public static void main(String[] args) {
		Pair[] points = new Pair[] {
				new Pair(1,7), new Pair(3,2), new Pair(3,1) , new Pair(6,2) 
		} ; 
		int n = 4 ; 
		
		PriorityQueue<Pair> pq = new PriorityQueue<>() ; // Comparator 여기서 안넣어줘도 된다 : 객체 안에 이미 구현되어있기 때문
		
		for(int i = 0  ; i <n ; i++) {
			pq.add(points[i]) ; 
			Pair bestP = pq.peek() ; 
			System.out.println(bestP.x + " " + bestP.y);
		}

	}

}
