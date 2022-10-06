// discussed with rainboy
import java.io.*;
import java.util.*;

public class CF915D {
	static ArrayList[] aa;
	static boolean[] visited, instack;
	static int[] stack;
	static int cnt, h_, i_, j_;
	static boolean dfs1(int i) {
		if (visited[i]) {
			if (instack[i]) {
				h_ = i;
				return true;
			}
			return false;
		}
		visited[i] = instack[i] = true;
		stack[cnt++] = i;
		ArrayList<Integer> adj = aa[i];
		for (int j : adj)
			if (dfs1(j))
				return true;
		instack[i] = false;
		cnt--;
		return false;
	}
	static boolean dfs2(int i) {
		if (visited[i])
			return instack[i];
		visited[i] = instack[i] = true;
		ArrayList<Integer> adj = aa[i];
		for (int j : adj)
			if (!(i == i_ && j == j_) && dfs2(j))
				return true;
		instack[i] = false;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		aa = new ArrayList[n];
		for (int i = 0; i < n; i++)
			aa[i] = new ArrayList<Integer>();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			aa[i].add(j);
		}
		visited = new boolean[n];
		instack = new boolean[n];
		stack = new int[n];
		for (int i = 0; i < n; i++)
			if (dfs1(i))
				break;
		if (cnt == 0) {
			System.out.println("YES");
			return;
		}
		for (j_ = h_, i_ = stack[--cnt]; ; j_ = i_, i_ = stack[--cnt]) {
			Arrays.fill(visited, false);
			Arrays.fill(instack, false);
			boolean cycle = false;
			for (int i = 0; i < n; i++)
				if (dfs2(i)) {
					cycle = true;
					break;
				}
			if (!cycle) {
				System.out.println("YES");
				return;
			}
			if (i_ == h_)
				break;
		}
		System.out.println("NO");
	}
}
