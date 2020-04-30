import java.util.*;

//	HashTable 안에 저장될 <Key, Value> 쌍
class Elem {
	String key;
	String value;
	Elem(String f, String s) {
		key = f;
		value = s;
	}
	String getKey() { return key; }
	String getValue() { return value; }
}

//	Linked List Node class
class LNode {
	String key, value;
	LNode next;
	LNode(String k, String v) {
		key = k;
		value = v;
	}
	LNode getNext() { return next; }
	void setNext(LNode n) { next = n; }
	String getKey() { return key; }
	String getValue() { return value; }
}

class LHashTable {
	LNode[] data;
	LHashTable(int size) {
		data = new LNode[size];
	}
	void put(String key, String value) {
		LNode node = new LNode(key, value);
		int h = (key.hashCode()&0x7fffffff)%data.length;
		node.setNext(data[h]);
		data[h] = node;
	}
	String get(String key) {
		int h = (key.hashCode()&0x7fffffff)%data.length;
		for(LNode t = data[h]; t != null ; t = t.getNext()) {
			if(t.getKey().equals(key)) return t.getValue();
		}
		return null;
	}
	void show() {
		for(int i=0;i<data.length;i++) {
			if(data[i]==null) continue;
			System.out.print(i+" ");
			for(LNode t = data[i]; t != null; t = t.getNext()) {
				System.out.print("["+t.getKey()+":"+t.getValue()+"]");
			}
			System.out.println("\\");
		}
	}
}

class HashTable {
	int size;	//	Hash table의 크기
	Elem[] data;	//	Hash table의 데이터를 넣을 공간
	HashTable(Elem[] arr) {
		data = arr;
		size = arr.length;
	}
	void put(String key, String value) {
		int hash = key.hashCode() & 0x7fffffff;
		int h = hash%size;
		int h2 = hash%23;
		//	선형조사를 이용해서 빈 공간을 찾도록 한다.
		for(int i=0;i<size;i++) {
			if(data[(h+i*h2)%size]==null) {
				data[(h+i*h2)%size] = new Elem(key, value);
				break;
			}
		}
	}
	String get(String key) {
		int hash = key.hashCode() & 0x7fffffff;
		int h = hash%size;
		int h2 = hash%23;
		//	선형조사를 이용해서 해당 키를 찾도록 한다.
		for(int i=0;i<size;i++) {
			Elem e = data[(h+i*h2)%size];
			if(e==null) return null;
			if(e.getKey().equals(key)) return e.getValue();
		}
		return null;
	}
	void show() {
		for(int i=0; i < size; i++) {
			if(data[i]==null) continue;
			System.out.println(
					i + ":(" + data[i].getKey()+", "
					+data[i].getValue()+")");
		}
	}
}

public class JavaApp {
	public static void main(String[] args) {
		/*
		Elem[] array = new Elem[10]; 
		HashTable ht = new HashTable(array);
		*/
		LHashTable ht = new LHashTable(10);
		Scanner sc = new Scanner(System.in);
		while(true) {
			String cmd = sc.next();
			if(cmd.equals("quit")) break;
			if(cmd.equals("put")) {
				String key = sc.next();
				String value = sc.next();
				ht.put(key, value);
			}
			else if(cmd.equals("get")) {
				String key = sc.next();
				System.out.println(key+":"+ht.get(key));
			}
			else if(cmd.equals("show")) {
				ht.show();
			}
		}
	}
}

