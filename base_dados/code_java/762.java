import java.io.*;
import java.util.Scanner;
public class DivideCandies {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		int m = input.nextInt();
		long[] a = new long[m];
		for(int i = 0; i < m; i++)
		{
			if(i <= (n%m) && i != 0)
			{
				a[i] = n/m + 1;
			}
			else
			{
				a[i] = n/m;
			}
		}
		long result = 0L;
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < m; j++)
			{
				if((i * i + j * j) % m == 0)
				{
					result += a[i] * a[j];
				}
			}
		}
		System.out.println(result);
	}
}



