
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,ans=0;
		String sa,sb;
		char[] a,b;
		n=sc.nextInt();
		sa=sc.next();
		sb=sc.next();
		a=sa.toCharArray();
		b=sb.toCharArray();
		ans=0;
		for(int i=0;i<n;i++)
		{
			if(i==n/2)
			{
				if(a[i]!=b[i])
					ans++;
				continue;
			}
			int[] vis=new int[28];
			vis[a[i]-'a']++;
			vis[b[i]-'a']++;
			vis[a[n-1-i]-'a']++;
			vis[b[n-1-i]-'a']++;
			int num=0,ans1=0,ans2=0;
			for(int j=0;j<26;j++)
				if(vis[j]!=0)
				{
					num++;
					if(num==1)
						ans1=vis[j];
					else
						ans2=vis[j];
				}
			if(num==2)
			{
				if(ans1==1||ans2==1)
					ans++;
			}
			else if(num==3)
			{
				if(a[i]==a[n-i-1])
					ans+=2;
				else
					ans++;
			}
			else if(num==4)
				ans+=2;
			a[i]=b[i];
			a[n-1-i]=b[n-1-i];
		}
		System.out.println(ans);
	}
}