/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public final class Codeforces
{	
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				int temp=sc.nextInt();
				list.add(temp);
			}
			Collections.sort(list);
			if(n%2==0)
			System.out.println(list.get((n/2)-1));
			else
			System.out.println(list.get(n/2));
	}
}
