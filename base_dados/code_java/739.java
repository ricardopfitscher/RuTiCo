import java.util.*;
import java.io.*;
public class Main {
	static List<Integer>[] arr;
	static int[] d;
	static int[] p;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		d = new int[n+1];
		p = new int[n+1];
		
		for(int i=1;i<arr.length;i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		dfs(1, 1, 0);
		
		Integer[] node = new Integer[n+1];
		for(int i=1;i<node.length;i++) {
			node[i] = i;
		}
		Arrays.sort(node, 1, n+1, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return -Integer.compare(d[arg0], d[arg1]);
			}
			
		});
		
		int count=0;
		for(int i=1;i<=n;i++) {
			if(d[node[i]]>2) {
				count++;
				d[p[node[i]]] = 1;
				for(int nod:arr[p[node[i]]]) {
					d[nod] = 2;
				}
			}
		}
		System.out.println(count);
	}
	static void dfs(int par, int cur, int distance) {
		d[cur]=distance;
		p[cur]=par;
		for(int i:arr[cur]) {
			if(i!=par) {
				dfs(cur, i, distance+1);
			}
		}
		
	}
}
/*
7
1 2
2 3
2 4
4 5
4 6
5 7
*/