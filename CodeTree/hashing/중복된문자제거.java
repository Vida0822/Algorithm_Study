package hashing ; 

import java.util.* ; 

class 중복된문자제거 {
    public String solution(String my_string) {
        String answer = "";

        HashSet<String> hashSet = new HashSet() ; 
        /* +) LinkedHashSet : *입력 순서를 유지하면서* 중복을 허용하지 않는 Set 구현체 
         		=> 이걸 사용하면 answer을 다루지 않고 바로 String.join("", set) 가능 
       		
       		String join(CharSequence delimiter,  Iterable<? extends CharSequence> elements)
         	ex) Set<String> strings = new LinkedHashSet<>(List.of("Java", "is", "very", "cool"));
          		  String message = String.join("-", strings); 	 //message returned is: "Java-is-very-cool"
         */
        for(int i = 0  ; i < my_string.length() ; i++ ){
            String ch = ""+ my_string.charAt(i); 

            if(!hashSet.contains(ch)){
                hashSet.add(ch) ; 
                answer = answer + ch ; 
            }
        }
        return answer;
    }
}