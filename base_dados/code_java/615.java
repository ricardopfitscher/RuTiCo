import java .util.*;
import java .io.*;
public class Main{
	public static void main(String[]YAHIA_MOSTAFA){
		Scanner sc =new Scanner(System.in);
		long n=sc.nextLong(),x=sc.nextLong(),y=sc.nextLong();
		long xb,xw,yb,yw;
		xw=x-1;yw=y-1;xb=n-x;yb=n-y;
		if (x==n&&y==n){
			System.out.println("Black");return;
		}
		long c1=0,c2=0;
		long f =Math.max(xb,yb);
		long h =Math.max(xw,yw);
		//System.out.println(h+" "+f+" "+(h-f));
		if (h<=f)
			System.out.println("White");
		else
			System.out.println("Black");
	}
}