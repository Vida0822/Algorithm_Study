package ch13_쓰레드;

/**
 * @author HEEMIN
 * @date 2023. 12. 15.-오후 3:15:08
 *	@subject 쓰레드 그룹 
 * @content 


 */
public class ThreadEx09_쓰레드그룹 {

	public static void main(String[] args) {
		
		ThreadGroup main = Thread.currentThread() // main 쓰레드  
									.getThreadGroup();  // main 쓰레드 그룹 
		
		ThreadGroup grp1 = new ThreadGroup("Group1") ; 
		ThreadGroup grp2 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "Group2") ; 
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1") ; 
		
		grp1.setMaxPriority(3); 
		
		Runnable r = new /*3. 객체 */   Runnable() { /* 1. interface */
			
			@Override /*2. 구현 --> 익명 클래스 vs ex01 : 'ImpledThread'  */
			public void run() {
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
				
			}
		}; // Runnable r 
		
		new Thread(grp1, r, "th1").start();  
		new Thread(subGrp1, r, "th2").start();  
		new Thread(grp2, r, "th3").start();   // runnable의 장점 -> 활용성이 좋다 : 필요한 곳마다 부품 넣어주듯이 넣어줄 수 있음 
		
		System.out.println(">> Name of ThreadGroup : " + main.getName());
		System.out.println(">> Active ThreadGroup : " + main.activeGroupCount());
		System.out.println(">> Active Thread : " + main.activeCount());
		
		main.list(); // 쓰레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보를 출력 --> 들여쓰기를 통해 계층정보도 보여줌 

	}
}
