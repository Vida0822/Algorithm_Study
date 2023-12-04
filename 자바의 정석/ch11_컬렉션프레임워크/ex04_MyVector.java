package ch11_컬렉션프레임워크;

/**
 * @author HEEMIN
 * @date 2023. 9. 5.-오후 12:01:51
 *	@subject Vector 
 * @content  Vector 클래스를 직접 구현해보자 


 */
public class ex04_MyVector {
	
	// 필드 
	Object[] data = null ; // 백터는 객체배열이다 
	int capacity = 0; // 용량  
	int size = 0;  // 크기 
	
	// 생성자 
	public ex04_MyVector(int capacity) {
		if(capacity<0)
			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity) ; 
		
		this.capacity = capacity; 
		data = new Object[capacity] ; 
	}
	
	public ex04_MyVector() {
		this(10); 
	} 
	
	// 메서드 
	/* 용량, 사이즈 관련 */ 
	public void ensureCapacity(int minCapacity) {
		if(minCapacity - data.length > 0) 
			setCapacity(minCapacity) ; 
	}

	private void setCapacity(int minCapacity) { // 얘한테는 직접 접근 불가 
		
		if(this.capacity==capacity) return; 
		
		// point : Vector(객체 배열) 용량 변경 메서드는 실제로 전달받은 크기로 새로운 객체배열을 생성한 후 , 
		// 			 기존 배열의 0번째(처음부터) 새로운 배열의 0번째로 size 만큼 요소를 옮긴다 
		Object[] tmp = new Object[capacity] ;  
		System.arraycopy(data, 0, tmp, 0, size); 
		
		data=tmp;  // 그렇게 복사한 객체배열을 참조변수 data로 교체한다 (주소값 참조 변경) 
		this.capacity = capacity; // 필드, 용량도 바꾼다.
		
	} // setCapacity
	
	public void trimToSize() { 
		setCapacity(size);
	}  // trimToSize
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null ; // 요소칸을 하나씩 비우고 
		} //for 
		size = 0 ; // 다 비우면 size = 0 
	} // clear
	
	public boolean isEmpty() {return size ==0 ; }  //  size ==0 --> true or false 

	public int capacity() {return capacity; } 
	
	public int size() {return size ; } 
 	
	
	
	/* CRUD 관련 */ 
	public boolean add(Object obj) {
		
		ensureCapacity(size+1); // 1. 용량 먼저 늘리고 
		data[size++] = obj;  // 2. 사이즈 늘려서 해당 size번째 index에 3. 전달받은 객체 삽입 
		
		return true;  
	} // add 
	
	public Object get(int index) {
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException("범위를 벗어났습니다. "); 
		return data[index] ; 
	} // get
	
	public Object remove(int index) {
		Object oldobj = null ; 
		
		if (index != size-1) { // 삭제하는 요소가 가장 끝의 요소가 아니라면 
			System.arraycopy(data, index+1 // 삭제할 위치 다음번째부터 끝까지의 요소를 
					, data, index // 삭제할 위치부터 
					, size-index-1); // 삭제할 위치+1부터 남은 데이터를 덮어쓰기 한다 (한칸씩 땡긴다) 
		} // if 
		
		data[size-1] = null ;  // 끝의 요소는 비우고 
		size-- ; // 사이즈도 줄ㅇㅁ 
		 
		return oldobj ;  // 삭제한 object 반환 
		
	} // remove(index) 
	
	public boolean remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if(obj.equals(data[i])) { // equals 는 값만 비교한다 (== 는 주소까지 비교) 
				remove(i); 
				return true ; 
			} // if 
		} // for 
		return false ;  // 무사히 반복문을 빠져나오면 (삭제 요청한 객체가 해당 배열에 없으면) 
		
	}// remove (Object) 
	
	
	/* 형변환 */ 
	public Object[] toArray() { // Vector의 객체배열만 반환하는 메서드 
		
		Object[] result = new Object[size]; 
		System.arraycopy(data, 0, result, 0, size);  
		
		return result; 

	} // toArray() 
	
	
	
	
	 
	
	


}
