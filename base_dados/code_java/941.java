
import java.io.*;
import java.util.*;
public class D999 {
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int req=n/m;
        int arr[]=new int[n+1];
        int size[]=new int[m];
        List<Integer> list[]=new ArrayList[m];
        for(int i=0;i<m;i++)
        {
            list[i]=new ArrayList<>();
        }
        for(int i=1;i<=n;i++)
        {
            arr[i]=sc.nextInt();
            size[arr[i]%m]++;
            list[arr[i]%m].add(i);
        }
        long tot=0;int x=0,y=0;
        List<Integer> idx=new ArrayList<>();
        for(int i=0;i < 2*m;i++)
        {
            //System.out.println(i+" "+size[i%m]);
            if(size[i%m]>req)
            {
                for(int j=0;j<size[i%m]-req;j++)
                {
                    idx.add(list[i%m].get(j));
                    y++;
                    
                }
                size[i%m]=req;
                //System.out.println(i+" "+x+" "+y);
            }
            else if(size[i%m]<req)
            {
                //System.out.println(idx+" "+i);
                while(x!=y && size[i%m]<req)
                {
                    int num=arr[idx.get(x)];
                    int gg=i-num%m;
                    tot+=gg;
                    arr[idx.get(x)]+=gg;
                    x++;
                    size[i%m]++;
                }
            }
        }
        System.out.println(tot);
        for(int i=1;i<=n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}