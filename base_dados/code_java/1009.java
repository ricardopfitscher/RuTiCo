import java.util.*;
public class Kello
{
    public static void  main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int n,q,m,max,inp,k,i;
        long in_q;
        n=sc.nextInt();
        q=sc.nextInt();
        int a[]=new int[n-1];
        int b[]=new int[n-1];
        int c[]=new int[n-1];
        max=sc.nextInt();
        for(i=0;i<n-1;i++)
        {
            inp=sc.nextInt();
            a[i]=max;
            b[i]=inp;
            if(inp>max)
            {
                c[i]=max;
             max=inp;
        }
        else
        c[i]=inp;
    }
   // display(a,b);
        for(i=0;i<q;i++)
        {
            in_q=sc.nextLong();
            if(in_q<n)
            System.out.println(a[(int)in_q-1]+" "+b[(int)in_q-1]);
          else   {
          k=(int)(in_q %(n-1))-1;
          if(k==-1)
          k=n-2;
          System.out.println(max+" "+c[k]);
            }
        }
    }
    public static void display(int a[],int b[])
    {
        int i;
        for(i=0;i<a.length;i++)
        System.out.println(a[i]+" "+b[i]);
}
}

              