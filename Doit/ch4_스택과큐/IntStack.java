package ch4_스택과큐;

/**
 * @author HEEMIN
 * @date 2023. 9. 25.-오후 11:23:51
 *	@subject 스택을 직접 만들어보자 ! 
 * @content 


 */

public class IntStack {
	private int[] stk ;  // 고정길이 스택 : 배열  (고정길이 순서있는 데이터들 --> 배열 , 유동길이 순서있는 데이터들 --> List ) 
	private int capacity ;  // 스택 용량 
	private int pointer ;  // 스택 포인터  --> 채워야할 칸 

	// 실행시 예외 : 스택이 비어있음 
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}  // 생성자 
	}

	// 실행시 예외 : 스택이 가득 참 
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}   // 생성자 
	}

	// 생성자  --> 스택을 생성할 때 벌어지는 일 
	public IntStack(int maxlen) {
		pointer = 0 ;  
		capacity = maxlen ; 

		try {  
			stk = new int[capacity] ; 
		}catch (OutOfMemoryError e) { // 더 이상 메모리에 객체를 생성할 공간이 없을 때 발생하는 에러 
			capacity = 0 ; 
		}
	} // IntStack

	// 메서드 
	public int push(int x) throws OverflowIntStackException{ // x : push 할 데이터 
		if(pointer >= capacity) // index 최대값 : capacity - 1  = pointer 최대값 
			throw new OverflowIntStackException();  // 그 이상 채우려 하면 예외 발생 
		return stk[pointer++] = x  ;  // 해당 포인터가 가리키고 있는 칸에 값을 채우고, pointer을 1 증가시킨다 
	} // push 

	public int pop() throws EmptyIntStackException{
		if(pointer <= 0) // 빼려는 값이 바닥 이하로 내려가려하면 
			/*
			 * 왜 pointer == 0 사용 x ?
			 *	> 뭔가 프로그램 오류 등으로 pointer 값이 잘못되면 0보다 작거사 capacity보다 클 수도 있음 --> 부등호로 스택 본체 배열 범위 벗어나는지 체크 (안정성) 
			 */
			throw new EmptyIntStackException() ;  // 예외 발생 
		return stk[--pointer]  ;  
		// 포인터가 가리키고 있는값 (채울 칸) -1 = 직전에 채운 칸으로 포인터를 이동 (그 위의 값은 어차피 다시 초기화 될테니 사라진걸로 봄 ! ) --> 없앤 값 반환 
	} // pop 

	public int peek() throws EmptyIntStackException{
		if(pointer <= 0)
			throw new EmptyIntStackException() ; 
		return stk[pointer - 1] ;  // pop과 차이점 : pop은 맨 위의 값을 삭제시키니까 pointer '값 자체'를 변화시킴 -->peek은 조회만 하는거니까 pointer에서 1을 뺀 결과값으로만 조회 
	} // peek 

	public void clear() {
		pointer = 0 ; 
	} // clear 

	public int indexOf(int x) {
		for (int i = pointer -1; i >= 0 ; i--) {
			if(stk[i] == x) { // 배열의 요소값과 찾고자하는 값 x와 일치하는게 있다면 ( 꼭데기 -> 바닥으로 선형검색 ! ) 
				return i ;  // 그 index를 반환 !  : 중복 데이터가 있다면 위쪽 데이터 반환 
			}				
		}
		return -1 ; 
	} // indexOf

	public int size() {
		return pointer ; 
	} // size 

	public boolean isEmpty() {
		return pointer <= 0 ; 
	} // isEmpty

	public boolean isFull() { 
		return pointer >= capacity ; 
	} // isFull 

	public void dump() {
		if(pointer <= 0) {
			System.out.println("스택이 비어있습니다");
		}else {
			for (int i = 0; i < pointer; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}

	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity ; 
	}

} // class 
