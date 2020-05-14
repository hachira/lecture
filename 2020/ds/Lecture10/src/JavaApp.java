import java.util.Random;

public class JavaApp {
	//	최대값 찾기
	static void GetMax() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	1,000 이하의 랜덤수를 생성해서 arr에 저장
		for(int i=0;i<10;i++) {
			arr[i] = rand.nextInt(1000);
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		//	10개의 숫자중에 최대값을 찾기
		int max=arr[0];
		for(int i=1;i<10;i++) {
			if(max<arr[i]) max=arr[i];
		}
		System.out.println("Max value is "+max);
	}
	//	임의의 배열에 임의의 숫자 찾기
	static void FindSome() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	20 이하의 랜덤수를 생성해서 arr에 저장
		for(int i=0;i<10;i++) {
			arr[i] = rand.nextInt(20);
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		int find = rand.nextInt(20);
		int found = -1;		//	현재 찾지 못 했을 경우 -1을 설정
		System.out.println("Finding -- "+find);
		for(int i=0;i<10;i++) {
			if(arr[i]==find) { found=i; break; }
		}
		if(found==-1) System.out.println("Not found.");
		else System.out.println("Found "+(found+1)+"th slot.");
	}
	//	정렬된 배열에서 임의의 숫자 찾기
	static void FindOnSorted() {
		int[] arr = new int[10];
		Random rand = new Random();
		//	랜덤수를 생성해서 arr에 저장
		arr[0] = rand.nextInt(3);
		System.out.print(arr[0]+" ");
		for(int i=1;i<10;i++) {
			arr[i] = arr[i-1]+rand.nextInt(2)+1;
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		//	이진탐색(Binary Search)를 이용해서 찾아보자.
		int find = rand.nextInt(arr[9])+1;
		System.out.println("Finding "+find);
		int s=0, e=9, found=-1;
		while(s<=e) {
			//	중앙값 인덱스를 찾는다.
			int m = (s+e)/2;
			System.out.println("Checking arr["+m+"]="+arr[m]);
			if(arr[m]==find) { found=m; break; }
			if(arr[m]>find) e=m-1;
			else s=m+1;
		}
		if(found==-1) System.out.println("Not found");
		else System.out.println("Found at "+(found+1)+"th slot.");
	}
	//	동전 거스름돈 최소 갯수 구하기
	//	500원, 100원, 10원짜리로 바꾸기
	static void GetChange() {
		Random rand = new Random();
		int amount = rand.nextInt(1000)*10;
		System.out.println("바꾸어야 할 돈 : "+amount+"원");
		//	여러분들이 작성해보세요.
	}
	//	가짜 동전 찾기
	static void FindFakeCoin() {
		Random rand = new Random();
		int[] coins = new int[1000];
		int fake = rand.nextInt(1000);
		for(int i=0;i<1000;i++) {
			if(i==fake) coins[i]=-1;
			else coins[i]=0;
		}
		//	순차적으로 가짜동전 찾기(철수의 생각)
		int trial=0;
		for(int i = 1;i<1000;i++) {
			trial++;
			if(coins[0]==coins[i]) continue;
			if(coins[0]<coins[i]) System.out.println("coins[0] is fake.");
			else System.out.println("coins["+i+"] is fake.");
			break;
		}
		System.out.println("trial is "+trial);
		//	두개씩 비교해서 가짜동전 찾기(영희의 생각)
		trial = 0;
		for(int i=0;i<1000;i+=2) {
			trial++;
			if(coins[i]==coins[i+1]) continue;
			if(coins[i]<coins[i+1]) System.out.println("coins["+i+"] is fake.");
			else System.out.println("coins["+(i+1)+"] is fake.");
			break;
		}
		System.out.println("trial is "+trial);
		//	이분해서 해결하기
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
