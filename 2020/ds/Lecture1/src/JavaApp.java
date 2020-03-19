
public class JavaApp {

	//	<summary>Main Method</summary>
	//	<param name=args>arguments</param>
	public static void main(String[] args) {
		// Hello World!를 출력하도록 합니다.
		System.out.println("Hello World!");
		
		//	변수 선언 및 연산
		int a = 3, b = 5;
		System.out.println(a+b);
		
		//	배열 (변수들을 차례대로 저장하는 새로운 변수타입)
		int[] arr = { 1, 3, 5, 7 };
		System.out.println(arr[1]);
		
		//	반복문 (기본 for루프)
		System.out.println("Basic for loop");
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		//	반복문 (for each 루프)
		System.out.println("for each loop");
		for(int i : arr) {
			System.out.println(i);
		}
		
		//	조건문 (if - else if - else)
		int score = 76;
		if(score >= 90) System.out.println("A");
		else if(score >= 80) System.out.println("B");
		else if(score >= 70) System.out.println("C");
		else if(score >= 60) System.out.println("D");
		else System.out.println("F");
		//--end
	}

}
