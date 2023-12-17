package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 17.-오후 2:10:16
 *	@subject 쓰레드 실행제어 - 교착 상태 해결 
 * @content 
 * 교착 상태 : 서로 다른 프로세스(쓰레드)들이 동일한 자원을 공유하는 상황 속 서로의 자원을 내련호지 않는 상황 
 * => 이 코드 해결: 바로 중지시키는 것이 아니라 인스턴스 변수의 true, false 값을 바꾸도록 오버라이딩 해서 
 * 					


 */
public class ThreadEx16_교착상태해결 {
	public static void main(String[] args) {

		RunImpl2 r1 = new RunImpl2() ;
		RunImpl2 r2 = new RunImpl2() ;
		RunImpl2 r3 = new RunImpl2() ;

		Thread th1 = new Thread(r1 , "*"); 
		Thread th2 = new Thread(r2 , "**"); 
		Thread th3 = new Thread(r3 , "***"); 

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


class RunImpl2 implements Runnable{
	boolean suspended = false ; 
	boolean stopped = false  ; 

	public void suspend() {suspended = true; }
	public void resume() {suspended = false ; }
	public void stop() {stopped = true; }


	@Override
	public void run() { // 1초에 한번씩 자기 쓰레드 이름을 출력
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				// currentThread : 조립시켜준 쓰레드 안에서 해당 쓰레드를 가리킬 때 사용 ex) 조립될 레고 팔 판매 --> "부착될 레고의 접합부는 ~ " 
				try {
					Thread.sleep(1000); //  1 초씩 지연 
				}catch (InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName() + "- stopped");
	} // run 




}