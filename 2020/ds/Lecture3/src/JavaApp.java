//	이중연결리스트를 위한 노드 클래스
class DNode<E> {
	private E item;			//	데이터를 저장할 변수
	private DNode next;		//	다음 노드를 가르킬 변수
	private DNode prev;		//	이전 노드를 가르킬 변수
	//	생성자
	public DNode() {
		prev = this;
		next = this;
	}
	public DNode(E newItem, DNode p, DNode n) {
		item = newItem;
		prev = p;
		next = n;
	}
	//	private로 선언된 변수들을 액세스할 수 있는 메소드들 정의
	public E getItem() { return item; }
	public DNode getNext() { return next; }
	public DNode getPrev() { return prev; }
	public void setNext(DNode n) { next=n; }
	public void setPrev(DNode p) { prev=p; }
}

//	이중연결 리스트를 관리하기 위한 클래스
class DList<E> {
	private DNode head;		//	비어있는 head 노드
	private DNode cur;		//	현재 참조하는 노드
	//	생성자
	public DList() {
		head = new DNode();
		cur = head;
	}
	//	비어있는지 검사하는 함수
	public boolean empty() {
		return head.getNext() == head;
	}
	public void insert(E newItem) {
		insert(cur, newItem);
	}
	//	주어진 노드 앞에 새로운 노드 끼어넣기
	public void insert(DNode cur, E newItem) {
		DNode node = new DNode(newItem, cur.getPrev(), cur);
		cur.setPrev(node);
		node.getPrev().setNext(node);
	}
	//	주어진 노드 삭제
	public void remove(DNode cur) {
		cur.getPrev().setNext(cur.getNext());
		cur.getNext().setPrev(cur.getPrev());
	}
	//	헤드값을 가져오기
	public DNode getHead() { return head; }
}

public class JavaApp {
	public static void main(String[] args) {
		DList<String> list = new DList<String>();
		DNode<String> head = list.getHead();
		list.insert(head, "apple");
		list.insert(head, "orange");
		list.insert(head, "banana");
		//	순방향으로 리스트 순회
		System.out.println("Forward traversal");
		for(DNode<String> t=head.getNext(); t!=head; t=t.getNext())
			System.out.println(t.getItem());
		//	역방향으로 리스트 순회
		System.out.println("Backward traversal");
		for(DNode<String> t=head.getPrev(); t!=head; t=t.getPrev())
			System.out.println(t.getItem());
		//	head의 다음노드 아이템을 삭제하자.
		list.remove(head.getNext());
		System.out.println("After remove apple");
		for(DNode<String> t=head.getNext(); t!=head; t=t.getNext())
			System.out.println(t.getItem());
	}

}

