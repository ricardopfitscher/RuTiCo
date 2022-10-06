import java.util.*;

public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        char c[]=new char[n];
        Arrays.fill(c,'o');
        int x=1,y=1,z;
        while(y<=n)
        {
            c[y-1]='O';
            z=x+y;
            x=y;
            y=z;
        }
        String ans=new String(c);
        System.out.println(ans);
    }
}