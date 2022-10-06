import java.util.*;
public class Test { public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
int n= sc.nextInt();
int x= (int)Math.sqrt(n) ;
int a[] = new int[n+5];
for(int i=1,o=n,j;i<=n;i+=x)
for(j=(int)Math.min(i+x-1,n);j>=i;a[j--]=o--);
for(int i=1;i<=n;i++)System.out.print(a[i]+" ");
System.out.println();


} 
}