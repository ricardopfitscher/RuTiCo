import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int a=Integer.parseInt(s1[0]);
            int b=Integer.parseInt(s1[1]);
            int c=Integer.parseInt(s1[2]);
            int n=Integer.parseInt(s1[3]);
            int S=a+b-c;
            if(n-S<1 || c>Math.min(a,b))
             System.out.println("-1");
            else
             System.out.println(n-S);
      }
}