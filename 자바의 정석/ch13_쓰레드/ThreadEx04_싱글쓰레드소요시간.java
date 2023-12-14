package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 2:24:31
 *	@subject 싱글쓰레드 vs 멀티 쓰레드 - 싱글쓰레드
 * @content  
  - 싱글 쓰레드 : 하나의 쓰레드로 두개 이상의 작업을 처리 --> 한 작업을 다 마친 후 다른 작업 시작 
  - 동시 수행 불가능 : 작업 1을 다 마칠때 까진 작업 2 수행 불가 


 */
public class ThreadEx04_싱글쓰레드소요시간 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis() ; 
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String(" 작업1 ")); // 수행 속도 늦추기 위해 ! 
		}
		System.out.println();
		System.out.println("소요시간 1 : " + (System.currentTimeMillis() -startTime));  // 작업 1 수행 완료시간 : 45 --> 컴퓨터의 성능이나 실행환경에 의해 달라질 수 있다 
		
		
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String(" 작업2 "));
		}
		System.out.println();
		System.out.println("소요시간 2 : " + (System.currentTimeMillis() -startTime)); // 작업 2 수행 완료 시간 = 두개 작업 총 수행시간 : 60 
		
		
		

	} // main 

} // class 
