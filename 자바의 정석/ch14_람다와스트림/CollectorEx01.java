package ch14_람다와스트림;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author HEEMIN
 * @date 2023. 12. 5.-오전 11:55:01
 *	@subject 스트림 최종연산 - Collector 직접 구현하기 
 * @content 


 */
class ConcatCollector implements Collector<String, StringBuilder, String>{

	@Override
	public Supplier<StringBuilder> supplier() {
		return() -> new StringBuilder() ; 
		// return StringBuilder::new;
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		return (sb, s) -> sb.append(s); // 람다식에선 매개변수의 자료형 생략 가능 
		// return StringBuilder::append ; 
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		return (sb, sb2) -> sb.append(sb2) ; // 두개의 StringBuilder가 있을 때 combine할 때 sb에 sb2를 추가 
		// return StringBuilder::toString; 
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		return sb -> sb.toString();
		// return StringBuilder::toString; 
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(
				Collector.Characteristics.CONCURRENT
				, Collector.Characteristics.UNORDERED
			));
	} 
} // ConcatCollector

public class CollectorEx01 {

	public static void main(String[] args) {
		String[] strArr = { "aaa", "bbb", "ccc"} ;
		Stream<String> strStream = Stream.of(strArr) ; // 스트링 스트림 만듬
		
		String result = strStream.collect(new ConcatCollector()) ; 
		
		System.out.println(Arrays.toString(strArr));
		System.out.println("result = "+ result);
	}
}
