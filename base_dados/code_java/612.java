import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            long x=Long.parseLong(s1[1]);
            long y=Long.parseLong(s1[2]);
            long S=0;
            long mod=1000000007;
            B a[]=new B[n];
            TreeMap<Long,Long> tm=new TreeMap<Long,Long>();
            long ans[]=new long[n];
            for(int i=0;i<n;i++)
            {
              String s2[]=br.readLine().split(" ");
              long l=Long.parseLong(s2[0]);
              long r=Long.parseLong(s2[1]);
              B b1=new B(l,r);
              a[i]=b1;
            }
            Arrays.sort(a,new The_Comp());
            
            for(int i=0;i<n;i++)
            {
                  long l=a[i].x;
                  long r=a[i].y;
                  if(tm.floorKey(l-1)!=null)
                  {
                        long u=tm.floorKey(l-1);
                        long v=l;
                        if((v-u)*y<x)
                        { ans[i]=((r-u)*y)%mod; 
                          if(tm.get(u)>1)
                           tm.put(u,tm.get(u)-1);
                          else
                          tm.remove(u); 
                        }
                        else
                        { ans[i]=(x+(r-l)*y)%mod; }
                  }
                  else
                   ans[i]=(x+(r-l)*y)%mod;
                  S=(S+ans[i])%mod;
                  if(tm.containsKey(r))
                   tm.put(r,1+tm.get(r));
                  else
                   tm.put(r,(long)1);
            }
            System.out.println(S);
      }
}


class The_Comp implements Comparator<B>
{
      public int compare(B b1,B b2)
      {
            if(b1.x>b2.x)
             return 1;
            else if(b1.x==b2.x)
            {
            if(b1.y>b2.y)
             return 1;
            else if(b1.y==b2.y)
             return 0;
            else
             return -1;
            }
            else
             return -1;
      }
}
class B
{
      long x=(long)1;
      long y=(long)1;
      public B(long l1,long l2)
      { x=l1;  y=l2; }
}