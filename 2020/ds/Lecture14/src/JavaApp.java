import java.util.*;
///	"���� �Ž��ҵ� ����"
///	k���� ������ ������ ������ n�̶�� ���� �Ž����ֵ�, �ּ����� ������ ����ؼ� �Ž����ְ��� �Ѵ�.
///	[�Է�]
///	n k
///	a b ... r
///	[��]
///	200 3
///	5 17 19
///	[��]
///	12
public class JavaApp {
	static int na = 1000000000;
	//	������ �ö����� �˰���.
	//	�ʱⰪ�� ��ȭ�ĸ� �־�����, ��� ���� �� �� �ִ�.
	static int solve1(int n, int k, int[] changes) {
		//	�Ž����־�� �� �ݾ��� 0���� �۴ٸ� na�� ��ȯ�Ѵ�.
		if(n<0) return na;
		//	���� �Ž����־�� �� �ݾ��� 0�̾��ٸ�, 0�� ��ȯ.
		if(n==0) return 0;
		//	�ּҰ��� ���� �� ���� ���� ū ������ ��������.
		int min = na;
		//	��� �Ž������� ���Ͽ� ó��
		for(int i=0; i<k; i++) {
			//	i��° ������ �� �ݾ��� ��, �ּ� ������ ���� t�� ����
			int t = solve1(n-changes[i], k, changes) + 1;
			//	t�� min���� ������ �ּڰ� ����
			if(t<min) min = t;
		}
		//	��꿡�� ����� �ּҰ� ��ȯ
		return min;
	}
	//	�޸� �������� ��ī���� �˰���.
	//	�̹� ���� ����� �޸� ����.  �׷��� �ٽ� ����� �ʿ䰡 ���� �ʳ�?
	static int[] memo;
	static int solve2(int n, int k, int[] changes) {
		memo = new int[n+1];
		for(int i=0;i<=n;i++) memo[i] = 0;
		return solve2r(n, k, changes);
	}
	static int solve2r(int n, int k, int[] changes) {
		//	�Ž����־�� �� �ݾ��� 0���� �۴ٸ� na�� ��ȯ�Ѵ�.
		if(n<0) return na;
		//	���� �Ž����־�� �� �ݾ��� 0�̾��ٸ�, 0�� ��ȯ.
		if(n==0) return 0;
		//	�޸� ��ϵ� ���� �ִٸ�, �ش� �޸� �̿�����.
		if(memo[n]!=0) return memo[n];
		//	�ּҰ��� ���� �� ���� ���� ū ������ ��������.
		int min = na;
		//	��� �Ž������� ���Ͽ� ó��
		for(int i=0; i<k; i++) {
			//	i��° ������ �� �ݾ��� ��, �ּ� ������ ���� t�� ����
			int t = solve2r(n-changes[i], k, changes) + 1;
			//	t�� min���� ������ �ּڰ� ����
			if(t<min) min = t;
		}
		//	��꿡�� ����� �ּҰ� ��ȯ�� ��, �޸� ��ϵ� �Ѵ�.
		return memo[n] = min;
	}
	//	������ �⽺�� �˰���.
	//	��͸� ������� ����, �����ͺ��� ������ Ǯ� ū ���� Ǯ��.
	static int solve3(int n, int k, int[] changes) {
		//	���� ��ȹ �˰����� ������ �迭������ �Ҵ�
		int[] dp = new int[n+1];
		//	�ʱⰪ n=0�϶��� �� 0�� �����Ѵ�.
		dp[0] = 0;
		//	��� n���� ���Ͽ�
		for(int i=1;i<=n;i++) {
			//	�ּҰ��� ���� ū ������ ����.
			int min = na;
			for(int j=0;j<k;j++) {
				//	���� i������ �������� ū ��쿡�� �������� �ʴ´�.
				if(changes[j]>i) continue;
				//	���� ����� ���� min������ �۴ٸ�, min���� ����
				if(min>dp[i-changes[j]]+1) min=dp[i-changes[j]]+1;
			}
			//	��� ����� dp[]�� �����Ѵ�.
			dp[i]=min;
		}
		//	���� ��ȯ
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
		
		//	��ȭ���� �̿��� ���
		t = System.currentTimeMillis(); 
		ans = solve1(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");

		//	�޸� �̿��� ���
		t = System.currentTimeMillis();
		ans = solve2(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");

		//	������ ���α׷��� �̿��� ���
		t = System.currentTimeMillis();
		ans = solve3(n, k, changes);
		System.out.println("Elapsed : "+(System.currentTimeMillis()-t)+"ms.");
		if(ans<na) System.out.println("Answer is "+ans);
		else System.out.println("Not Available");
	}
}
