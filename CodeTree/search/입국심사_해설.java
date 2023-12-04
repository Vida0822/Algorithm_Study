package search;

import java.util.*;

/**
 * @author HEEMIN
 * @date 2023. 12. 4.-오후 3:33:29
 *	@subject 이분 탐색 응용 - 어떤걸 탐색하는지 그 정의와 범위를 지정하는게 point인 문제 
 * @content 
[이분 탐색으로 푸는 법] 
1. 내가 찾아야 할 정답의 범위를 left ~ right로 정한다. ** 
	* 탐색의 정의와 범위 지정 중요 --> '모든 사람이 심사를 받는데 걸리는 시간'
2. 정답을 mid로 간주한 후, 해당 정답이 유효한지 살펴본다.
3. 2번 여부를 따지며 left와 right의 범위를 좁힌다.
4. left > right가 되면 반복을 끝내고 답을 반환한다

 */
public class 입국심사_해설 {
	public long solution(int n , int[] times) {
		
		long answer = 0 ; 
		Arrays.sort(times);
		
		long left = 0 ; 
		long right = times[times.length - 1] * (long) n ; // 모든 사람이 가장 느리게 심사 
		
		while(left <= right) {
			long mid = (left+right)/2 ; 
			long complete = 0 ;
			
			for(int i = 0 ; i < times.length ; i ++) {
				complete += mid/ times[i] ; // mid 시간 동안 검사받을 수 있는 사람 수 
			}
			
			if(complete < n ) { // 검사를 다 받지 못하면 
				left = mid +1 ; // 오른쪽 범위에서 이분 탐색 
			}else {  // 검사를 다 받을 수 있으면 
				answer = mid ;  // 일단 그 값을 answer에 담아 두고 
				right = mid - 1 ; // 왼쪽 범위에서 더 짧은 시간안에 가능한지 검사 	
			}
		}
		return answer  ;  // 더 이상 최대값 안나오면 저장해둔 answer가 답	
	} // solution
} // class 
