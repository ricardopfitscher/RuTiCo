/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] A=new int[n];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<n;i++){
			A[i]=Integer.parseInt(s[i]);
		}
		Map memo=new HashMap();
		int[] f=new int[n];
		for(int i=0;i<n;i++){
			if(!memo.containsKey(A[i])){
				memo.put(A[i],1);
			}
			else{
				int ct=(int)memo.get(A[i]);
				memo.put(A[i],ct+1);
			}
			int tot=0;
			if(memo.containsKey(A[i]-1)){
				tot+=(int)memo.get(A[i]-1);
			}
			if(memo.containsKey(A[i]+1)){
				tot+=(int)memo.get(A[i]+1);
			}
			tot+=(int)memo.get(A[i]);
			f[i]=tot;
		}
		BigInteger res=new BigInteger("0");
		for(int i=0;i<n;i++){
			int tot1=i+1-f[i];
			int tot2=0;
			if(memo.containsKey(A[i]-1)){
				tot2+=(int)memo.get(A[i]-1);
			}
			if(memo.containsKey(A[i]+1)){
				tot2+=(int)memo.get(A[i]+1);
			}
			tot2+=(int)memo.get(A[i]);
			tot2=n-i-1-(tot2-f[i]);
			//res+=(long)(tot1-tot2)*(long)A[i];
			res=res.add(BigInteger.valueOf((long)(tot1-tot2)*(long)A[i]));
		}
		System.out.println(res);
	}
}