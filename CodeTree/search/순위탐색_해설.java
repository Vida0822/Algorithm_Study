package search ; 

import java.util.* ;

public class 순위탐색_해설{
	public int[] solution(String[] info, String[] query) {

		// 1. info를 기반으로 hashMap 만들기 
		HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>(); 

		for(String i : info) {
			String[] data = i.split(" ") ; 
			String[] languages = {data[0], "-"} ; // 조건 조합에 "-" 인 경우도 포함해야함 
			String[] jobs = {data[1]  , "-" } ; 
			String[] exps = {data[2] , "-" } ; 
			String[] foods = {data[3] , "-" } ;
			Integer value = Integer.parseInt(data[4]) ; // 점수 

			for(String lang : languages)
				for(String job : jobs)
					for(String exp : exps)
						for(String food : foods) {
							String[] keyData = {lang, job, exp, food} ; 
							String key = String.join(" ", keyData) ; // 각 값들을 띄어쓰기를 기준으로 하나의 문자열로 합침 
							ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>()) ; // 해당 key값에 해당하는 value, ArrayList를 가져오는데 만약 value 값이 없으면 새로은 ArrayList를 생성해 반환한다
							arr.add(value) ; 
							hashMap.put(key, arr); // 같은 key 값이 있으면 덮어쓰기 됨 
						}
		} // for info 

		// 2. hashMap의 각 key의 value(ArrayList) 를 오름차순 정렬하기 
		for(ArrayList<Integer> scoreList : hashMap.values())
			scoreList.sort(null); // ※ list 정렬할때는 오름차순일 땐 null을 넣어줘야함 

		// 3. query 조건에 맞는 지원자들 가져오기 
		int[] answer = new int[query.length] ;
		// 사전 코드에 나타나있는 크기 0짜리 배열은 크기 지정해서 다시 생성해줘야함 

		int i = 0; 
		for(String q : query) { // 쿼리를 하나씩 뽑아서  "java and backend and junior and pizza 100" 
		
			String[] keyData = q.split(" and ") ;  // 각 쿼리를 " and " 를 기준으로 split  -  "java/backend/junior/pizza 150" 
			int target = Integer.parseInt(keyData[3].split(" ")[1] ) ; // "pizza 150" --> 150 (int) : 얜 따로 key 배열에 저장하지 않음 
			keyData[3] = keyData[3].split(" ")[0]; // "pizza"  (update : pizza 150 --> pizze) 
			String key = String.join(" ", keyData) ; 
			
			
			// 4. lower - bound 하한선 찾기 (이진탐색) 
			if(hashMap.containsKey(key)) { // hashTable증 해당 key 가 있으면 
				ArrayList<Integer> list = hashMap.get(key) ; 
				int left = 0 ; 
				int right = list.size(); 
				while(left < right ) {
					// 이진탐색 직접 구현 
					int mid = (left + right) / 2 ; 
					if(list.get(mid) >= target)
						right= mid ; 
					else
						left = mid + 1 ; 
				}
				answer[i] = list.size() -left ; 
			}
			i++ ;  //query index와 answer index 맞춰주기 위해 
		} // for q 
		return answer ; 
	} // solution 


	public static void main(String[] args) {
		순위탐색_해설 sol = new 순위탐색_해설();
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
		"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(sol.solution(info, query));
	} // main 

}