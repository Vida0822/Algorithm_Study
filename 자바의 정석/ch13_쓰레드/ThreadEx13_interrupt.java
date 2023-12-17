package ch13_쓰레드;

import javax.swing.JOptionPane;

/**
 * @author HEEMIN
 * @date 2023. 12. 17.-오후 12:51:09
 *	@subject 쓰레드 실행제어 - interrupt() , isInterrupt() 
 * @content 


 */
public class ThreadEx13_interrupt {

	public static void main(String[] args) {
		ThreadForInterrupt th = new ThreadForInterrupt(); 
		
		// 쓰레드 1 
		th.start();
		
		// 쓰레드 2 
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 "+input+"입니다");
		
		/*
		 * 인터럽트 신호 발생 
		 */
		th.interrupt(); // 인터럽트 요청 신호 - 인터럽트 상태 레지스터 값 1(true)  
		
		System.out.println("인터럽트? (isInterrupted() ) : "+ th.isInterrupted());

	}
}
class ThreadForInterrupt extends Thread{
	public void run() {
		int i = 10 ; 
		
		while(i!=0 && !isInterrupted()) { // 인터럽트 신호가 올때 까지 (레지스터 값? 계속 확인)
			System.out.println(i--);
			for(long x = 0  ; x < 2500000000L ; x++) ; // 시간 지연 
		}
		System.out.println("카운트가 종료되었습니다");
	}
}