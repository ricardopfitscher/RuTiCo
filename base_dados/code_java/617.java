import java.util.Scanner;
public class P1075A
{
	public static void main(String[] args)
	{
	 Scanner scan=new Scanner(System.in);
	 long n,x,y;
	 n=scan.nextLong();
	 x=scan.nextLong();
	 y=scan.nextLong();
	 boolean flag=true,flag1=false,flag2=false;
	 long w1,w2,b1,b2;
	 long W=0l,B=0l;
	 w1=w2=1;		b1=b2=n;
	 while(w1<n)
		{
		 if(w1==x)
			{flag1=true;	break;}
		 if(w2==y)
			break;
		 ++w1;	++w2;	++W;
		}
	 if(flag1)
		W+=(y-w2);
	 else
		W+=(x-w1);
	 while(b1>1)
		{
		 if(b1==x)
			{flag2=true;	break;}
		 if(b2==y)
			break;
		 --b1;	--b2;	++B;
		}
	 if(flag2)
		B+=(b2-y);
	 else
		B+=(b1-x);
	 if(B<W)
		System.out.println("Black");
	 else
		System.out.println("White");
	}
}