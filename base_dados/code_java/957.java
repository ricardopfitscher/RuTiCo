import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	static void insert(TreeMap<Integer, Integer>map,int v,int d)
	{
		if(!map.containsKey(v))map.put(v, 0);
		map.put(v, d+map.get(v));
		if(map.get(v)==0)map.remove(v);
	}
	
	static void cut(TreeSet<Integer> cuts, TreeMap<Integer, Integer>segments,int v)
	{
		int upper = cuts.higher(v) , lower = cuts.lower(v);
		insert(segments, upper-lower, -1);
		insert(segments, upper-v, 1);
		insert(segments, v-lower, 1);
		cuts.add(v);
	}
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(), h = sc.nextInt() , n = sc.nextInt();
		TreeSet<Integer> vCuts = new TreeSet<>() , hCuts = new TreeSet<>();
		TreeMap<Integer, Integer> vSegments = new TreeMap<>() , hSegments = new TreeMap<>();
		vCuts.add(0);vCuts.add(w);
		hCuts.add(0);hCuts.add(h);
		insert(vSegments, w, 1);
		insert(hSegments, h, 1);
		StringBuilder sb = new StringBuilder();
		while(n-->0)
		{
			if(sc.next().equals("H"))
				cut(hCuts, hSegments, sc.nextInt());
			else
				cut(vCuts, vSegments, sc.nextInt());
			sb.append(1l*hSegments.lastKey() * vSegments.lastKey() + "\n");
		}
		System.out.println(sb);
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s) {br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String file) throws FileNotFoundException {br = new BufferedReader(new FileReader(file));}
		public String next() throws IOException {while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}
		public int[] nexIntArray() throws Throwable {
			st = new StringTokenizer(br.readLine());
			int[] a = new int[st.countTokens()];
			for (int i = 0; i < a.length; i++)a[i] = nextInt();
			return a;
		}
		public boolean ready() throws IOException {return br.ready();}
	}
}