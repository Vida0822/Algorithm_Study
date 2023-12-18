package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 18.-오후 12:50:23
 *	@subject 쓰레드 실행제어 - yield()
 * @content  실행을 멈추고 실행대기 상태에 들어간다 <-> 자원과 시간을 다음 실행 대기 상태(준비 상태)에 있는 쓰레드에 양보한다 
 * 					=> 실행 대기에 있는 다음 쓰레드를 실행한다 


 */
public class ThreadEx18_yield {

	public static void main(String[] args) {

		ThreadForYeild th1 = new ThreadForYeild( "*"); 
		ThreadForYeild th2 = new ThreadForYeild("**"); 
		ThreadForYeild th3 = new ThreadForYeild("***"); 

		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000); // main 쓰레드를 의미 

			th1.suspend();
			Thread.sleep(2000); // main 쓰레드를 의미 

			th2.suspend();
			Thread.sleep(3000); // main 쓰레드를 의미 

			th1.resume();
			Thread.sleep(3000); // main 쓰레드를 의미 

			th1.stop();
			th2.stop();
			Thread.sleep(3000); // main 쓰레드를 의미 

			th3.stop();
		}catch (InterruptedException e) {}
	}
}


class ThreadForYeild implements Runnable{
	boolean suspended = false ; 
	boolean stopped = false  ; 

	public void suspend() {
		suspended = true; 
		th.interrupt();
		}
	public void resume() {suspended = false ; }
	public void stop() {
		stopped = true; 
		th.interrupt(); // 응답성 향상 : 쓰레드가 sleep인 상태였을 때 
		}
	public void start() {th.start();}

	Thread th ; 
	
	public ThreadForYeild(String name) {
		th = new Thread(this, name) ; 
	}

	@Override
	public void run() { // 1초에 한번씩 자기 쓰레드 이름을 출력
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000); //  1 초씩 지연 
				}catch (InterruptedException e) {}
			}else {
				Thread.yield(); 
				// 이게 없으면 남은 실행시간을 while문에서 낭비하지 않고 다른 쓰레드에게 양보 
				// => 일시정지 시킬때 그냥 멈춰놓기만 하는게 아니라 준비중인 다음 쓰레드에게 자원 give 
			}
		} // while 
		System.out.println(Thread.currentThread().getName() + "- stopped");
	} // run 
} // class 