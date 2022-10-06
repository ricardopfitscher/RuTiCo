//package contest1196;

import java.util.*;
import java.io.*;

public class D {

	public static int[][] dp = new int[200005][3];
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		PrintWriter cout = new PrintWriter(System.out);
		
		int q = cin.nextInt();
		int[] a = new int[200005];
		int n, k;
		while (q-- > 0) {
			n = cin.nextInt();
			k = cin.nextInt();
			String chuoi = cin.nextLine();
			chuoi = cin.nextLine();
			for (int i = 1; i <= n; i++) {
				char ch = chuoi.charAt(i-1);
				if (ch == 'R') a[i] = 1;
				if (ch == 'G') a[i] = 2;
				if (ch == 'B') a[i] = 0;
			}
			
			for (int i = 1; i <= n; i++)
				for (int x = 0; x < 3; x++) {
					dp[i][x] = dp[i-1][x];
					if (a[i] != (x + i)%3) dp[i][x]++;
				}
			
			int res = 1000000007;
			for (int i = k; i <= n; i++) 
				for (int x = 0; x < 3; x++)
					res = Math.min(res, dp[i][x] - dp[i-k][x]);
					
			cout.println(res);
		}
		cout.close();
	}
}
