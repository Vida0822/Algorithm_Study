package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HEEMIN
 * @date 2023. 11. 21.-오후 11:55:33
 *	@subject  정렬 직접 기준 정하기 
 * @content 


 */
public class 가장큰수 {

	public String solution(int[] numbers) {
        String answer = "";
        
        // part 1. 숫자 구성요소 뽑기  
        ArrayList<Integer> sums = new ArrayList<>() ; 
        
        String s1 = "" ; 
        for(int i = 0 ; i < numbers.length ; i++){         
           s1 += numbers[i]+"" ; 
        } // i   
//        String[] stringNumber = s1.split(' ') ;  // 6 , 1, 0 , 2 
       
        // part 2. 문자 조합 만들기 (순열 만들기)
        
       
        // part 3. 만든 문자조합 숫자로 바꾸기  
        Integer[] answerArray = sums.toArray(new Integer[0]) ;  
        
        // part 4. 오름차순 정렬 후 최대값 반환하기 
        Arrays.sort(answerArray) ;
        int[] answers = Arrays.stream(answerArray)
            .mapToInt(Integer::intValue).toArray();

        return answers[answers.length-1]+"";
    }

}
