

import java.util.Scanner;
public class Stones {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int s1=0;
		int s2=0;
		for (int i=0;i<n;++i)
			s1+=input.nextInt();
		for (int i=0;i<n;++i)
			s2+=input.nextInt();
		if (s1 >= s2)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
