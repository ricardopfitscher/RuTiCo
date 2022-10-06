import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map.Entry;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public final class CF_573_D1_A {


	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X,int L){if (verb) {for (int i=0;i<L;i++) System.err.print(X[i]+" ");System.err.println("");}}
	static void log(long[] X){if (verb) {for (long U:X) System.err.print(U+" ");System.err.println("");}}

	static void logWln(Object X){if (verb) System.err.print(X);}
	static void info(Object o){	System.out.println(o);}
	static void output(Object o){outputWln(""+o+"\n");	}
	static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}

	//static long mod=1000000007;
	static long mod=998244353 ; 
	static int CX=64;


	// Global vars
	static BufferedWriter out;
	static InputReader reader;


	

	static void process() throws Exception {

		Locale.setDefault(Locale.US);
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new InputReader(System.in);

		long n=reader.readLong();
		int m=reader.readInt();
		
		long k=reader.readLong();
		long[] p=new long[m];
		for (int i=0;i<m;i++)
			p[i]=reader.readLong()-1;
		
		int pid=-1;
		int rem=m;
		int win=0; // current window
		long mx=k-1; // max value of window
		int res=0;
		int idx=0;
		
		while (rem>0) {
			//log("======");
			while (p[idx]>mx) {
				mx+=k;
				if (mx>=n-1)
					mx=n-1;
				//log("mx:"+mx);
			}
		
			int nxt=idx;
			while (nxt+1<m && p[nxt+1]<=mx)
				nxt++;
			int nb=nxt-idx+1;
			rem-=nb;
			mx+=nb;
			idx=nxt+1;
			res++;
		}
		output(res);

	
		try {
			out.close();
		} catch (Exception E) {
		}

	}

	public static void main(String[] args) throws Exception {
		process();

	}

	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final int readInt() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		public final long readLong() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

}