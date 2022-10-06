import java.io.*;
import java.lang.*;
import java.util.*;
public class alex
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int sum=1;
        for(int i=1;i<=n;i++)
        {
            sum=sum+(4*(i-1));
        }
        System.out.println(sum);
    }
}