package LinkedList;

class Node{
	int data ; 
	Node prev, next ; 
	
	public Node(int data) {
		this.data = data ; 
		this.prev = this.next = null ; 
	}
	
	void insertNext(Node u , Node singleton) {
		// 연결리스트내 노드 u 뒤에 single톤 노드 삽입 
		singleton.prev = u ; 
		singleton.next = u.next; 
		
		if(null != singleton.prev) {
			singleton.prev.next = singleton ; 
		}
		if(null != singleton.next)
			singleton.next.prev = singleton ; 
	}
	
	void pop(Node u) {
		// u의 이전노드와 다음 노드를 서로 이어줌 
		if(null != u.prev)
			u.prev.next = u.next ; 
		if(null != u.next)
			u.next.prev = u.prev ; 
		
		u.prev = u.next = null ; // u는 연결리스트와 관계없는 단일 노드가 됨 
	}
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		Node node = new Node(42) ; // 단일노드 (싱글톤) 
		
		

	} // main 
} // class
