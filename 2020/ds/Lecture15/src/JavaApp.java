///	Lecture Week 12
///	Priority Queue(�켱����ť)
import java.util.*;
//	Entry class
//	Entry class�� �켱����ť�� ����Ǵ� �ڷ�������� key�� value�� �̷������.
class Entry<E> {
	int key;		//	priority �� (���� ���� �켱������ ����.)
	E value;		//	value �� (������ ����� ��)
	public Entry(int key, E value) {
		this.key = key;
		this.value = value;
	}
	public int getKey() { return key; }
	public E getValue() { return value; }
}
//	Priority Queue class
//	�켱����ť�� ��(heap)�� ����ؼ� �켱������ ���� ���������� �����Ͱ� �޶�����.
//	���� ũ��� �������̾�� ������, ���⼭�� �� ũ�⸦ ������Ű�ų� ���ҽ�Ű�� �ʴ´�.
//	���� ũ��� ����ϰ� �����ִٴ� �����Ͽ��� ���α׷��� �ۼ���� �Ѵ�.
//	���������� ���� ũ�⸦ �����ϴ� ����� �����ؼ� �ۼ��ؾ� �Ѵ�.
class PriorityQueue<E> {
	Entry<E>[] heap;		//	�� ������
	int size;				//	���� ���� ũ��
	public PriorityQueue() {
		heap = new Entry[100];
		size = 0;
	}
	public void add(int key, E value) {
		Entry<E> e = new Entry<E>(key, value);
		//	���ο� ���� ���� �� ����
		int k = ++size;
		//	������ ������ 1(root)�� �ƴ� �̻�
		while(k > 1) {
			//	k�� �θ�� k/2�̴�.
			int p = k/2;
			//	�θ��� Ű���� ������ �������� Ű������ �۴ٸ�, while������ ����������.
			if(heap[p].getKey() < e.getKey()) break;
			//	�θ��� �����Ͱ��� ������ �����ͷ� �ű��, ������ ���� �� ������ �θ��ε�����
			//	�ٲ۴�.
			heap[k] = heap[p];
			k = p;
		}
		heap[k] = e;
	}
	public E poll() {
		Entry<E> e = heap[1];
		//	���� �� ������ p��� �ϰ�, p�� �ʱ⿡ 1(root)���� ���ִ�.
		//	���� �� �����Ͱ� �ִ� �ε����� k��� �ϰ�, k�� ������ ������� ����.
		//	������ �����ʹ� ������ ���̱� ������ size ���� 1 ���ҽ�Ų��.
		int p = 1;
		int k = size--;
		//	p�� ���ĸ�(leaf)��尡 �ƴ� �� ��� �����Ѵ�.
		while(p*2<=size) {
			//	�ּҰ��� ������ ����� �ε����� �켱 ���� �ڽ����� �����Ѵ�.
			int min = p*2;
			//	������ �ڽ��� �����ϰ�, ������ �ڽ��� Ű���� ���� �ڽ��� Ű������ �۴ٸ�,
			//	min���� ������ �ڽİ����� ����
			if(min<size && heap[min+1].getKey() < heap[min].getKey()) min++;
			//	min Ű���� ���� ������ ������ �������� Ű������ ũ�ٸ� ���� Ż��
			if(heap[min].getKey()>heap[k].getKey()) break;
			//	min �����͸� p ��ġ�� ����
			heap[p] = heap[min];
			//	���� ���� �� ���� �ε����� min �ε����� �ٲ�
			p = min;
		}
		//	���� �� ������ ���� �־��� ������ �����͸� ����
		heap[p] = heap[k];
		return e.getValue();
	}
}
public class JavaApp {
	public static void main(String[] args) {
		PriorityQueue<String> queue= new PriorityQueue<String>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("Enter the command(a/p/q): ");
			String cmd = scan.next();
			//	������ �߰�
			if(cmd.equals("a")) {
				System.out.print("Enter the key : ");
				int key = scan.nextInt();
				System.out.print("Enter the value : ");
				String value = scan.next();
				queue.add(key, value);
			}
			//	���� �켱������ ���� ������ ������
			else if(cmd.equals("p")) {
				System.out.println("Polled data : "+queue.poll());
			}
			//	����
			else if(cmd.equals("q")) break;
		}
	}
}
