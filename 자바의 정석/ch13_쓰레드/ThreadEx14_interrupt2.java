package ch13_쓰레드;

import javax.swing.JOptionPane;

/**
 * @author HEEMIN
 * @date 2023. 12. 17.-오후 12:51:09
 *	@subject 쓰레드 실행제어 - interrupt() , isInterrupt() 
 * @content 


 */
public class ThreadEx14_interrupt2 {

	public static void main(String[] args) {
		ThreadForInterrupt2 th = new ThreadForInterrupt2(); 
		
		// 쓰레드 1 
		th.start();
		
		// 쓰레드 2 
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");  // 실행 --> 대기 큐 

		/*
		 * 대기 상태 (일시 정지 상태) => 사용자가 입력  
		 */
		
		System.out.println("입력하신 값은 "+input+"입니다");
		th.interrupt(); // 인터럽트 요청 신호  --> 작업 멈추고 th 에 인터럽트 요청 신호 보냄  : 인터럽트 상태 레지스터 값 1(true) 
		
		/*
		 * 준비 상태 (실행 대기 상태) -> 실행 
		 */
		System.out.println("인터럽트? (isInterrupted() ) : "+ th.isInterrupted()); // 실행 

	}
}
class ThreadForInterrupt2 extends Thread{
	public void run() {
		int i = 10 ; 
		
		while(i!=0 && !isInterrupted()) { // 인터럽트 신호가 올기전 까지 (레지스터 값? 계속 확인)
			System.out.println(i--);
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				interrupt(); // 이거 없으면 count 계속 실행 --> Exception에 의해 인터럽트 신호가 무시되므로(false 자동 변경)  
			}
		}
		// 인터럽트 서비스 루틴 실행 
		if(isInterrupted()) {
			System.out.println("인터럽스 서비스 루틴 실행");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				interrupt(); // java.lang.InterruptedException: sleep interrupted
			}
		}
		
		if(i==0) {			
			System.out.println("카운트가 종료되었습니다");
		}
	}
}