// practice with rainboy
import java.io.*;
import java.util.*;

public class CF903F {
	static final int INF = 0x3f3f3f3f;
	static void fill(int[][][][] aa, int a) {
		for (int h0 = 0; h0 <= 4; h0++)
			for (int h1 = 0; h1 <= 4; h1++)
				for (int h2 = 0; h2 <= 4; h2++)
					for (int h3 = 0; h3 <= 4; h3++)
						aa[h0][h1][h2][h3] = a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		int a3 = Integer.parseInt(st.nextToken());
		int a4 = Integer.parseInt(st.nextToken());
		int[] aa = new int[10];
		aa[0] = aa[1] = aa[2] = aa[3] = a1;
		aa[4] = aa[5] = aa[6] = a2;
		aa[7] = aa[8] = a3;
		aa[9] = a4;
		int[][] ww = new int[10][4];
		ww[0][0] = 1;
		ww[1][1] = 1;
		ww[2][2] = 1;
		ww[3][3] = 1;
		ww[4][0] = ww[4][1] = 2;
		ww[5][1] = ww[5][2] = 2;
		ww[6][2] = ww[6][3] = 2;
		ww[7][0] = ww[7][1] = ww[7][2] = 3;
		ww[8][1] = ww[8][2] = ww[8][3] = 3;
		ww[9][0] = ww[9][1] = ww[9][2] = ww[9][3] = 4;
		char[][] cc = new char[4][n + 8];
		for (int k = 0; k < 4; k++) {
			char[] c_ = cc[k];
			br.readLine().getChars(0, n, c_, 4);
			c_[0] = c_[1] = c_[2] = c_[3]
				= c_[n + 4] = c_[n + 5] = c_[n + 6] = c_[n + 7] = '.';
		}
		int[][][][] dp = new int[5][5][5][5];
		int[][][][] dq = new int[5][5][5][5];
		fill(dp, INF);
		dp[4][4][4][4] = 0;
		int[] hh = new int[4];
		for (int i = 0; i < n + 4; i++) {
			for (int h0 = 0; h0 <= 4; h0++)
				for (int h1 = 0; h1 <= 4; h1++)
					for (int h2 = 0; h2 <= 4; h2++)
						for (int h3 = 0; h3 <= 4; h3++)
							for (int s = 0; s < 10; s++) {
								hh[0] = h0;
								hh[1] = h1;
								hh[2] = h2;
								hh[3] = h3;
								for (int k = 0; k < 4; k++) {
									int h = ww[s][k];
									if (hh[k] < h) {
										while (h < 4 && cc[k][i + h] == '.')
											h++;
										hh[k] = h;
									}
								}
								int x = dp[h0][h1][h2][h3] + aa[s];
								if (dp[hh[0]][hh[1]][hh[2]][hh[3]] > x)
									dp[hh[0]][hh[1]][hh[2]][hh[3]] = x;
							}
			fill(dq, INF);
			for (int h0 = 1; h0 <= 4; h0++) {
				hh[0] = h0 < 4 || cc[0][i + 4] == '*' ? h0 - 1 : 4;
				for (int h1 = 1; h1 <= 4; h1++) {
					hh[1] = h1 < 4 || cc[1][i + 4] == '*' ? h1 - 1 : 4;
					for (int h2 = 1; h2 <= 4; h2++) {
						hh[2] = h2 < 4 || cc[2][i + 4] == '*' ? h2 - 1 : 4;
						for (int h3 = 1; h3 <= 4; h3++) {
							hh[3] = h3 < 4 || cc[3][i + 4] == '*' ? h3 - 1 : 4;
							int x = dp[h0][h1][h2][h3];
							if (dq[hh[0]][hh[1]][hh[2]][hh[3]] > x)
								dq[hh[0]][hh[1]][hh[2]][hh[3]] = x;
						}
					}
				}
			}
			int[][][][] tmp = dp; dp = dq; dq = tmp;
		}
		System.out.println(dp[4][4][4][4]);
	}
}
