import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int n = input.nextInt();
		String s = input.next();
		boolean done = false;
		for (int i = 0; i < s.length() - 1; i++)
		{
			if (s.charAt(i) != s.charAt(i + 1))
			{
				System.out.println("YES");
				System.out.println(s.charAt(i) + "" + s.charAt(i + 1));
				done = true;
				break;
			}
		}
		if (!done)
		{
			System.out.println("NO");
		}
	}
}