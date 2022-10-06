/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	static int check(int temp)
	{
		int count1 = 0; 
    while (temp>0) 
    { 
        if(temp % 2 != 0) 
        count1++; 
        temp/= 2; 
    } 
    return count1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		int m=a.length();
		int n=b.length();
		int[] zero=new int[n];
		int[] one=new int[n];
		
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				if(b.charAt(i)=='0')
				zero[i]++;
				else
				one[i]++;
			}
			else
			{
				zero[i]=zero[i-1];
				one[i]=one[i-1];
				if(b.charAt(i)=='0')
				zero[i]++;
				else
				one[i]++;
		    }
		}
		

		long res=0;
		for(int i=0;i<m;i++)
		{
		int x=n-m+i;
		if(a.charAt(i)=='0')
		res+=one[x];
		else
		res+=zero[x];
		if(i>0)
		{
			if(a.charAt(i)=='0')
			res-=one[i-1];
			else
			res-=zero[i-1];
		}
		}
		
		System.out.println(res);
	}
}