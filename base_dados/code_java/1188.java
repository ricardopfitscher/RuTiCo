

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class e {

public static class FastReader {
	BufferedReader br;
	StringTokenizer st;
	//it reads the data about the specified point and divide the data about it ,it is quite fast
	//than using direct 

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception r) {
				r.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());//converts string to integer
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception r) {
			r.printStackTrace();
		}
		return str;
	}
}
static ArrayList<String>list1=new ArrayList<String>();
static void combine(String instr, StringBuffer outstr, int index,int k)
{
	if(outstr.length()==k)
	{
		list1.add(outstr.toString());return;
	}
	if(outstr.toString().length()==0)
	outstr.append(instr.charAt(index));
    for (int i = 0; i < instr.length(); i++)
    {
        outstr.append(instr.charAt(i));
       
        combine(instr, outstr, i + 1,k);
        outstr.deleteCharAt(outstr.length() - 1);
    }
   index++;
} 
static ArrayList<ArrayList<Integer>>l=new ArrayList<>();
static void comb(int n,int k,int ind,ArrayList<Integer>list)
{
	if(k==0)
	{
		l.add(new ArrayList<>(list));

		return;
	}
	
	
	for(int i=ind;i<=n;i++)
	{
		list.add(i);
		comb(n,k-1,ind+1,list);
		
		list.remove(list.size()-1);
		
	}
	
	
	
	
	

}


public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	FastReader in=new FastReader();
	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();

	int n=in.nextInt();
	int r=in.nextInt();
	 
	double theta=(double)360/(double)n;
	 
	double b=1-((double)2/(double)(1-Math.cos((double)2*Math.PI/(double)n)));
	double x=Math.sqrt(1-b)-1;
	double ans=(double)r/(double)x;
	System.out.println(ans);





	}
}
