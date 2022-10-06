
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class main {
static	class Interval{
		int start;
		int end;
		public Interval(int start,int end) {
			this.start=start;
			this.end=end;
		}
	}
static class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 
	static long mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader in = new FastReader();
		long intervals = in.nextInt();
		long x = in.nextInt();
		 long y = in.nextInt();
		Interval []ints = new Interval[(int)(int) intervals];
		for(int i = 0;i<intervals;i++) {
			ints[i] = new Interval(in.nextInt(),in.nextInt());
		}
		Arrays.sort(ints, (a,b)->a.start-b.start);
		long count = 0;
		for(int i = 0;i<ints.length;i++) {
			if(i>=0&&ints[i]!=null) {
			Interval cur1 = ints[i];
			for(int j = i+1;j<ints.length;j++) {
			if(ints[j]!=null) {
			Interval cur2 = ints[j];
			if(y*(cur2.start-cur1.end)<x) {
			if(cur1.start!=cur2.start&&cur1.end<cur2.start) {
				cur1.end=cur2.end;
				
				ints[j]=null;
			//	i--;
			}}
			else
				break;
			}
			
			}
			count = (count + x) % mod;
			count += (y*(cur1.end-cur1.start)%mod);
			count%=mod;
			}
			
		}
		
//		for(int i = 0;i<ints.length;i++) {
//			if(ints[i]!=null) {
//			Interval cur = ints[i];
//			count = (count + x) % mod;
//			count += (y*(cur.end-cur.start)%mod);
//			count%=mod;
//			}
//		}
		System.out.println(count);
	}

}