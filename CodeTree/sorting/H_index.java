package sorting;

import java.util.Arrays;

/**
 * @author HEEMIN
 * @date 2023. 11. 20.-오후 11:48:58
 *	@subject 기본 정렬 기준이 있는 자료형에서의 정렬 
 * @content 

반복 
1번이상 인용된 논문이 1개 이상 ? --> max update 
2번이상 인용된 논문이 2개 이상 ?  --> max update 
3번이상 인용된 논문이 3개 이상 ? --> max update 
4번이상 인용된 논문이 4개 이상 ? --> max update 

... 
n번이상 인용된 논문이 n개 이상 ?  --> max update 
 */
class H_index {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations); 

		for (int i = 0 ; i <= citations.length; i++) {

			/*
			int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
			 */

			int count = 0  ; 
			for (int j = 0; j < citations.length; j++) {
				if(i <= citations[j]) {
					count ++ ; 
				}
			} // j 
			if(i <= count && answer <= count ) {
				answer = i  ; 
			}
		}  // i     
		return answer;
	}
}
