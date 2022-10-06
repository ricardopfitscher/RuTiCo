/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
			long n,s,p;
			Scanner in=new Scanner(System.in);
			n=in.nextLong();
			s=in.nextLong();
			if(n==1 && s<=1)
			{
			    System.out.print(n-1);
			}
	        else if(s<n)
	        {
	            if(s%2!=0)
		        {System.out.print(s/2);}
		        else
		        {System.out.print(s/2-1);}
	        }
	        else if(s==n)
	{
	    if(s%2==0)
		{System.out.println((n/2)-1);}
		else
		{System.out.println(n/2);}
	}
	else if(s<=(2*n-1))	
	{
		System.out.print((2*n+1-s)/2);
	}
	else
	{
		System.out.print(0);
	}
	}
}