import java.util.*;

public class helloWorld 
{
	static ArrayList<Integer> ar;
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		StringBuilder ans = new StringBuilder();
		if(n <= 2)
			ans.append("No");
		else if(n == 4) {
			ans.append("Yes\n");
			ans.append("1 2\n");
			ans.append("3 1 3 4\n");
		}
		else  {
			ans.append("Yes\n");
			if(n % 2 == 1) {
				int a = (n+1)/2;
				ans.append("1 ");
				ans.append(a);
				ans.append("\n");
				ans.append(n-1);
				for(int i = 1; i < a; i++)
					ans.append(" " + i);
				for(int i = a+1; i <= n; i++)
					ans.append(" " + i);
			}
			else {
				int a = n/2;
				ans.append("2 ");
				ans.append(a + " ");
				ans.append(a+1 + " \n");
				ans.append(n-2);
				for(int i = 1; i < a; i++)
					ans.append(" " + i);
				for(int i = a+2; i <= n; i++)
					ans.append(" " + i);
			}
		}
		
		System.out.println(ans);
		
		in.close();
	}
}