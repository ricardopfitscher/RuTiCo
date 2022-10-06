import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        /*int n = stdin.nextInt();
        for(int i = 0; i < n; i++)
        {
        	test(stdin);
        }*/
        test(stdin);
        stdin.close();
    }
    public static void test(Scanner stdin)
    {
    	int n = stdin.nextInt();
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < n; i++)
    	{
    		int a = stdin.nextInt();
    		if((int)((1.0)*a/(Math.max(i, n - i - 1))) < min)
    		{ min = (int)((1.0)*a/(Math.max(i, n - i - 1))); }
    	}
    	System.out.println(min);
    }
}