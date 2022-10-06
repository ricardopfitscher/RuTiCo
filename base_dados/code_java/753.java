import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] ar = new int[200];
		
		String str = in.next();
		for(int i = 0; i < str.length(); i++)
			ar[ str.charAt(i) ]++;
			
		int ans = 100000;
		
		for(int i = 'A'; i < 'A' + m; i++)
			ans = Math.min(ans, ar[i]);
		ans *= m;
		
		System.out.println(ans);
		
		in.close();
	}
}

