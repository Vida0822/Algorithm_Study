package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 

public class 커리큘럼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		int n = sc.nextInt() ; 
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>() ; 
		int[] indegree = new int[n] ; 
		int[] times = new int[n] ; 
		
		// 그래프 만들기 
		for(int i = 0 ; i < n ; i++) {
			graph.add(new ArrayList<Integer>()) ; 
		}
		for(int i = 0 ; i < n ; i++) {
			times[i] = sc.nextInt() ; 
			int x = 0  ; 
			while( (x = sc.nextInt()) != -1 ) {
				graph.get(x-1).add(i) ; // 여기가 문제 : 지정하는 수업 번호는 자연수기 때문에 0인덱스에서 맞춰주려면 -1 해줘야함  
				indegree[i] += 1; 
			}
		}
		
		// 차수 0인것부터 큐에 넣기 
		Queue<Integer> q = new LinkedList<>() ; 
		for(int i = 0 ; i < indegree.length ; i++) {
			if(indegree[i] == 0)
				q.offer(i) ; 
		}
		
		// 큐에서 하나씩 빼면서 위상정렬 
		int[] result = Arrays.copyOf(times , n) ;
		
		while(!q.isEmpty()) {
			int lesson = q.poll() ;
	
			for(int i = 0 ; i < graph.get(lesson).size() ; i++) {
				int nextClass = graph.get(lesson).get(i) ; 
				
				result[nextClass] = Math.max(result[nextClass], result[lesson]+times[nextClass]) ; 
				// 이유 : 매번 해당 강의를 듣는데 필요한 시간 갱신, 더 큰값이 나왔다는 건 선수과목이 더 있다는 얘기 
				indegree[nextClass] -= 1 ; 
				if(indegree[nextClass] == 0) {
					q.offer(nextClass) ; 
				}
			}
		}
		Arrays.stream(result).forEach(System.out::println);
	}
}
