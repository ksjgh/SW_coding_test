import java.util.Scanner;

public class Main {

	long kimchi(int n){
		long []a = new long [101]; 
		a[1] = a[2] = a[3] = 1;
		for (int i = 4; i <= n; i++){
			if (i % 3 == 0) a[i] = 3 * a[i - 1] - 2 * a[i - 2] - a[i - 3];
			else if (i % 3 == 1) a[i] = 3 * a[i - 1] - 2 * a[i - 2] + a[i - 3];
			else a[i] = 2 * a[i - 1] - 2 * a[i - 2] + a[i - 3];
		}
		return a[n];
	}

	public static void main(String[] args) {
		int T;
		Main m = new Main();

		Scanner s = new Scanner(System.in);
		T = s.nextInt();
		s.close();

		System.out.println(m.kimchi(T));				//	정답 출력
	}
}