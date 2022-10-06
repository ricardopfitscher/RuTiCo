import java.io.*;
import java.util.*;

public class CF1009E {
	static final int MD = 998244353;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] aa = new int[1 + n];
		for (int i = 1, a = 0; i <= n; i++)
			aa[i] = a = (a + Integer.parseInt(st.nextToken())) % MD;
		int[] pp = new int[n];
		pp[0] = 1;
		for (int i = 1, p = 1; i < n; i++) {
			pp[i] = p;
			p = p * 2 % MD;
		}
		int d = 0;
		long ans = 0;
		for (int i = n - 1; i >= 0; i--) {	// rest at i
			d = (d * 2 % MD + aa[n - 1 - i]) % MD;	// rest again before n
			ans = (ans + (long) (d + aa[n - i]) * pp[i]) % MD;
		}
		System.out.println(ans);
	}
}
