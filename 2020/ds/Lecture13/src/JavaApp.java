//	F(n) = F(n-1) + F(n-2)
//	F(0) = 0, F(1) = 1
public class JavaApp {
	//	��� ȣ���� �̿��� �Ǻ���ġ ���� �Լ�
	//	O(a^n)
	static int fib(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fib(n-1)+fib(n-2);
	}
	
	//	forward ������� ����� �Ǻ���ġ ���� �Լ�
	//	O(n)
	static int fib1(int n) {
		int f0 = 0, f1 = 1, t;
		for(int i=2;i<=n;i++) {
			t = f1;
			f1 += f0;
			f0 = t;
		}
		return f1;
	}
	
	public static void main(String[] args) {
		//	20-45�ױ����� �Ǻ���ġ ���� ���
		for(int i=20;i<=45;i++) {
			long ct = System.currentTimeMillis();
			int f = fib1(i);
			System.out.println("fib("+i+")="+f+"(Elapsed "+
					(System.currentTimeMillis()-ct)+"ms)");
		}
	}

}
