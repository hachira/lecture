import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class JavaApp {
	//	<summary>partition data by pivot</sumarry>
	static int partition(int[] data, int s, int e) {
		//	마지막 데이터를 피봇값으로 설정한다.
		int pivot = data[e];
		//	i는 데이터 첫값을, j는 데이터 마지막값을 가르킨다.
		//	while(...)문에서는 다음과 같은 상태가 유지된다.
		//	data[i], data[j]는 현재 모르는 미지의 값이 들어가있다.
		//	data[s..i-1]에는 pivot보다 작은 값이 들어가있다.
		//	data[j+1..e-1]에는 pivot보다 큰 값이 들어가있다.
		//	데이터가 있다면 i<=j 조건이 유지된다.
		int i=s, j=e-1;
		while(i<=j) {  // 미지의 데이터값이 있는한 계속한다.
			if(data[i]<pivot) i++;
			else {
				int t = data[i];
				data[i] = data[j];
				data[j] = t;
				j--;
			}
		}
		//	pivot데이터를 파티션한 경계에 넣기 위해서
		//	data[i]와 data[e]와 교환한다.
		data[e]=data[i];
		data[i]=pivot;
		//	pivot이 있는 위치의 배열 인덱스를 반환한다.
		return i;
	}
	//	data[0..n-1]에서 k번째로 작은 데이터를 찾는다.
	static int nth_element(int[] data, int n, int k) {
		return nth_element(data, 0, n-1, k);
	}
	//	data[s..e]에서 k번째로 작은 데이터를 찾는다.
	static int nth_element(int[] data, int s, int e, int k) {
		//	data[s..e]를 피봇값에 의해서 분리한다.
		int p = partition(data, s, e);
		//	k가 피봇보다 작은 그룹에 속해있는 경우
		if(k<=p-s) return nth_element(data, s, p-1, k);
		//	k가 피봇인 경우
		if(k==p-s+1) return data[p];
		//	k가 피봇보다 큰 그룹에 속해있는 경우
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
		//	찾고자 하는 원소를 랜덤으로 생성( 1<= k <= 1000 )
		int k = rand.nextInt(n)+1;
		System.out.println(k+"번째 작은 숫자는 "+
				nth_element(data, n, k)+"이다.");
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
		r = System.currentTimeMillis();
		Arrays.sort(t);
		System.out.println("sort check : "+t[k-1]);
		System.out.println("elapsed time : "+(System.currentTimeMillis()-r));
	}

}
