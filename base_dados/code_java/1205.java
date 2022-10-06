import java.util.*;
public class Pizza {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong() + 1;
		sc.close();
		System.out.println(num % 2 == 0 || num == 1 ? num / 2 : num);
	}
	
}
