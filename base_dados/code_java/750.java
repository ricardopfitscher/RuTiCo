import java.util.*;
import java.io.*;
public class X
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		String s2 = br.readLine();
		int i=0;
		char c1,c2;
		int cost = 0;
		while(i<n)
		{
			c1 = s1.charAt(i);
			c2 = s2.charAt(i);
			if(c1 != c2)
			{
				if((i+1)<n && s1.charAt(i+1) != s2.charAt(i+1) && s1.charAt(i) != s1.charAt(i+1))
				{
					cost +=1;
					i++;
				}
				else
				{
					cost +=1;
				}
			}
			i++;
		}
		System.out.println(cost);
	}
}