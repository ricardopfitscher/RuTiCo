import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k = input.nextInt();
		int n = input.nextInt();
		int s = input.nextInt();
		int p = input.nextInt();

		int each = n / s;
		if (n % s != 0)
		{
			each++;
		}
		int all = each * k;

		if (all % p == 0)
		{
			System.out.println(all / p);
		} else
		{
			System.out.println(all / p + 1);
		}
	}
}