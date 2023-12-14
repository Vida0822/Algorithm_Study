package ch13_쓰레드;

import javax.swing.JOptionPane;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 3:04:02
 *	@subject 싱글 쓰레드 vs 멀티 쓰레드 - 멀티 쓰레드 
 * @content  멀티 쓰레드에선 작업이 지연되는 동안 다른 쓰레드의 작업을 수행할 수 있다 


 */
public class ThreadEx07_멀티쓰레드와입력 {
	
	static long startTime = 0 ; 

	public static void main(String[] args) {
		
		startTime = System.currentTimeMillis(); 
		
		ThreadForInputTest th = new ThreadForInputTest() ; 
		th.start(); 
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요"); 
		System.out.println("입력하신 값은 "+ input + "입니다");
		
		
	}
}

class ThreadForInputTest extends Thread{
	public void run() {
		for (int i = 10; i > 0 ; i--) {
			System.out.println(i);
			try {
				sleep(1000); 
			}catch (Exception e) {	}
		}
		
		System.out.println("소요시간 : "+ (System.currentTimeMillis() - ThreadEx07_멀티쓰레드와입력.startTime )); // 10096
	}
}
