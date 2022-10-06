import java.io.*;
import java.util.*;

public class Main {
	static final int MAXN= 1005;
	static final long MOD =1_000_000_007;
	static final boolean DEBUG= false;
	static int  n, m;
	static long stlr[][]= new long[MAXN][MAXN],bell[]= new long[MAXN],occ[];
	static PrintStream cerr=System.err;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Readin();
		stlr[0][0]= bell[0] =1;
		for (int i=1; i<=m; i++)
			for (int j=1;j<=i;j++) {
				stlr[i][j]= (stlr[i-1][j-1]+stlr[i-1][j]*(long)j)%MOD;
				bell[i]= (bell[i]+stlr[i][j])%MOD;
			}
		if (DEBUG)
			for (int i=1; i<=m; i++) cerr.println("Bell["+i+"] ="+bell[i]);
		Arrays.sort(occ);
		if (DEBUG) {
			cerr.println("After Sorting");
			for (int i=0;i<m; i++) cerr.println(occ[i]+" ");}
		long ans=1;
		for (int i=0,j=0; i<m; i=j) {
			for (j=i+1; j<m && occ[i]==occ[j];j++);
			ans= (ans*bell[j-i])%MOD;
		}
		System.out.println(ans);
	}
	static void Readin() {
		Scanner  cin;
		if ( !DEBUG)cin= new Scanner(System.in);
		else {
			try {
				cin = new Scanner(new File("input.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				if ( DEBUG)cerr.println("Not Fount input.txt");
				return ;
			}
		}
		m = cin.nextInt(); n=cin.nextInt();
		occ= new long[m];
		for (int i=0; i<n; i++) {
			String s= cin.next();
			for (int j=0;j <m; j++)
				occ[j]|=((long)(s.charAt(j)-'0'))<<i;
		}
		cin.close();
	}
}
