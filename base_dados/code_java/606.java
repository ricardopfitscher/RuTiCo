import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            int m=Integer.parseInt(s1[1]);
            int a[]=new int[n];
            String s2[]=br.readLine().split(" ");
            long S=0;
            for(int i=0;i<n;i++)
            { a[i]=Integer.parseInt(s2[i]);  S+=(long)a[i]; }
            
            Arrays.sort(a);
            m=a[n-1];
            int last=1;
            int t=1;
            for(int i=1;i<n-1;i++)
            {
                  if(a[i]==last)
                   t++;
                  else
                  {
                        t++;
                        last=last+1;
                  }
            }
            if(last<m)
            { t+=m-last; }
            else
             t++;
            System.out.println(S-t);
      }
}