import java.io.*;
import java.util.*;
public class codef
{
    public static void main(String ar[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String st[]=br.readLine().split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=Integer.parseInt(st[i]);

        int max=0;
        for(int i=0;i<n;i++)
        {
            if(i!=0 && a[i]>a[max])
                max=i;
        }
       // System.out.println(a[max]);
        int maxi=max;
        int i=max-1;
        while(i>=0)
        {
            if(a[i]>a[max])
            {
                System.out.println("NO");
                return;
            }
            max=i;
            i--;
        }
        max=maxi;
        i=max+1;
        while(i<n)
        {
            if(a[i]>a[max])
            {
                System.out.println("NO");
                return;
            }
            max=i;
            i++;
        }
        System.out.println("YES");
    }
}