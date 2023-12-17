package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 17.-오후 1:48:28
 *	@subject 쓰레드 실행제어 - suspend(), resume(), stop() 
 * @content  sleep()과 달리 suspend()는 정지 시간을 지정하지 못한다 -> resume()으로 다시 재개 (실행대기) 해줘야함 

 */
public class ThreadEx15_suspend_resume {

	public static void main(String[] args) {

		RunImpl r = new RunImpl() ;
		Thread th1 = new Thread(r , "*"); 
		Thread th2 = new Thread(r , "**"); 
		Thread th3 = new Thread(r , "***"); 

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

class RunImpl implements Runnable{

	@Override
	public void run() { // 1초에 한번씩 자기 쓰레드 이름을 출력
		while(true) {
			System.out.println(Thread.currentThread().getName());
			// currentThread : 조립시켜준 쓰레드 안에서 해당 쓰레드를 가리킬 때 사용 ex) 조립될 레고 팔 판매 --> "부착될 레고의 접합부는 ~ " 
			try {
				Thread.sleep(1000); //  1 초씩 지연 
			}catch (InterruptedException e) {}
		}
	} // run 

}
