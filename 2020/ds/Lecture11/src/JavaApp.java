import java.util.Arrays;
import java.util.Random;
public class JavaApp {
	static void quicksort(int[] data, int n) {
		quicksort(data, 0, n-1);
	}
	static void quicksort(int[] data, int f, int t) {
		//	정렬할 필요가 없는 경우 (데이터가 1개 이하인 경우)
		if(t <= f) return;
		int s = partition(data, f, t);
		quicksort(data, f, s-1);
		quicksort(data, s+1, t);
	}
	static int partition(int[] data, int f, int t) {
		//	맨 마지막 원소를 피폿으로 잡는다.
		int pivot = data[t];
		int i=f, j=t-1;
		while(i<=j) {
			//	피폿보다 데이터가 큰 경우 뒤의 원소와 교환한다.
			if(pivot < data[i]) {
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
				j--;
			}
			else i++;
		}
		//	피봇과 i에 있는 값과 교환한다.
		data[t]=data[i];
		data[i]=pivot;
		return i;
	}

	public static void main(String[] args) {
		//	랜덤한 데이터 1,000개를 생성한다.
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
