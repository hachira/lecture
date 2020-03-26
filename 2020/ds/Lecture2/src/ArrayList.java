//	Implement Array List
public class ArrayList<E> {
	private E a[];			//	a[] 배열에 E 타입의 자료를 저장할 것임.
	private int size;		//	리스트에 들어있는 자료의 갯수
	
	//	생성자 
	public ArrayList() {
		a = (E[]) new Object[1];		//	1개의 원소를 갚는 배열을 생성토록 한다.
		size = 0;			//	비어있는 자료공간이므로 size를 0으로 초기화한다.
	}
	
	//	데이터 추가하는 함수 제작
	//	개념 : 오버플로우(overflow)가 발생하면, 저장할 수 있는 공간을 2배로 늘리도록 하자.
	//	newItem을 배열의 맨 마지막에 추가한다.
	public void append(E newItem) {
		//	오버플로우가 발생하는지 검사
		if(size >= a.length) {
			Object[] t = new Object[size*2];
			for(int i=0; i < size; i++) {
				t[i] = a[i];
			}
			a = (E[]) t;
		}
		a[size++] = newItem;
	}
	
	//	리스트 마지막 원소를 삭제
	public void removeLast() {
		size--;
	}
	
	//	k 인덱스의 값을 가져오는 함수
	public E Get(int k) {
		if(k < 0 || k >= size) { // Error exception
			return a[0];
		}
		return a[k];
	}
	
	//	현재의 배열 크기를 얻어내는 함수
	public int GetSize() { return a.length; }
}

