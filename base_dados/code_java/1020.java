import java.io.*;
import java.util.*;

public class ayyyyyy
{
	public static void main(String[] args) { new ayyyyyy(); }
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	int t, n;
	int[] a;
	
	ayyyyyy()
	{
		t = in.nextInt();
		while (t --> 0)
		{
			a = new int[n = in.nextInt()];
			for (int i = 0; i < n; i++)
				a[i] = in.nextInt();
			shuffle(a);
			Arrays.sort(a);
			out.println(Math.min(n-2, a[n-2]-1));
		}
		
		out.close();
	}
	
	void shuffle(int[] x)
	{
		for (int i = 0; i < n; i++)
		{
			int swp = (int)(n*Math.random());
			int tmp = x[swp];
			x[swp] = x[i];
			x[i] = tmp;
		}
	}
}