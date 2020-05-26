import java.util.Arrays;
import java.util.Random;
public class JavaApp {
	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n-1);
	}
	static void quicksort(int[] data, int f, int t) {
		//	������ �ʿ䰡 ���� ��� (�����Ͱ� 1�� ������ ���)
		if(t <= f) return;
		int s = partition(data, f, t);
		quicksort(data, f, s-1);
		quicksort(data, s+1, t);
	}
	static int partition(int[] data, int f, int t) {
		//	�� ������ ���Ҹ� �������� ��´�.
		int pivot = data[t];
		int i=f, j=t-1;
		while(i<=j) {
			//	�������� �����Ͱ� ū ��� ���� ���ҿ� ��ȯ�Ѵ�.
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			}
			else i++;
		}
		//	�Ǻ��� i�� �ִ� ���� ��ȯ�Ѵ�.
		data[t]=data[i];
		data[i]=pivot;
		return i;
	}

	public static void main(String[] args) {
		//	������ ������ 1,000���� �����Ѵ�.
		Random rand = new Random();
		int[] data = new int[1000];
		int[] temp = new int[1000];
		for(int i=0;i<1000;i++) {
			data[i] = rand.nextInt(10000);
			temp[i] = data[i];
		}
		quicksort(data, 1000);
		Arrays.sort(temp);
		int check = 0;
		for(int i=0;i<1000;i++) {
			if(data[i]!=temp[i]) check++;
		}
		System.out.println("Error check is "+check);
	}

}
