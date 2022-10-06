import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            String s2[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            int m=Integer.parseInt(s1[1]);
            int a[]=new int[n];
            int b[]=new int[n];
            int c[]=new int[n];
            int d[]=new int[n];
            HashSet<Integer> hs=new HashSet<Integer>();
            hs.add(0);
            hs.add(m);
            int max=0;
            for(int i=0;i<n;i++)
            {
                  a[i]=Integer.parseInt(s2[i]);
                  if(i%2==0)
                   b[i]=1;
                  hs.add(a[i]);
            }
            
            c[0]=a[0];
            for(int i=1;i<n;i++)
            {
                  if(b[i]==0)
                   c[i]=c[i-1];
                  else
                   c[i]=c[i-1]+a[i]-a[i-1];
            }
            
            if(b[n-1]==0)
             d[n-1]=m-a[n-1];
            for(int i=n-2;i>=0;i--)
            {
                  if(b[i]==1)
                   d[i]=d[i+1];
                  else
                   d[i]=d[i+1]+a[i+1]-a[i];
            }
            
            max=c[n-1];
            if(b[n-1]==0)
             max+=m-a[n-1];
            //System.out.println(max);
            for(int i=n-1;i>=0;i--)
            {
                  int u=a[i]-1;
                  int v=a[i]+1;
                  if(!hs.contains(u))
                  {
                        if(b[i]==0)
                        {
                             int r=1+m-a[i]-d[i]+c[i-1];
                             max=Math.max(max,r);
                        }
                        else
                        {
                              int l=0;
                              if(i>0)
                               l=a[i-1];
                              int r=c[i]-1+m-a[i]-d[i];
                              max=Math.max(max,r);
                        }
                  }
                  
                  if(!hs.contains(v))
                  {
                        if(b[i]==0)
                        {
                           if(i==n-1)
                           {
                              int r=c[i]+1;
                              max=Math.max(max,r);
                           }
                           else
                           {
                               int r=c[i]+1+m-a[i+1]-d[i+1];
                               max=Math.max(max,r);
                           }
                        }
                        else
                        {
                                if(i==n-1)
                                {
                                   int r=c[i]+m-a[i]-1;
                                   max=Math.max(max,r);
                                }
                                else
                                {
                                    int r=c[i]+m-a[i+1]-d[i+1]+a[i+1]-1-a[i];  
                                    max=Math.max(max,r);
                                }
                        }
                  }
            }
            
            System.out.println(max);
      }
}