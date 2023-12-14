package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 1:48:48
 *	@subject start() - 쓰레드 실행과 호출 스택  
 * @content 
- 쓰레드를 실행시키면(start()) native 메서드를 호출하여 새로운 호출스택을 생성한다 
- 호출스택의 가장 위에 있는 메서드들, 즉 각 쓰레드는 CPU의 스케줄링에 따라 번갈아가며 수행된다 
- 수행되지 않을 땐 '대기' 상태에 있는다 
- Exception e.printStackTrace() : 예외가 발생한 당시의 호출스택을 출력 

 */
public class ThreadEx02_호출스택_start호출 {

	public static void main(String[] args) {
		
		MyThread t = new MyThread() ; 
		t.start(); // 새로운 호출스택 생성 - MyThread 호출 스택 --> 그 안에서 run 수행 

	} // main 
} // class 

class MyThread extends Thread{
	public void run() {
		throwException() ;  // MyThread 호출스택에 올라가있는 run에서 Exception 예외 발생 <-> Exception 발생 위치 : MyThread 호출 스택 
	}
	
	public void throwException() {
		try {
			throw new Exception() ; 
		}catch (Exception e) { // 무조건 발생 
			e.printStackTrace();  // at ch13_쓰레드.MyThread.throwException(ThreadEx02_호출스택.java:31)  --> main이 없음 = main과는 다른 별개의 쓰레드에서 예외가 발생 
		}
	}
	
}
