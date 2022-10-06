import java.util.*;
import java.io.*;

public class CodeForces
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("ip.txt"));
		
		int t,i,j,n,k,x,y,z,min1,min2,min3,arr1[],arr2[],arr3[];
		String s;
		char[] s1,s2,s3;

		t=sc.nextInt();
		
		while(t-->0)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			s=sc.next();
			s1=new char[n];
			s2=new char[n];
			s3=new char[n];
			
			for(i=0;i<n;i++)
			{
				if(i%3==0)
				{
					s1[i]='R';
					s2[i]='G';
					s3[i]='B';
				}
				if(i%3==1)
				{
					s1[i]='G';
					s2[i]='B';
					s3[i]='R';
				}
				if(i%3==2)
				{
					s1[i]='B';
					s2[i]='R';
					s3[i]='G';
				}
			}
			arr1=new int[n];
			arr2=new int[n];
			arr3=new int[n];

			for(i=0;i<n;i++)
			{
				if(s.charAt(i)!=s1[i])
					arr1[i]=1;
				if(s.charAt(i)!=s2[i])
					arr2[i]=1;
				if(s.charAt(i)!=s3[i])
					arr3[i]=1;
			}
			for(i=1;i<n;i++)
			{
				arr1[i]=arr1[i]+arr1[i-1];
				arr2[i]=arr2[i]+arr2[i-1];
				arr3[i]=arr3[i]+arr3[i-1];
			}
			
			min1=arr1[k-1];
			min2=arr2[k-1];
			min3=arr3[k-1];

			for(i=k;i<n;i++)
			{
				if(min1>(arr1[i]-arr1[i-k]))
					min1=(arr1[i]-arr1[i-k]);
				if(min2>(arr2[i]-arr2[i-k]))
					min2=(arr2[i]-arr2[i-k]);
				if(min3>(arr3[i]-arr3[i-k]))
					min3=(arr3[i]-arr3[i-k]);
			}
			System.out.println(Math.min(min1,Math.min(min2,min3)));
		}
	}
}