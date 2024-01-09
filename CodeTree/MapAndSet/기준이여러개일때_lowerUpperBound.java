package MapAndSet;

import java.util.TreeSet;

/**
 * @author HEEMIN
 * @date 2024. 1. 9.-오전 8:24:30
 *	@subject TreeSet - 기준이 여러개일 때의 Lower, Upper Bound 
 * @content 
 - 새로운 정렬기준을 만들땐 comparable interface를 객체 속 직접 구현한다
 - '비교 가능한' (정렬가능한) 객체를 E로 넣어준다 

 */
class Pair implements Comparable<Pair>{
	int height , weight ; 
	
	public Pair(int height, int weight) {
		this.height = height ; 
		this.weight = weight ; 
	}
	@Override
	public int compareTo(Pair p) {
		if(this.height != p.height) // 키가 한쪽이 큰 경우, 작은 경우
			return this.height - p.height ; 
		else  // 키가 같은 경우 
			return this.weight - p.weight ; 
		// 몸무게가 적은 사람이 앞에 옴 
		// 내가 몸무게가 더 작으면, 음수 나옴 --> 앞에 옴 , 내가 몸무게가 더 크면, 양수 나옴 --> 뒤에 옴 
	}
	
	@Override
	public String toString() {
		return this.height + " "+ this.weight ; 
	}
}

public class 기준이여러개일때_lowerUpperBound {

	public static void main(String[] args) {
		TreeSet<Pair> s = new TreeSet<>() ; 
		
		s.add(new Pair(170,60)) ; 
		s.add(new Pair(160, 55)) ; 
		s.add(new Pair(180, 82)) ; 
		s.add(new Pair(185, 77)) ; 
		s.add(new Pair(170, 30)) ; 
		
		Pair bestPerson = s.ceiling(new Pair(165, 50)) ; 
		System.out.println(bestPerson) ; 

	}

}
