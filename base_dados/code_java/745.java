import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long m = in.nextLong();
		
		long ans = m / n;
		
		if(m % n > 0)
			ans++;
		
		System.out.println(ans);
		
		in.close();
	}
}

