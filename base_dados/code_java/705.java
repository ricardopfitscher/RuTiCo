import java.util.*;
import java.math.*;
public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int a[]=new int[m+1];
        int i,j;
        int c=0;
        for(i=0;i<n;i++)
        {
            int l=scan.nextInt();
            int r=scan.nextInt();
            for(j=l;j<=r;j++)
            {
                if(a[j]!=1)
                {
                    a[j]=1;
                    c++;
                }
            }
        }
        System.out.println(m-c);
        for(i=1;i<=m;i++)
        {
            if(a[i]==0)
            {
                System.out.print(i+" ");
            }
        }
    }
}