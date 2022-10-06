import java.io.*;
import java.util.*;

public class Solution {

	static boolean canWinFromOneMove(char []s,int k) {
		int prefix=0;
		int n=s.length;
		for(int i=0;i<n && s[i]==s[0];i++)
			prefix++;
		int suffix=0;
		for(int i=n-1;i>=0 && s[i]==s[n-1];i--)
			suffix++;
		
		return s[0]==s[n-1] && prefix+suffix+k>=n || Math.max(prefix, suffix)+k>=n;
			
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt(),k=sc.nextInt();
		char []s=sc.next().toCharArray();
		if(canWinFromOneMove(s, k)) {
			System.out.println("tokitsukaze");
			return;
		}
		int []suff=new int [n+1];
		suff[n-1]=1;
		for(int i=n-2;i>=0;i--) {
			suff[i]=1+(s[i+1]==s[i]?suff[i+1]:0);
		}
		for(int i=n-2;i>=0;i--)
			suff[i]=Math.max(suff[i], suff[i+1]);
		int max=0,curr=0;
		boolean draw=false;
		int ones=0;
		for(int i=0;i+k<=n;i++) {
			
			// one
			int prefix=ones==i?k+ones:max;
			int suffix=i+k==n?k:s[i+k]=='1' && suff[i+k]==n-(i+k)?k+suff[i+k]:suff[i+k];
			char first=i==0?'1':s[0],last=i+k==n?'1':s[n-1];
			boolean zero=first==last && prefix+suffix+k>=n || Math.max(prefix, suffix)+k>=n;
			// zero
			 prefix=ones==0?k+ones:max;
			 suffix=i+k==n?k:s[i+k]=='0' && suff[i+k]==n-(i+k)?k+suff[i+k]:suff[i+k];
			 first=i==0?'0':s[0];
			 last=i+k==n?'0':s[n-1];
			boolean one=first==last && prefix+suffix+k>=n || Math.max(prefix, suffix)+k>=n;
			if(!zero || !one) {
//				System.err.println(i+1);
				draw=true;
			}
			if(s[i]=='1')
				ones++;
			if(i>0 && s[i]==s[i-1] )
				curr++;
			else
				curr=1;
			max=Math.max(max, curr);
		}
		out.println(draw?"once again":"quailty");
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

}