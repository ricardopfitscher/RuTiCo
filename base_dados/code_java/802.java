import java.util.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        int q=scan.nextInt();
        int i;
        for(i=1;i<=q;i++)
        {
            int a=scan.nextInt();
            int ans=a/7+1;
            System.out.println(ans);
        }
    }
}