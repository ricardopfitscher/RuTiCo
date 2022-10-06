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
		int ans = Integer.MAX_VALUE;
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		for (int i=1;i<n;i++) {
			ans = Math.min(ans, Math.min(arr[i],arr[0])/i);
		}
		for (int i=n-2;i>=0;i--){
			ans = Math.min(ans, Math.min(arr[n-1],arr[i])/(n-i-1));
		}
		System.out.println(ans);
	}
}