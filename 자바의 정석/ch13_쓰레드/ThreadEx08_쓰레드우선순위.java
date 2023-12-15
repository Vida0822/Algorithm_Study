package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 15.-오후 2:36:49
 *	@subject 쓰레드의 우선순위 
 * @content 
 - 각 쓰레드에 우선순위를 나타내는 인스턴스 변수 : int priority  <------- get, set 
 - 높은 우선순위의 쓰레드가 더 많은 작업 시간을 갖도록 할 수 있다 
 - 보통 사용자와 상호 작업을 많이 하는, 즉 입출력 작업이 잦은 프로세스(쓰레드)가 우선순위가 더 높다 
 - 우선 순위는 각 프로세스에도 부여되고, 각 쓰레드에도 부여된다. 


 */
public class ThreadEx08_쓰레드우선순위 {

	public static void main(String[] args) {
		
		LowThread lth = new LowThread();  // 우선순위 : 5
		HighThread hth = new HighThread();
		hth.setPriority(7); // 우선순위 : 7 
		
		System.out.println("Priority of lth : " + lth.getPriority());
		System.out.println("Priority of htg : " + hth.getPriority());
		lth.start(); 
		hth.start(); 

	}

}

class LowThread extends Thread{
	
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(" 작업 1 ");	
			for (int x = 0; x < 1000000; x++)  ; // 작업을 지연시키기 위한 for문 
		}
	} // run 
	
} // LowThread

class HighThread extends Thread{
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print(" 작업 2 ");	
			for (int x = 0; x < 1000000; x++)  ; // 작업을 지연시키기 위한 for문 
		}
	} // run 
}