import java.util.*;
public class JavaApp {
	//	��Ʈ��ŷ ������� �ش� ã��
	static int solve(int[] chess, int cur, int n) {
		if(cur == n) return 1;
		
		//	Queen�� ����
		int res = 0;
		for(int i=0;i<n;i++) {
			//	�̹� �ش�ĭ�� �ٸ� ���� Queen�� �ִ��� �˻�
			boolean ok=true;
			for(int j=0;j<cur;j++) { 
				if(chess[j]==i) ok=false;
				if(i-chess[j]==cur-j) ok=false;
				if(chess[j]-i==cur-j) ok=false;
			}
			if(ok) {
				chess[cur] = i;
				res += solve(chess, cur+1, n);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//	ü������ ũ�⸦ �Է¹޴´�.
		System.out.print("Enter the size of chess board : ");
		int n = scan.nextInt();
		
		//	ü������ �����.
		int[] chess = new int[n];
		
		long t = System.currentTimeMillis();
		int r = solve(chess, 0, n);
		System.out.println("solution is "+r);
		System.out.println("elapsed "+(System.currentTimeMillis()-t)+"ms.");
	}

}
