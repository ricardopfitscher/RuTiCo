import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		String str = in.next();
		boolean[] exist = new boolean[200];
		int dn[][] = new int[200][m+1];
		
		for(int i = 0; i < n; i++) {
			int a = str.charAt(i);
			exist[a] = true;
			dn[a][1] = a - 'a' + 1;
		}
		
		for(int k = 2; k <= m; k++) 
			for(int i = 'a'; i <= 'z'; i++)
				if(exist[i]) {
					int a = 0;
					for(int j = i+2; j <= 'z'; j++)
						if(dn[j][k-1] > 0 && (a == 0 || (a > dn[j][k-1]) ) ) 
							a = dn[j][k-1];
					if(a > 0)
						dn[i][k] = a + i - 'a' + 1; 
				}
		
		int ans = -1;
		for(int i = 'a'; i <= 'z'; i++)
			if(dn[i][m] > 0 && (ans == -1 || ans > dn[i][m]) )
				ans = dn[i][m];
		
		System.out.println(ans);
		
		in.close();
	}
}	



