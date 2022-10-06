import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int l = 1000, r = 0, u = 1000, b = 0;
		
		for(int i = 0; i < n; i++ ) {
			String str = in.next();
			for(int j = 0; j < m; j++)
				if(str.charAt(j) == 'B') {
					l = Math.min(j+1, l);
					r = Math.max(j+1, r);
					u = Math.min(i+1, u);
					b = Math.max(i+1, b);
				}
		}
		
		System.out.println((u+b)/2 + " " + (l+r)/2);
		
		in.close();
	}
}



