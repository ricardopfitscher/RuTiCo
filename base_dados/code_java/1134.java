import java.io.*;
import java.util.*;
import java.math.*;

public class Main
{
	//static long k = 0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(st.readLine());
		long n = Long.parseLong(s.nextToken());
		long k = Long.parseLong(s.nextToken());
		long ans = k/n;
		if(k%n != 0) ans++;
		System.out.println(ans+"");
	}
}