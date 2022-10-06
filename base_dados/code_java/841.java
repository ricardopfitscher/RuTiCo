import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static int mod = 1000000000 + 7;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		int k = Integer.parseInt(br.readLine());
		int l = n.length();
		
		if(k == 0) {
			System.out.println(1);
		}else {
			int max = 1000;
			if (l <= 10) {
				max = Integer.min(1000, Integer.parseInt(n, 2));
			}

			int[] steps = new int[max + 1];
					
			for (int i = 2; i <= max; i++) {
				int ones = numberOfOnes(i);
				steps[i] = 1 + steps[ones];
			}

			if (l <= 10) {
				int ans = 0;
				for (int i = 1; i <= max; i++) {
					if (steps[i] == k) {
						ans++;
					}
				}
				System.out.println(ans);
			} else {
				int[][] C = binomial(max);

				int ans = 0;
				int count = 0;

				for (int i = 0; i < l; i++) {
					if (n.charAt(i) == '1') {
						for (int j = count; j < max; j++) {
							if (steps[j] == k - 1) {
								ans = (ans + C[l - i - 1][j - count]) % mod;
								if (i == 0 && k == 1) {
									ans = (ans + mod - 1) % mod;
								}
							}
						}
						count++;
					}
				}

				int ones = 0;
				for (int i = 0; i < l; i++) {
					if (n.charAt(i) == '1') {
						ones++;
					}
				}
				if (steps[ones] == k-1) {
					ans = (ans + 1) % mod;
				}
				
				System.out.println(ans);
			}
		}
	}

	public static int numberOfOnes(int x) {
		char[] s = Integer.toBinaryString(x).toCharArray();
		int count = 0;
		for (char c : s) {
			if (c == '1') {
				count++;
			}
		}
		return count;
	}

	public static int[][] binomial(int n) {
		int[][] C = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			C[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				C[i][j] = ((C[i - 1][j - 1] % mod) + (C[i - 1][j] % mod)) % mod;
			}
		}

		return C;
	}

}
