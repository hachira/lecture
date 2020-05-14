import java.util.Random;

public class JavaApp {
	//	�ִ밪 ã��
	static void GetMax() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	1,000 ������ �������� �����ؼ� arr�� ����
		for(int i=0;i<10;i++) {
			arr[i] = rand.nextInt(1000);
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		//	10���� �����߿� �ִ밪�� ã��
		int max=arr[0];
		for(int i=1;i<10;i++) {
			if(max<arr[i]) max=arr[i];
		}
		System.out.println("Max value is "+max);
	}
	//	������ �迭�� ������ ���� ã��
	static void FindSome() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	20 ������ �������� �����ؼ� arr�� ����
		for(int i=0;i<10;i++) {
			arr[i] = rand.nextInt(20);
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		int find = rand.nextInt(20);
		int found = -1;		//	���� ã�� �� ���� ��� -1�� ����
		System.out.println("Finding -- "+find);
		for(int i=0;i<10;i++) {
			if(arr[i]==find) { found=i; break; }
		}
		if(found==-1) System.out.println("Not found.");
		else System.out.println("Found "+(found+1)+"th slot.");
	}
	//	���ĵ� �迭���� ������ ���� ã��
	static void FindOnSorted() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	�������� �����ؼ� arr�� ����
		arr[0] = rand.nextInt(3);
		System.out.print(arr[0]+" ");
		for(int i=1;i<10;i++) {
			arr[i] = arr[i-1]+rand.nextInt(2)+1;
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		//	����Ž��(Binary Search)�� �̿��ؼ� ã�ƺ���.
		int find = rand.nextInt(arr[9])+1;
		System.out.println("Finding "+find);
		int s=0, e=9, found=-1;
		while(s<=e) {
			//	�߾Ӱ� �ε����� ã�´�.
			int m = (s+e)/2;
			System.out.println("Checking arr["+m+"]="+arr[m]);
			if(arr[m]==find) { found=m; break; }
			if(arr[m]>find) e=m-1;
			else s=m+1;
		}
		if(found==-1) System.out.println("Not found");
		else System.out.println("Found at "+(found+1)+"th slot.");
	}
	//	���� �Ž����� �ּ� ���� ���ϱ�
	//	500��, 100��, 10��¥���� �ٲٱ�
	static void GetChange() {
		Random rand = new Random();
		int amount = rand.nextInt(1000)*10;
		System.out.println("�ٲپ�� �� �� : "+amount+"��");
		//	�����е��� �ۼ��غ�����.
	}
	//	��¥ ���� ã��
	static void FindFakeCoin() {
		Random rand = new Random();
		int[] coins = new int[1000];
		int fake = rand.nextInt(1000);
		for(int i=0;i<1000;i++) {
			if(i==fake) coins[i]=-1;
			else coins[i]=0;
		}
		//	���������� ��¥���� ã��(ö���� ����)
		int trial=0;
		for(int i = 1;i<1000;i++) {
			trial++;
			if(coins[0]==coins[i]) continue;
			if(coins[0]<coins[i]) System.out.println("coins[0] is fake.");
			else System.out.println("coins["+i+"] is fake.");
			break;
		}
		System.out.println("trial is "+trial);
		//	�ΰ��� ���ؼ� ��¥���� ã��(������ ����)
		trial = 0;
		for(int i=0;i<1000;i+=2) {
			trial++;
			if(coins[i]==coins[i+1]) continue;
			if(coins[i]<coins[i+1]) System.out.println("coins["+i+"] is fake.");
			else System.out.println("coins["+(i+1)+"] is fake.");
			break;
		}
		System.out.println("trial is "+trial);
		//	�̺��ؼ� �ذ��ϱ�
		trial = 0;
		int s = 0, e = 999;
		while(s<=e) {
			trial++;
			int m = (s+e)/2;
			int s1 = 0, s2 = 0;
			for(int i=s;i<m;i++) { s1+=coins[i]; s2+=coins[i-s+m+1]; }
			if(s1 == s2) {
				System.out.println("cooins["+e+"] is fake.");
				break;
			}
			if(s1 < s2) e = m-1;
			else s = m;
		}
		System.out.println("trial is "+trial);
	}
	
	public static void main(String[] args) {
		FindFakeCoin();
	}

}
