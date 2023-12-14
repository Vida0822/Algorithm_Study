package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 2:29:33
 *	@subject 싱글쓰레드 vs 멀티 쓰레드 -  멀티 쓰레드
 * @content  
 - 멀티 쓰레드 : 여러개의 작업을 여러개의 쓰레드로 작업 --> 짧은 시간동안 쓰레드가 번갈아가면서 작업을 수행 
 - 동시수행 가능하게 함 : 작업 1과 작업 2를 함께 실행할 수 있음 


 */
public class ThreadEx05_멀티쓰레드소요시간 {
	
	static long startTime = 0 ; 

	public static void main(String[] args) { 
		
		// 쓰레드 1 
		ThreadForMulti th1 = new ThreadForMulti() ; 
		th1.start();  
		startTime = System.currentTimeMillis() ; 
		
		// 쓰레드 2 
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s" , new String(" 작업 2 "));
		}
		System.out.println();
		System.out.println("소요시간 2 :"+ (System.currentTimeMillis() - ThreadEx05_멀티쓰레드소요시간.startTime)); // 작업 1 수행 완료시간 : 65 (vs 싱글스레드' 60 : 작업 전환 시간이 소요 되었기 때문이다)  
		
		

	} // main 
} // class

class ThreadForMulti extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s" , new String(" 작업 1 "));
		}
		System.out.println();
		System.out.println("소요시간 1 :"+ (System.currentTimeMillis() - ThreadEx05_멀티쓰레드소요시간.startTime)); // 작업 2수행 완료시간 :  65 --> 거의 동시에 작업 완료
		
	}
}
