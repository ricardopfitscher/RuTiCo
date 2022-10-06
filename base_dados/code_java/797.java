/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	static ArrayList<Integer> arr[];
	static boolean visited[];
	static int node=0;
	public static void main (String[] args) throws java.lang.Exception
	{	long i,j;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Long n=Long.parseLong(br.readLine());
	    Set<Long> set=new HashSet<Long>();
	    //Set<Long> ans=new HashSet<Long>();
	    TreeSet<Long> ans=new TreeSet<Long>();
	    ans.add((n*(n+1))/2);
	    ans.add((long)1);
	    for(i=2;i<Math.sqrt(n)+1;i++)
	    {   if(n%i==0)
	        {set.add(i);set.add(n/i);}
	    }
	    //System.out.println(set);
	    for(long  d: set)
	    {
	        long a=1;
	        long N=n/d-1;
	        long temp=(N+1)*a+N*(N+1)*d/2;
	        ans.add(temp);
	    }
	    for(long p:ans)
	    System.out.print(p+" ");
	    //System.out.println(ans);
	    
	}
}