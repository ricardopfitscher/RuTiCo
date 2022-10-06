import java.io.*;
import java.util.*;


public class tr {
	static int[][] ad;
    static boolean []vis;
    static int []goods;
    static int[][]sol;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt();
		int []a=new int [n];
		int max=0;
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		Stack<Integer> s=new Stack<>();
		boolean f=true;
				for(int i=0;i<n;i++) {
					max=Math.max(max,a[i]);
					if(!s.isEmpty() && a[i]>s.peek())
						f=false;
					s.push(a[i]);
					while(!s.isEmpty()) {
						int high=s.pop();
						if(s.isEmpty() || s.peek()!=high) {
							s.push(high);
							break;
						}
						s.pop();
					}
				//	System.out.println(s+" "+max);
				}
				//System.out.println(f+" "+max);
				if(f && s.size()==0)
					out.println("YES");
				else if(f && s.size()==1 && s.peek()==max)
					out.println("YES");
				else
					out.println("NO");
		 out.flush();
	}
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static class pair implements Comparable<pair> {
		int a;
		int b;

		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public String toString() {
			return a + " " + b;
		}

		@Override
		public int compareTo(pair o) {
			return  o.a-a ;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}