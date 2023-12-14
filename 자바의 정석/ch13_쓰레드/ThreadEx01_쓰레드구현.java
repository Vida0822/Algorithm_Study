package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 12:22:55
 *	@subject 쓰레드를 구현하는 두가지 방법의 차이 
 * @content 
 - Thread 클래스 상속 vs Runnable 인터페이스 구현 (주입해서 Thread 직접 사용) 
 - run() : 해당 쓰레드가 호출 시 실행할 코드 작성 


 */
public class ThreadEx01_쓰레드구현 {
	public static void main(String[] args) {

		// Thread 클래스를 상속받은 쓰레드 객체 생성 
		ExtendedThread t1 = new ExtendedThread();
		
		// Runnable 인터페이스를 구현한 쓰레드의 객체생성 
		Runnable r = new ImpledThread() ;   /* Runnable('실행할 수 있는')   target : What will be run. */
		Thread t2 = new Thread(r, "이름2") ;  // 쓰레드의 이름을 지정할 수 있다 
		// Runnable 인터페이스를 구현한 쓰레드 인스턴스를 Thread 클래스에 생성자 주입 
		// 		=> r.run() --> 참조변수에 담긴 '인스턴스의' run()을 호출 : run()을 오버라이딩 하지 않고도 외부로부터 run()을 제공받아서 Thread에서 직접 사용  
		 
		t1.start(); // 쓰레드 실행 
		t2.start(); // 쓰레드 실행 ※ run()을 직접 호출하는게 아니다 
	}
}

class ExtendedThread extends Thread{
	// run()을 구현 안해도 오류가 발생하지 않는다 (컴파일 시점에 에러 잡아주지 못함 + 잘못 입력한 run() 메서드여도 x ) 
	public void run() { 
		for(int i = 0; i<5; i++) {
			System.out.println(getName()); // 조상인 Thread의 getName()을 호출 
		}
	} // run 
}

class ImpledThread implements Runnable{
	// 메서드를 구현하지 않으면 컴파일 에러 --> 자동완성의 도움으로 오타없이 코드를 작성할 수 있다 
	public void run() {
		for (int i = 0; i < 5 ; i++) {
			Thread curThread = Thread.currentThread() ; // 현재 실행중인 Thread를 반환한다 (static method) 
			System.out.println(curThread.getName()) ; 
		}
	} // run 
}
