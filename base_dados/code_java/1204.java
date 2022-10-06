import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long ans = n+1;
		
		if(ans == 1)
			ans = 0;
		if(ans % 2 == 0)
			ans /= 2;
		
		System.out.println(ans);
		
		in.close();
	}
}