//	노드를 저장하기 위한 클래스
class Node<E> {
	private E item;
	private Node<E> next;	//	다음 노드를 가르키는 레퍼런스 변수
	//	생성자
	//	newItem	생성되는 노드의 아이템
	//	node 는 생성되는 노드가 끼어들 위치입니다.
	public Node(E newItem, Node<E> node) {
		item = newItem;
		next = node;
	}
	public E getItem() { return item; }
	public Node<E> getNext() { return next; }
	public void setItem(E newItem) { item=newItem; }
	public void setNext(Node<E> newNext) { next=newNext; }
}

public class SList<E> {
	protected Node head;	//	단일 연결 리스트의 첫번째 노드를 가르킬 변수
	
	//	생성자
	public SList() {
		head = null;
	}
	
	//	새로운 아이템 추가
	public void insert(E newItem) {
		head = new Node(newItem, head);
	}
	
	//	맨 앞에 있는 아이템 삭제
	public void remove() {
		if(head==null) { //	Error exception
			return;
		}
		head = head.getNext();
	}
	
	//	연결리스트에 있는 모든 값 출력
	public void show() {
		for(Node t=head; t!=null; t=t.getNext()) {
			System.out.println(t.getItem());
		}
	}
}






