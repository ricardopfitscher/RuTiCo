import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static long MOD = 1_000_000_000 + 7;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long l = Long.parseLong(st.nextToken());

		long p = (l + k) / m;

		if (p * m != l + k) {
			p++;
		}

		if (m * p <= n) {
			System.out.println(p);
		} else {
			System.out.println(-1);
		}

	}
}