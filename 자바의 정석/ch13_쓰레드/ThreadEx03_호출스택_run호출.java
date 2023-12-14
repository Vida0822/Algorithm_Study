package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 1:59:54
 *	@subject run() 직접 호출 - 호출 스택이 생성되지 않는다 
 * @content 


 */
public class ThreadEx03_호출스택_run호출 {
	
	public static void main(String[] args) {
		MyThread2 t2 = new MyThread2() ; 
		t2.run() ;  // main 안이 아니면 오류 
	}
}

class MyThread2 extends Thread{
	
	public void run() {
		throwException() ;  
	}
	
	public void throwException() {
		try {
			throw new Exception() ; 
		}catch (Exception e) { // 무조건 발생 
			e.printStackTrace();  // at ch13_쓰레드.ThreadEx03_호출스택_run호출.main(ThreadEx03_호출스택_run호출.java:15)  --> main과 같은 쓰레드, 즉 호출스택에서 예외 발생 
		}
	}
}
