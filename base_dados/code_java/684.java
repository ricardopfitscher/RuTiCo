
import java.util.*;


public class HelloWorld {
	static long SQR(long a) {
		return a * a;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = sc.next();
		char s[] = str.toCharArray();
		Arrays.parallelSort(s);
		str = new String(s);
		int d = 0;
		int ans = 0;

		for(int i = 0;i < str.length();i++) {
			int x = str.charAt(i) - 'a';
			if(k == 0)continue;
			if(x >= d) {
				ans = ans + x + 1;
				d = x + 2;
				k = k - 1;
			}
		}
		if(k > 0)ans = -1;
		System.out.println(ans);
	}
}
