import java.io.*;
import java.util.*;

public class CF1027D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cc = new int[n];
		for (int i = 0; i < n; i++)
			cc[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken()) - 1;
		int[] used = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (used[i] == 2)
				continue;
			int j = i;
			while (used[j] == 0) {
				used[j] = 1;
				j = aa[j];
			}
			if (used[j] == 1) {
				int c = cc[j];
				while (used[j] == 1) {
					used[j] = 2;
					c = Math.min(c, cc[j]);
					j = aa[j];
				}
				ans += c;
			}
			j = i;
			while (used[j] == 1) {
				used[j] = 2;
				j = aa[j];
			}
		}
		System.out.println(ans);
	}
}
