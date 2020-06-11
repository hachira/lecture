///	Lecture Week 12
///	Priority Queue(우선순위큐)
import java.util.*;
//	Entry class
//	Entry class는 우선순위큐에 저장되는 자료공간으로 key와 value로 이루어진다.
class Entry<E> {
	int key;		//	priority 값 (작을 수록 우선순위가 높다.)
	E value;		//	value 값 (실제로 사용할 값)
	public Entry(int key, E value) {
		this.key = key;
		this.value = value;
	}
	public int getKey() { return key; }
	public E getValue() { return value; }
}
//	Priority Queue class
//	우선순위큐는 힙(heap)을 사용해서 우선순위에 따라 빠져나오는 데이터가 달라진다.
//	힙의 크기는 가변적이어야 옳지만, 여기서는 힙 크기를 증가시키거나 감소시키지 않는다.
//	힙의 크기는 충분하게 잡혀있다는 가정하에서 프로그램을 작성토록 한다.
//	현업에서는 힙의 크기를 조절하는 방안을 구상해서 작성해야 한다.
class PriorityQueue<E> {
	Entry<E>[] heap;		//	힙 데이터
	int size;				//	현재 힙의 크기
	public PriorityQueue() {
		heap = new Entry[100];
		size = 0;
	}
	public void add(int key, E value) {
		Entry<E> e = new Entry<E>(key, value);
		//	새로운 값이 들어가야 할 공간
		int k = ++size;
		//	들어가야할 공간이 1(root)가 아닌 이상
		while(k > 1) {
			//	k의 부모는 k/2이다.
			int p = k/2;
			//	부모의 키값이 들어가야할 데이터의 키값보다 작다면, while루프를 빠져나간다.
			if(heap[p].getKey() < e.getKey()) break;
			//	부모의 데이터값을 들어가야할 데이터로 옮기고, 다음번 들어가야 할 공간을 부모인덱스로
			//	바꾼다.
			heap[k] = heap[p];
			k = p;
		}
		heap[k] = e;
	}
	public E poll() {
		Entry<E> e = heap[1];
		//	들어가야 할 공간을 p라고 하고, p는 초기에 1(root)값이 들어가있다.
		//	들어가야 할 데이터가 있는 인덱스는 k라고 하고, k는 현재의 사이즈값이 들어간다.
		//	마지막 데이터는 삭제될 것이기 때문에 size 값을 1 감소시킨다.
		int p = 1;
		int k = size--;
		//	p가 이파리(leaf)노드가 아닌 한 계속 수행한다.
		while(p*2<=size) {
			//	최소값을 가지는 노드의 인덱스를 우선 왼쪽 자식으로 설정한다.
			int min = p*2;
			//	오른쪽 자식이 존재하고, 오른쪽 자식의 키값이 왼쪽 자식의 키값보다 작다면,
			//	min값을 오른쪽 자식값으로 설정
			if(min<size && heap[min+1].getKey() < heap[min].getKey()) min++;
			//	min 키값이 현재 들어가야할 공간의 데이터의 키값보다 크다면 루프 탈출
			if(heap[min].getKey()>heap[k].getKey()) break;
			//	min 데이터를 p 위치에 복사
			heap[p] = heap[min];
			//	다음 들어가야 할 공간 인덱스를 min 인덱스로 바꿈
			p = min;
		}
		//	들어가야 할 공간에 힙에 있었던 마지막 데이터를 복사
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
			//	데이터 추가
			if(cmd.equals("a")) {
				System.out.print("Enter the key : ");
				int key = scan.nextInt();
				System.out.print("Enter the value : ");
				String value = scan.next();
				queue.add(key, value);
			}
			//	가장 우선순위가 높은 데이터 꺼내기
			else if(cmd.equals("p")) {
				System.out.println("Polled data : "+queue.poll());
			}
			//	종료
			else if(cmd.equals("q")) break;
		}
	}
}
