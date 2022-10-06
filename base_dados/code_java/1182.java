import java.util.*;
public class A
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        if(n==0)
        System.out.println(0);
        else if(n%2==1)
        System.out.println((n+1)/2);
        else
        System.out.println(n+1);
    }
}