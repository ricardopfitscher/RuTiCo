import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class codef
{
    public static void main(String ar[]) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nk=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(nk.nextToken());
        int k=Integer.parseInt(nk.nextToken());
        String st[]=br.readLine().split(" ");
        
        int ans[]=new int[n];
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            ans[i]=Integer.parseInt(st[i]);  

        for(int i=1;i<n;i++)
            a[i]=ans[i]-ans[i-1];
        a[0]=-1;

        Arrays.sort(a);
        int count=0,sum=0;
        for(int i=0;i<n;i++)
            if(a[i]<0)
                count++;
            else
                sum=sum+a[i];
        
        k=k-count;
        int i=n-1;
        while(k>0 && i>=0)
        {
            if(a[i]>-1)
            {
                sum=sum-a[i];
                k--;
            }
            i--;
        }
        System.out.println(sum);
    }
}