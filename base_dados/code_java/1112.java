import java.util.*;
import java.io.*;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String s1[]=br.readLine().split(" ");
            int n=Integer.parseInt(s1[0]);
            int S=Integer.parseInt(s1[1]);
            if(S%n==0)
             System.out.println(S/n);
            else
             System.out.println(S/n+1);
      }
}