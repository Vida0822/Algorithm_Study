package sorting;


import java.util.ArrayList;
import java.util.Arrays;

public class 두개뽑아서더하기 {

	public static int[] solution(int[] numbers) {
		ArrayList<Integer> answerList = new ArrayList<>();

		// part 1. 두개의 수를 뽑아 더해서 만들수 있는 모든 수를 배열에 담기 
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];

				if(!answerList.contains(sum)){
					answerList.add(sum);
				}
			} // j 
		} // i  

		// part 2. 오름차순으로 정렬하기
		Integer[] answerArray = answerList.toArray(new Integer[0]);
		Arrays.sort(answerArray); // java' Arrays 사용 (암기) 
		/*
        	for (int i = 1; i < answer.length; i++) { ※ i= 1 부터 시작해야 아랫줄에서 오류가 안난다 
				for (int j = 0; j < answer.length - i ; j++) {
					if(answer[j] > answer[j+1]) {
						// swap 
						int temp = answer[j] ; 
						answer[j] = answer[j+1] ; 
						answer[j+1] = temp ; 
					}
				} // j 
			} //i 
		 */
		return Arrays.stream(answerArray).mapToInt(Integer::intValue).toArray();
	} // solution() 
} // class
