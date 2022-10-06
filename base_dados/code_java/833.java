import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class c {
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		long bounty = in.nextInt(), increase = in.nextInt();
		int damage = in.nextInt();
		int[] mh = new int[n];
		int[] sh = new int[n];
		int[] reg = new int[n];
		long countKilled = 0;
		ArrayList<Event> es = new ArrayList<>();
		Event[] regen = new Event[n];
		for(int i=0;i<n;i++) {
			mh[i] = in.nextInt();
			sh[i] = in.nextInt();
			reg[i] = in.nextInt();
			if(sh[i] <= damage)
				countKilled++;
			if(reg[i] > 0) {
				int time = (damage+1 - sh[i]+reg[i]-1)/reg[i];
				if(time > 0 && mh[i] >= damage+1) {
					Event e2 = new Event(time, i, damage+1);
					regen[i] = e2;
					es.add(e2);
				}
			}
		}
		for(int i=0;i<m;i++) {
			Event e = new Event(in.nextInt(), in.nextInt()-1, in.nextInt());
			es.add(e);
			if(reg[e.e] > 0) {
				int time = (damage+1 - e.h+reg[e.e]-1)/reg[e.e];
				if(time > 0 && mh[e.e] >= damage+1) {
					Event e2 = new Event(e.t + time, e.e, damage+1);
					e.regen = e2;
					es.add(e2);
				}
			}
		}
		Collections.sort(es, (a,b) -> a.t-b.t);
		long ans = countKilled*bounty;
		int lastTime = 0;
		for(Event e : es) {
			if(e.t == -1) continue;
			if(regen[e.e] != e && regen[e.e] != null) {
				regen[e.e].t = -1;
				regen[e.e] = null;
			}
			if(lastTime != e.t) {
				ans = Math.max(ans, countKilled*(bounty+(e.t-1)*increase));
			}
			if(sh[e.e] <= damage)
				countKilled--;
			sh[e.e] = e.h;
			if(sh[e.e] <= damage)
				countKilled++;
			if(e.regen != null) {
				regen[e.e] = e.regen;
			}
			lastTime = e.t;
		}
		if(countKilled != 0) {
			if(increase > 0)
				ans = -1;
			else
				ans = Math.max(ans, countKilled*bounty);
		}
		System.out.println(ans);
	}
	static class Event {
		int t;
		int e;
		int h;
		Event regen;
		public Event(int tt, int ee, int hh) {
			t = tt;
			e = ee;
			h = hh;
		}
	}
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }
	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	}
}
