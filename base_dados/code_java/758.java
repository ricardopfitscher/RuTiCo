import java.util.*;
import java.io.*;

public class FirstClass {
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int [n];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < n ; i++)
		{
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		int max = -1;
		boolean flag = true;
		
		for(int i = 0 ; i < n ; i++)
		{
			if(arr[i] > max+1)
			{
				flag = false;
				out.println(i+1);
				break;
			}
			else
			{
				max = Math.max(max, arr[i]);
			}
		}
		
		if(flag)
			out.println(-1);
	
		out.flush();
		out.close();
	}

}
