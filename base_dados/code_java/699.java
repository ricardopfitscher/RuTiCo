//package contese_476;
import java.util.*;
public class q1 
{
	int m=(int)1e9+7;
public class Node
{
	int a;
	int b;
	public void Node(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
}
public int mul(int a ,int b)
{
a=a%m;
b=b%m;
return((a*b)%m);
}
public int pow(int a,int b)
{
	int x=1;
	while(b>0)
	{
		if(b%2!=0)
			x=mul(x,a);
		a=mul(a,a);
		b=b/2;
	}
	return x;
}
public static long gcd(long a,long b)
{
	if(b==0)
		return a;
	else
		return gcd(b,a%b);
}
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	HashMap<Integer,Integer> h=new HashMap();
	//HashMap<Integer,Integer> h1=new HashMap();
	int[] a=new int[n];
	int x=sc.nextInt();
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
		if(h.get(a[i])==null)
		{
			h.put(a[i], 1);
			//h1.put(a[i],i);
		}
		else
		{
			System.out.print(0);
			System.exit(0);
		}
	}
	for(int i=0;i<n;i++)
	{
		int num=a[i]&x;
		if(num==a[i])
			continue;
		if(h.get(num)==null)
			continue;
		
		else
		{
			
			System.out.print(1);
			System.exit(0);
		}
	}
	for(int i=0;i<n;i++)
	{
		int num=a[i]&x;
		if(num==a[i])
			continue;
		if(h.get(num)==null)
			h.put(num, 1);
		else
		{
			System.out.print(2);
			System.exit(0);
		}
	}
	System.out.print(-1);
	
     
}

}