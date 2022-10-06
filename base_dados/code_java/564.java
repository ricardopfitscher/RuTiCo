import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().trim().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		long b[] = new long[n];
		s = br.readLine().trim().split(" ");
		for(int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(s[i]);
		}
		long g[] = new long[m];
		s = br.readLine().trim().split(" ");
		for(int i = 0; i < m; i++) {
			g[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(b);
		Arrays.sort(g);
		if(g[0] < b[n-1]) {
			System.out.println("-1");
		}
		else if(g[0] == b[n-1]){
			long ans = 0;
			for(int i = 0; i < m; i++) {
				ans += g[i];
			}
			for(int i = 0; i < n-1; i++) {
				ans += (m)*b[i];
			}
			System.out.println(ans);

		}
		else {
			long ans = 0;
			for(int i = 0; i < m; i++) {
				ans += g[i];
			}
			for(int i = 0; i < n-1; i++) {
				ans += (m)*b[i];
			}
			ans += b[n-1]-b[n-2];
			System.out.println(ans);

		}
	}
}