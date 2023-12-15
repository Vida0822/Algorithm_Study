package ch13_쓰레드;

import java.util.Iterator;
import java.util.Map;

/**
 * @author HEEMIN
 * @date 2023. 12. 15.-오후 4:36:17
 *	@subject 데몬 쓰레드 
 * @content 
 - getAllStackTraces() : 실행 중 또는 대기상태, 즉 작업이 완료되지 않은모든 쓰레드의 호출스택 출력 
 - 프로그램을 실행하면, 따로 실행해주는 데몬 쓰레드 외에도 보조작업을 수행하는 데몬 쓰레드들을 자동적으로 생성해서 실행 
 	--> system 스레드 그룹 또는 main 쓰레드 그룹에 속함  

 */
public class ThreadEx11_JVM데몬쓰레드 {
	
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1("Thread 1"); 
		Thread2 t2 = new Thread2("Thread 2"); 
		t1.start();
		t2.start();
		
	} // main 
} // class

class Thread1 extends Thread{
	public Thread1(String name) {
		super(name) ; 
	}
	public void run() {
		try {
			sleep(5*1000) ; // 멤버 메서드를 참조 없이 사용할 수 있다. ex10 - Thread.sleep(1000);
		}catch (InterruptedException e) {}
	} // run 
} // Thread1

class Thread2 extends Thread{
	
	public Thread2(String name) {
		super(name) ; 
	}
	
	public void run() {
		Map map = getAllStackTraces() ;  // 실행 중 또는 대기상태, 즉 작업이 완료되지 않은 모든 쓰레드의 호출 스택 춫력 Map<Thread, StackTraceElement[]>
		Iterator it = map.keySet().iterator();  // Threads 
		
		int x = 0 ; 
		
		while(it.hasNext()) {
			Object obj = it.next(); 
			Thread t = (Thread)obj ; 
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj)); // 호출 스택들 배열 
			
			System.out.println("["+ ++x + "] name :" + t.getName());
			System.out.println("group :" + t.getThreadGroup().getName());
			System.out.println("daemon :" + t.isDaemon());
			
			for (int i = 0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}
			System.out.println();
		} // while
	} // run 
} // Thread2

