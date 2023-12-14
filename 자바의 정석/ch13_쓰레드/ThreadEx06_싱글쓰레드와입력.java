package ch13_쓰레드;

import javax.swing.JOptionPane;

/**
 * @author HEEMIN
 * @date 2023. 12. 14.-오후 2:58:33
 *	@subject 싱글 쓰레드 vs 멀티 쓰레드 - 싱글 쓰레드 
 * @content  싱글 쓰레드에선 작업이 지연되는 동안 그저 대기해야한다 


 */
public class ThreadEx06_싱글쓰레드와입력 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis() ; 
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.") ; 
		System.out.println("입력하신 값은 " + input) ;
		
		for (int i = 10; i > 0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch (Exception e) {}
		}
		
		System.out.println("소요 시간 : "+ (System.currentTimeMillis() - startTime)); // 14241

		
	}

}
