import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class JavaApp {
	//	<summary>partition data by pivot</sumarry>
	static int partition(int[] data, int s, int e) {
		//	������ �����͸� �Ǻ������� �����Ѵ�.
		int pivot = data[e];
		//	i�� ������ ù����, j�� ������ ���������� ����Ų��.
		//	while(...)�������� ������ ���� ���°� �����ȴ�.
		//	data[i], data[j]�� ���� �𸣴� ������ ���� ���ִ�.
		//	data[s..i-1]���� pivot���� ���� ���� ���ִ�.
		//	data[j+1..e-1]���� pivot���� ū ���� ���ִ�.
		//	�����Ͱ� �ִٸ� i<=j ������ �����ȴ�.
		int i=s, j=e-1;
		while(i<=j) {  // ������ �����Ͱ��� �ִ��� ����Ѵ�.
			if(data[i]<pivot) i++;
			else {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
				j--;
			}
		}
		//	pivot�����͸� ��Ƽ���� ��迡 �ֱ� ���ؼ�
		//	data[i]�� data[e]�� ��ȯ�Ѵ�.
		data[e]=data[i];
		data[i]=pivot;
		//	pivot�� �ִ� ��ġ�� �迭 �ε����� ��ȯ�Ѵ�.
		return i;
	}
	//	data[0..n-1]���� k��°�� ���� �����͸� ã�´�.
	static int nth_element(int[] data, int n, int k) {
		return nth_element(data, 0, n-1, k);
	}
	//	data[s..e]���� k��°�� ���� �����͸� ã�´�.
	static int nth_element(int[] data, int s, int e, int k) {
		//	data[s..e]�� �Ǻ����� ���ؼ� �и��Ѵ�.
		int p = partition(data, s, e);
		//	k�� �Ǻ����� ���� �׷쿡 �����ִ� ���
		if(k<=p-s) return nth_element(data, s, p-1, k);
		//	k�� �Ǻ��� ���
		if(k==p-s+1) return data[p];
		//	k�� �Ǻ����� ū �׷쿡 �����ִ� ���
		return nth_element(data, p+1, e, k-p+s-1);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int n = 1000000;
		int[] data = new int[n];
		int[] t = new int[n];
		for(int i=0;i<n;i++) {
			data[i] = rand.nextInt(10000);
			t[i] = data[i];
		}
		long r = System.currentTimeMillis();
		//	ã���� �ϴ� ���Ҹ� �������� ����( 1<= k <= 1000 )
		int k = rand.nextInt(n)+1;
		System.out.println(k+"��° ���� ���ڴ� "+
				nth_element(data, n, k)+"�̴�.");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println("sort check : "+t[k-1]);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
	}

}
