import java.io.*;
//	이진트리의 노드를 설정
class Node<E extends Comparable<E>> {
	private E item;
	private Node<E> left, right;
	//	생성자
	public Node(E newItem, Node<E> l, Node<E> r) {
		item = newItem;
		left = l;
		right = r;
	}
	public E get() { return item; }
	public void set(E newItem) { item = newItem; }
	public Node<E> getLeft() { return left; }
	public Node<E> getRight() { return right; }
	public void setLeft(Node<E> l) { left = l; }
	public void setRight(Node<E> r) { right = r; }
}
//	이진트리 클래스
class BinaryTree<E extends Comparable<E>> {
	private Node<E> root;
	//	생성자
	public BinaryTree() { root = null; }
	public Node<E> getRoot() { return root; }
	//	순회
	public void PreTrav() { PreTrav(root); }
	public void PreTrav(Node<E> r) {
		if(r == null) return;
		//	전위순회의 경우에는 현재 노드의 값을 먼저 출력한다.
		System.out.println(r.get());
		//	왼쪽 자식을 방문토록 한다.
		PreTrav(r.getLeft());
		//	오른쪽 자식을 방문토록 한다.
		PreTrav(r.getRight());
	}
	public void InTrav() { InTrav(root); }
	public void InTrav(Node<E> r) {
		if(r == null) return;
		//	왼쪽 자식을 방문토록 한다.
		InTrav(r.getLeft());
		//	중위순회의 경우에는 현재 노드의 값을 왼쪽자식 방문후 출력한다.
		System.out.println(r.get());
		//	오른쪽 자식을 방문토록 한다.
		InTrav(r.getRight());
	}
	public void PostTrav() { PostTrav(root); }
	public void PostTrav(Node<E> r) {
		if(r == null) return;
		//	왼쪽 자식을 방문토록 한다.
		PostTrav(r.getLeft());
		//	오른쪽 자식을 방문토록 한다.
		PostTrav(r.getRight());
		//	후위순회의 경우에는 현재 노드의 값을 모든자식 방문후 출력한다.
		System.out.println(r.get());
	}
	//	찾기
	public E Find(E item) {
		return Find(root, item);
	}
	public E Find(Node<E> r, E item) {
		//	찾는 데이터가 없는 경우
		if(r == null) {
			return null;
		}
		int t = item.compareTo(r.get());
		if(t == 0) return r.get();
		if(t < 0) return Find(r.getLeft(), item);
		return Find(r.getRight(), item);
	}
	//	삽입
	public void Insert(E newItem) {
		root = Insert(root, newItem);
	}
	public Node<E> Insert(Node<E> r, E newItem) {
		if(r==null) {
			r = new Node<E>(newItem, null, null);
			return r;
		}
		if(newItem.compareTo(r.get()) < 0) {
			r.setLeft(Insert(r.getLeft(), newItem));
		}
		else {
			r.setRight(Insert(r.getRight(), newItem));
		}
		return r;
	}
	//	최솟값 찾기
	public Node<E> GetMin() {
		//	트리가 비어있는 경우, 최솟값을 찾을 수 없으므로 null 반환
		if(root==null) return null;
		return GetMin(root);
	}
	public Node<E> GetMin(Node<E> r) {
		if(r.getLeft() == null) return r;
		return GetMin(r.getLeft());
	}
	//	최솟값 삭제하기
	public void RemoveMin() {
		//	트리가 비어있는 경우, 최솟값을 찾을 수 없으므로 null 반환
		if(root==null) return;
		root = RemoveMin(root);
	}
	public Node<E> RemoveMin(Node<E> r) {
		if(r.getLeft() == null) return r.getRight();
		r.setLeft(RemoveMin(r.getLeft()));
		return r;
	}
	//	삭제연산
	public void Remove(E item) {
		root = Remove(root, item);
	}
	public Node<E> Remove(Node<E> r, E item) {
		//	item과 같은 것을 찾지 못 한 경우.
		if(r==null) return null;
		//	item과 비교해서, 삭제할 것인지, 순회할 것인지 결정한다.
		int t = item.compareTo(r.get());
		//	같은 경우엔 삭제
		if(t==0) {
			//	case 0 : 자식이 하나도 없는 경우
			if(r.getLeft()==null && r.getRight()==null) return null;
			//	case 1 : 자식이 하나 있는 경우
			if(r.getLeft()==null) return r.getRight();
			if(r.getRight()==null) return r.getLeft();
			//	case 2 : 자식이 두개인 경우
			Node<E> min = GetMin(r.getRight());
			min.setRight(RemoveMin(r.getRight()));
			return min;
		}
		if(t < 0) {
			r.setLeft(Remove(r.getLeft(), item));;
			return r;
		}
		else {
			r.setRight(Remove(r.getRight(), item));;
			return r;
		}
	}
	//	트리에 있는 노드의 갯수
	public int Size() { return Size(root); }
	public int Size(Node<E> r) {
		if(r==null) return 0;
		return Size(r.getLeft())+Size(r.getRight())+1;
	}
}
public class JavaApp {

	public static void main(String[] args) throws Exception {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.print("Enter command : ");
			String cmd = br.readLine();
			if(cmd.contains("quit")) break;
			if(cmd.contains("insert")) {
				System.out.print("Enter item to input : ");
				String param = br.readLine();
				tree.Insert(Integer.parseInt(param));
			}
			else if(cmd.contains("find")) {
				System.out.print("Enter item to find : ");
				String param = br.readLine();
				Integer res = tree.Find(Integer.parseInt(param));
				if(res==null) System.out.println("Not found");
				else System.out.println("Found");
			}
			else if(cmd.contains("remove")) {
				System.out.print("Enter item to remove : ");
				String param = br.readLine();
				tree.Remove(Integer.parseInt(param));
			}
			tree.InTrav();
		}
	}

}
