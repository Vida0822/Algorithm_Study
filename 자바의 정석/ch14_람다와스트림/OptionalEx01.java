package ch14_람다와스트림;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.*;

/**
 * @author HEEMIN
 * @date 2023. 12. 4.-오후 9:01:52
 *	@subject 스트림 최종 연산 - Optional 클래스 
 * @content 
1. 스트림의 최종 연선 결과로 Optional 클래스가 나올 때가 있다
2. Optional 클래스는 결과값이 null일 경우를 방지에 무조건적으로 반환되는 래퍼 클래스이다 

 */
public class OptionalEx01 {
	public static void main(String[] args) {
		
		/*
		 * 1) 
		 */
		Optional<String> optStr = Optional.of("abcde" ) ; 
		Optional<Integer> optInt = optStr.map(String::length) ; // Optional 객체에 담겨있는 요소에 String 클래스에 length 적용해서 반환 --> Optional -> Optional 반환됨  
		System.out.println("optStr="+optStr.get()) ;  // abcde 
		System.out.println("optInt="+optInt.get()) ;  // 5 
		
		/*
		 * 2) 
		 */
		int valResult = Optional.of("123")
				.filter(x->x.length() > 0)
				.map(Integer::parseInt).get(); 

		int nullResult = Optional.of("")
				.filter(x->x.length() > 0)
				.map(Integer::parseInt).orElse(-1) ; 
		
		int funcResult ; 
		try { 
			 funcResult = Optional.of("")
				.filter(x->x.length() > 0)
				.map(Integer::parseInt).get() ; 
		}catch (Exception e) {
			 funcResult = 0 ; 
		}

		System.out.println("valResult = "+ valResult); // 123 
		System.out.println("nullResult = "+ nullResult); // -1 
		System.out.println("funcResult = "+ funcResult); // 0 
		
		/*
		 * 3) 
		 */
		Optional.of("456").map(Integer::parseInt) // Optional<Integer> 
								.ifPresent(x->System.out.printf("result3=%d%n", x));
		
		/*
		 * 4) 
		 */
		OptionalInt optInt1 = OptionalInt.of(0); 
		OptionalInt optInt2 = OptionalInt.empty(); 
		
		System.out.println(optInt1.isPresent()); // true 
		System.out.println(optInt2.isPresent()); // false 
		System.out.println(optInt1.getAsInt());  // 0 
		//System.out.println(optInt2.getAsInt());  // NoSuchElementException:
		System.out.println("optInt1="+optInt1); // OptionalInt[0] : Optional 객체에 0이 저장되어있다 
		System.out.println("optInt2="+optInt2); // OptionalInt.empty : 비어있는 Optional 객체이다 
		System.out.println("optInt1.equals(optInt2)?" + optInt1.equals(optInt2)); // false 
		
		
		Optional<String> opt = Optional.ofNullable(null) ; 
		Optional<String> opt2 = Optional.empty() ;
		System.out.println("opt = "+ opt); //  Optional.empty
		System.out.println("opt2 = "+ opt2);  //  Optional.empty
		System.out.println("opt.equals(opt2)?" + opt.equals(opt2)); // true 
		
		

	} // main 
} // class 
