import java.util.Scanner;

public class AlexAndARhombus {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(n*n+(n-1)*(n-1));
		sc.close();
	}

}
