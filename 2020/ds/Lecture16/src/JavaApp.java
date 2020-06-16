import java.util.*;
public class JavaApp {
	//	백트래킹 기법으로 해답 찾기
	static int solve(int[] chess, int cur, int n) {
		if(cur == n) return 1;
		
		//	Queen을 놓기
		int res = 0;
		for(int i=0;i<n;i++) {
			//	이미 해당칸에 다른 열에 Queen이 있는지 검사
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
		
		//	체스판의 크기를 입력받는다.
		System.out.print("Enter the size of chess board : ");
		int n = scan.nextInt();
		
		//	체스판을 만든다.
		int[] chess = new int[n];
		
		long t = System.currentTimeMillis();
		int r = solve(chess, 0, n);
		System.out.println("solution is "+r);
		System.out.println("elapsed "+(System.currentTimeMillis()-t)+"ms.");
	}

}
