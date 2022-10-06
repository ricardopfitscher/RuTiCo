import java.util.*;
import java.lang.Math;
public class tab
{
public static void main(String[] args)
{
int n,pos,l,r;
Scanner sc=new Scanner(System.in);
n=sc.nextInt();
pos=sc.nextInt();
l=sc.nextInt();
r=sc.nextInt();
int sum;
int a=(n-r)+(l-1);
if((Math.abs(pos-l)<Math.abs(r-pos))&&a!=0)
{
 if(l!=1)
   {sum=Math.abs(pos-l);
    sum++;
    if(r!=n)
      sum+=(r-l)+1;
   }
 else
   sum=Math.abs(r-pos)+1;
}
else if(a==0)
  sum=0; 
else
{
  if(r!=n)
  {  sum=Math.abs(r-pos);
     sum++;
     if(l!=1) 
     sum+=(r-l)+1;
  }
  else
   sum=Math.abs(pos-l)+1;
}
System.out.println(sum);
}}