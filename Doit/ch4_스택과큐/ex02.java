package ch4_스택과큐;

import java.util.Scanner;

/**
 * @author HEEMIN
 * @date 2023. 9. 29.-오후 6:57:22
 *	@subject 만든 스택을 사용해보자 ! 
 * @content 


 */
public class ex02 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		IntStack stack = new IntStack(64) ; 
		
		while(true) {
			System.out.println(); 
			System.out.printf("현재 데이터 개수 : %d / %d\n", stack.size(), stack.getCapacity( ));
			System.out.print("(1) 푸시  (2) 팝  (3) 피크  (4) 덤프  (0) 종료 : ");
			
			int menu = sc.nextInt() ; 
			if(menu == 0) {
				break ; 
			}
			
			int x ; 
			
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = sc.nextInt() ; 
				
				try {
					stack.push(x) ; 
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다");
				}
				break;
				
			case 2:
				
				try {
					stack.pop() ; 
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다");
				}
				break;
				
			case 3:
				try {
					x = stack.peek() ; 
					System.out.println("피크한 데이터는 "+ x+ "입니다");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다");
				}
				break;
				
			case 4:
				stack.dump() ; 
				break ; 		
			} // switch
		} // while
		
	} // main 
	

} // class 
