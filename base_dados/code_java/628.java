import java.io.BufferedInputStream;
import java.util.Scanner;

public class RookHome {
	static long MAX = 1_000_000_000;

	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedInputStream(System.in));
		int n = s.nextInt();
		int m = s.nextInt();
		long[] vert = new long[n + 2];
		vert[0] = 1;
		for (int i = 1; i <= n; i++) {
			vert[i] = s.nextLong();
		}
		vert[n + 1] = MAX;
		long[][] hor = new long[m][2];
		for (int i = 0; i < m; i++) {
			hor[i][0] = s.nextLong();
			hor[i][1] = s.nextLong();
			s.nextLong();
		}
		long min = Long.MAX_VALUE;
		int count;
		for(int i = 0; i < vert.length - 1; i++) {
			count = 0;
			for(int j = 0; j < m; j++) {
				if(hor[j][0] <= vert[i] && hor[j][1] >= vert[i + 1]) {
					count++;
				}
			}
			min = Math.min(min, i + count);
		}
		System.out.println(min);
	}
}
