package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HEEMIN
 * @date 2023. 11. 21.-오후 10:23:00
 *	@subject 정렬 - 직접 기준 정하기 
 * @content  문자열 내 마음대로 정렬하기 (Level1) 


 */
public class 문자열_내마음대로_정렬하기 {

	 public String[] solution(String[] strings, int n) {
	        String[] answer = {};

	        for(int i = 1 ; i < strings.length ; i++ ){
	            for(int j = 0 ; j < strings.length - i ; j++ ){

	                char c1 = strings[j].charAt(n) ; 
	                char c2 = strings[j+1].charAt(n) ; 

	                if(c1 > c2){
	                    String temp = strings[j]; 
	                    strings[j] = strings[j+1] ; 
	                    strings[j+1] = temp ;        
	                } else if(c1 == c2){
	                    Arrays.sort(strings, j, j+2) ;  // ※ j <=  < j+2 
	                }
	                answer = strings ;  
	            }  // j   
	        } // i 
	        return answer;
	    } // solution()
}