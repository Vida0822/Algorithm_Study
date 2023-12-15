package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 15.-오후 3:32:59
 *	@subject 데몬 쓰레드 - 일반 스레드의 보조 역할 수행 
 * @content 
- 포그라운드 프로세스 : 사용자가 볼 수 있는 공간에서 실행되는 프로세스 
- 백그라운드 프로세스 : 사용자가 보지 못하는 뒤편에서 실행되는 프로세스 
						--> 그 중 사용자와 직접 상호작용하지 않고 정정해진 일만 묵묵히 수행하는 백그라운드 프로세스 : 데몬 (서비스) 
							<-> 사용자의 요청에 의해 작업하는게 아니라 일정 시점, 조건이 되면 작업을 수행하는 것 
- 데몬 쓰레드 동작 : 실행 --> 대기 --> 특정 조건, 시점 만족 --> 실행 --> 대기 

 */
public class ThreadEx10_데몬쓰레드 implements Runnable{ 

	static boolean autoSave = false ; 

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadEx10_데몬쓰레드()) ; // 자기 자신을 생성자 매개변수로 넣어줌 
		t.setDaemon(true); // 이 부분이 없으면 종료되지 않는다. 
		t.start(); 
		
		for (int i = 1; i <= 10; i++) {		
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {}
			System.out.println(i);
			
			if(i==5)
				autoSave= true; 
		}
	} // main

	@Override
	public void run() { // 데몬 쓰레드 실행부 ! 
		while(true) {
			try {
				Thread.sleep(3*1000); // 3초마다 쓰레드 실행 
			}catch (InterruptedException e) {}

			if(autoSave) { // autoSave가 true면, autoSave 
				autoSave() ;  
			}
		}// while 
	} // run 

	public void autoSave() {
		System.out.println("작업 파일이 자동저장 되었습니다");
	} // autoSave
} // class 
