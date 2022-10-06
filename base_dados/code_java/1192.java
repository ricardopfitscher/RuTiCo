
	
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.math.BigInteger;
	import java.util.*;
	
	
	public class usd {
		
		static int r=0;static int c=0;
		static void fillzero(int a[][],int n)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n-1;j++)
				{
					if(a[j][i]==0&&a[j+1][i]==0)
					{
						a[j][i]=1;a[j+1][i]=1;
						r=j;c=i;
						return;
					}
				}
			}
		}
		static void fillone(int a[][],int n)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n-1;j++)
				{
					if(a[i][j]==0&&a[i][j+1]==0)
					{
						a[i][j]=1;a[i][j+1]=1;
						r=i;c=j;
						return;
					}
				}
			}
		}
		
		static void check(int a[][],int n)
		{
			for(int i=0;i<4;i++)
			{
				if(a[i][0]==1&&a[i][1]==1&&a[i][2]==1&&a[i][3]==1)
				{
					a[i][0]=0;a[i][1]=0;a[i][2]=0;a[i][3]=0;
				}
			}
			for(int i=0;i<4;i++)
			{
				if(a[0][i]==1&&a[1][i]==1&&a[2][i]==1&&a[3][i]==1)
				{
					a[0][i]=0;a[1][i]=0;a[2][i]=0;a[3][i]=0;;
				}
			}
		}
		
		
		public static void main(String[] args) throws NumberFormatException, IOException {
			
			
		Scanner in=new Scanner (System.in);
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		ArrayList<Integer>list=new ArrayList<Integer>();
	
long n=in.nextLong();
long ans=Long.MAX_VALUE;
long sum=0;long sum2=(n*(n+1))/2;
if(sum2%2==0)
System.out.println(0);
else
	System.out.println(1);


		
		
		
		
		}
		
		
	}
