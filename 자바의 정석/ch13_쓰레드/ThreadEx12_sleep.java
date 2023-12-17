package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 17.-오후 12:41:15
 *	@subject 쓰레드 실행제어 - sleep() : 실행중인 쓰레드를 일시정지 시킨다 (일정 시간동안) 
 * @content 


 */
public class ThreadEx12_sleep {

	public static void main(String[] args) {
		
		쓰레드1 th1 = new 쓰레드1() ; 
		쓰레드2 th2 = new 쓰레드2() ; 
		
		th1.start(); 
		th2.start(); 
		
		try {
			 th1.sleep(2000);  //  The static method sleep(long) from the type Thread should be accessed in a static way
			//Thread.sleep(1000);
		}catch (InterruptedException e) {
		}
		System.out.println("main 종료");

		
	} // main 

} // class 

class 쓰레드1 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(" 작업1 ");
		}
		System.out.println("<<th1 종료>>");
	}
}
class 쓰레드2 extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(" 작업2 ");
		}
		System.out.println("<<th2 종료>>");
	}
}