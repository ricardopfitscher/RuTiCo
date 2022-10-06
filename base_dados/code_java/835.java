import java.util.*;
import java.math.*;
public class Main{
    public static void main(String [] args)
    {
        Scanner scan=new Scanner(System.in);
        long n=scan.nextLong();
        long m=scan.nextLong();
        n=(long)Math.pow(2,n);
        long ans=m%n;
        System.out.println(ans);
    }
}