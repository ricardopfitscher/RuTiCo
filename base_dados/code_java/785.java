import java.io.*;
import java.util.*;

public class CF1082D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] aa = new int[n];
		int[] i1 = new int[n];
		int[] i2 = new int[n];
		int n1 = 0, n2 = 0, m2 = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			aa[i] = a;
			if (a == 1)
				i1[n1++] = i;
			else {
				i2[n2++] = i;
				m2 += a;
			}
		}
		if (m2 < (n2 - 1) * 2 + n1) {
			System.out.println("NO");
			return;
		}
		int m = n2 - 1 + n1;
		int d = n2 - 1 + Math.min(n1, 2);
		PrintWriter pw = new PrintWriter(System.out);
		pw.println("YES " + d);
		pw.println(m);
		for (int i = 0; i + 1 < n2; i++) {
			pw.println((i2[i] + 1) + " " + (i2[i + 1] + 1));
			aa[i2[i]]--; aa[i2[i + 1]]--;
		}
		if (n1 > 0) {
			while (n2 > 0 && aa[i2[n2 - 1]] == 0)
				n2--;
			pw.println((i2[n2 - 1] + 1) + " " + (i1[n1 - 1] + 1));
			aa[i2[n2 - 1]]--;
			n1--;
		}
		for (int i = 0, j = 0; j < n1; j++) {
			while (aa[i2[i]] == 0)
				i++;
			pw.println((i2[i] + 1) + " " + (i1[j] + 1));
			aa[i2[i]]--;
		}
		pw.close();
	}
}
