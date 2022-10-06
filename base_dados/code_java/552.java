/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int ans = 0;
		String inp = s.nextLine();
		for(int i=0;i<n;i++) {
			char k = inp.charAt(i);
			if (k == '+')
				ans++;
			if (k == '-') {
				if (ans>0)
					ans--;
			}
		}
		System.out.println(ans);
	}
}