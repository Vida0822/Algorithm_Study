package search;

import java.util.* ;
import java.util.stream.Stream; 

/**
 * @author HEEMIN
 * @date 2023. 12. 1.-오후 3:29:39
 *	@subject 이진탐색 
 * @content Programmers - Level 2 (2021 KAKAO BLIND RECRUITMENT) 


 */
public class 순위탐색 {

	public int[] solution(String[] info, String[] query) {

		// step 1 . 코딩테스트 점수 기준으로 정렬 
		Arrays.sort(info, new Comparator(){
			/* @Override
			  public int compare(String str1 , String str2) {
				  return 0 ; 
			  } */

			@Override
			public int compare(Object o1, Object o2) {

				String[] data1 = ((String)o1).split(" ") ; 
				String[] data2 = ((String)o2).split(" ") ; 

				int score1 = new Integer(data1[4] ) ; 
				int score2 = new Integer(data2[4] ) ; 

				return score1 >score2 ? 1 : (score1 == score2 ? 0 : -1) ;
			} // compare
		}); // sort 

		// step 2. 쿼리문으로 검색하기 
		int[] answer = new int[query.length] ; 
		
		for (int i = 0; i < query.length; i++) {
			String[] queryParams = query[i].split(" and ") ; 
			int index = Arrays.binarySearch(info, queryParams[4], new Comparator<String>() {
			    @Override
			    public int compare(String str1, String str2) {
			        // Implement comparison logic for the search key (queryParams[4])
			        return str1.split(" ")[4].compareTo(str2);
			    }
			});


			int count = 0 ; 
			for (int j = index ; j < info.length; j++) {
				String[] datas = info[j].split(" ") ; 
				
				boolean flag = false ; 
				for (int k = 0; k < queryParams.length; k++) {
					
					if(datas[k].contains(queryParams[k]) ||  queryParams[k] == "-" ) {
						flag = true ;
					}
				} // k 
				if(flag) {
					count++ ; 
				}
			} // j 
			answer[i] = count ; 
		} // i 

		return answer;
	} // main 
} // class 
