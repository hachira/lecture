import java.util.*;
///	"동전 거스롬돈 문제"
///	k가지 종류의 동전을 가지고 n이라는 돈을 거슬러주되, 최소한의 동전을 사용해서 거슬러주고자 한다.
///	[입력]
///	n k
///	a b ... r
///	[예]
///	200 3
///	5 17 19
///	[답]
///	12
public class JavaApp {
	static int na = 1000000000;
	//	수학자 플라톤의 알고리즘.
	//	초기값과 점화식만 주어지면, 모든 답을 낼 수 있다.
	static int solve1(int n, int k, int[] changes) {
		//	거슬러주어야 할 금액이 0보다 작다면 na를 반환한다.
		if(n<0) return na;
		//	만약 거슬러주어야 할 금액이 0이었다면, 0을 반환.
		if(n==0) return 0;
		//	최소값을 나올 수 없는 가장 큰 값으로 설정하자.
		int min = na;
		//	모든 거스름돈에 대하여 처리
		for(int i=0; i<k; i++) {
			//	i번째 동전을 뺀 금액일 때, 최소 동전의 수를 t에 저장
			int t = solve1(n-changes[i], k, changes) + 1;
			//	t가 min보다 작으면 최솟값 갱신
			if(t<min) min = t;
		}
		//	계산에서 얻어진 최소값 반환
		return min;
	}
	//	메모광 귀차니즘 피카소의 알고리즘.
	//	이미 계산된 결과는 메모를 하자.  그러면 다시 계산할 필요가 없지 않냐?
	static int[] memo;
	static int solve2(int n, int k, int[] changes) {
		memo = new int[n+1];
		for(int i=0;i<=n;i++) memo[i] = 0;
		return solve2r(n, k, changes);
	}
	static int solve2r(int n, int k, int[] changes) {
		//	거슬러주어야 할 금액이 0보다 작다면 na를 반환한다.
		if(n<0) return na;
		//	만약 거슬러주어야 할 금액이 0이었다면, 0을 반환.
		if(n==0) return 0;
		//	메모에 기록된 것이 있다면, 해당 메모를 이용하자.
		if(memo[n]!=0) return memo[n];
		//	최소값을 나올 수 없는 가장 큰 값으로 설정하자.
		int min = na;
		//	모든 거스름돈에 대하여 처리
		for(int i=0; i<k; i++) {
			//	i번째 동전을 뺀 금액일 때, 최소 동전의 수를 t에 저장
			int t = solve2r(n-changes[i], k, changes) + 1;
			//	t가 min보다 작으면 최솟값 갱신
			if(t<min) min = t;
		}
		//	계산에서 얻어진 최소값 반환할 때, 메모에 기록도 한다.
		return memo[n] = min;
	}
	//	공학자 잡스의 알고리즘.
	//	재귀를 사용하지 말고, 작은것부터 문제를 풀어서 큰 것을 풀자.
	static int solve3(int n, int k, int[] changes) {
		//	동적 계획 알고리즘을 수행할 배열공간을 할당
		int[] dp = new int[n+1];
		//	초기값 n=0일때의 값 0을 저장한다.
		dp[0] = 0;
		//	모든 n값에 대하여
		for(int i=1;i<=n;i++) {
			//	최소값을 아주 큰 값으로 설정.
			int min = na;
			for(int j=0;j<k;j++) {
				//	현재 i값보다 동전값이 큰 경우에는 수행하지 않는다.
				if(changes[j]>i) continue;
				//	기존 저장된 값이 min값보다 작다면, min값을 갱신
				if(min>dp[i-changes[j]]+1) min=dp[i-changes[j]]+1;
			}
			//	계산 결과를 dp[]에 저장한다.
			dp[i]=min;
		}
		//	답을 반환
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] changes = new int[k];
		for(int i=0; i < k; i++) {
			changes[i] = scan.nextInt();
		}
		
		long t;
		int ans;
		
		//	점화식을 이용한 경우
		t = System.currentTimeMillis(); 
		ans = solve1(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");

		//	메모를 이용한 경우
		t = System.currentTimeMillis();
		ans = solve2(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");

		//	순방향 프로그램을 이용한 경우
		t = System.currentTimeMillis();
		ans = solve3(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");
	}
}
