import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {
	static ArrayList<Integer> [] adj;
	static int [] num;
	static int dfs(int u, int p){
		int cnt = 0;
		for(int v:adj[u]){
			if(v != p)
				cnt += dfs(v, u);
		}
		if(adj[u].size() == 1 && u != 0 || u == 0 && adj[0].size() == 0)
			cnt++;
		num[cnt]++;
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		adj = new ArrayList[n];
		for (int i = 0; i < adj.length; ++i) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; ++i) {
			int p = sc.nextInt()-1;
			adj[p].add(i);
			adj[i].add(p);
		}
		num = new int[n+1];
		dfs(0, -1);
		for (int i = 1; i < num.length; ++i) {
			num[i] += num[i-1];
		}
		int cur = 1;
		for (int i = 0; i < num.length; ++i) {
			while(cur <= num[i]){
				out.print(i + " ");
				++cur;
			}	
		}
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

}
