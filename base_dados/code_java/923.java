import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int n = in.nextInt();

		int ans = n - (a + b - c);
		if(ans < 1 || a >= n || b >= n || c > a || c > b)
			ans = -1;
		
		System.out.println(ans);
		
		in.close();
	}
}