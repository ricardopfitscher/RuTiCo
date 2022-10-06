import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            int a[][]=new int[n][3];
            long b[]=new long[n];
            String s1[]=br.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                  b[i]=Long.parseLong(s1[i]);
                  a[i][0]=i;
                  long u=b[i];
                  while(u%2==0)
                  { a[i][2]++; u=u/2; }
                  
                  while(u%3==0)
                  { a[i][1]++; u=u/3; }
            }
            
            Arrays.sort(a,new Comparator<int[]>(){
                  public int compare(final int f1[],final int f2[])
                  {
                        if(f1[1]>f2[1])
                         return -1;
                        else if(f1[1]==f2[1])
                        {
                        if(f1[2]>f2[2])
                         return 1;
                        else if(f1[2]==f2[2])
                         return 0;
                        else
                         return -1;
                        }
                        else
                         return 1;
                  }
            });
            
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<n;i++)
             sb.append(b[a[i][0]]).append(" ");
            System.out.println(sb);
      }
}