import java.util.*;
import java.lang.*;
import java.io.*;

public class java2 {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n=r.nextInt();
        int []l=new int[1005];
        int []ri=new int[1005];
        int []candy=new int[1005];
        for(int i=1;i<=n;++i)
        {
            l[i]=r.nextInt();
        }
        for(int i=1;i<=n;++i)
        {
            ri[i]=r.nextInt();
        }
        for(int i=1;i<=n;++i)
        {
            if(l[i]>i-1||ri[i]>n-i)
            {
                System.out.println("NO");
                System.exit(0);
            }
            candy[i]=n-l[i]-ri[i];
        }
        for(int i=1;i<=n;++i)
        {
            int left=0,right=0;
            for(int j=1;j<=i-1;++j)
            {
                if(candy[j]>candy[i])
                {
                    ++left;
                }
            }
            for(int j=i+1;j<=n;++j)
            {
                if(candy[j]>candy[i])
                {
                    ++right;
                }
            }
            if(left!=l[i]||right!=ri[i])
            {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
        for(int i=1;i<=n;++i)
        {
            System.out.print(candy[i]+" ");
        }
    }
}
