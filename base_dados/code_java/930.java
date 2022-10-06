import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.Map.*;
public class codeforces {
     static int count =0;
     static boolean f=false;
     static int [] arr;
	static 	PrintWriter pw=new PrintWriter(System.out);
	static void solve(int index , int mask) {
		if(index==arr.length) {
			int sum1=0; int sum2=0;
			for(int i=0;i<arr.length;i++) {
				if((mask & 1<<i)!=0) sum1+=arr[i];
				
			}
			return;
		}
		solve(index+1, mask | 1<<index);
		solve(index+1, mask);
	}
	public static void main(String [] args) throws IOException, InterruptedException {
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		pair [] arr=new pair[x];
		for(int i=0;i<x;i++) arr[i]=new pair(i, sc.nextInt(),0);
		for(int i=0;i<x;i++) arr[i].y=sc.nextInt();
		Arrays.sort(arr);
		PriorityQueue<Integer> qq=new PriorityQueue<>();
		//pw.println(Arrays.toString(arr));
		Long [] list=new Long [x];
		long sum=0; 
		for(int i=0;i<x;i++) {
			pair w=arr[i];
			if(qq.size()<y) {
				qq.add(w.y);
				sum+=w.y;
				list[w.i]=sum;

			}else if(!qq.isEmpty()) {
				sum+=w.y;
				list[w.i]=sum;
				int first=qq.poll();
				if(w.y>first) {
					sum-=first;
					qq.add(w.y);
				}else {
					qq.add(first);
					sum-=w.y;
				}
			} else list[w.i]=(long) w.y;
			//pw.println(qq);
		}
		for(Long w:list) pw.print(w+" "); 
		pw.flush();
		pw.close();
	}
	
	
	static class pair implements Comparable<pair>{
		String  name; int x,y,i ;
		public pair(String name , int x) {
			this.name=name; this.x=x;
		}
		
		public pair (int i,int x,int y) {
			this.i=i; this.x=x; this.y=y; 
		}
		public int compareTo(pair o) {
			return x-o.x;
		}
		public int compareTo1(pair o) {
			if(!name.equals(o.name))
				return name.compareTo(o.name);
			return x-o.x;
		}
		public String toString() {
			return i+" "+x+" "+y;
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