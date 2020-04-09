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
	//	트리에 있는 노드의 갯수
	public int Size() { return Size(root); }
	public int Size(Node<E> r) {
		if(r==null) return 0;
		return Size(r.getLeft())+Size(r.getRight())+1;
	}
}
public class JavaApp {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.Insert(5);
		tree.Insert(2);
		tree.Insert(4);
		System.out.println("size = "+tree.Size());
		System.out.println("Preorder");
		tree.PreTrav();
		System.out.println("Inorder");
		tree.InTrav();
		System.out.println("Postorder");
		tree.PostTrav();
		tree.Insert(8);
		System.out.println("size = "+tree.Size());
		System.out.println("Preorder");
		tree.PreTrav();
		System.out.println("Inorder");
		tree.InTrav();
		System.out.println("Postorder");
		tree.PostTrav();
	}

}
