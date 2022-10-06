import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int cnt = 0;
		String ans = "Yes";
		
		for(int i = 0; i < n; i++)
			cnt += in.nextInt();
		for(int i = 0; i < n; i++)
			cnt -= in.nextInt();
		
		if(cnt < 0)
			ans = "No";
		
		System.out.println(ans);
				
		in.close();
	}
}
