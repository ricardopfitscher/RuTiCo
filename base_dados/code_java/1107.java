import java.util.*;

public class A912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int B = scan.nextInt();
		long x = scan.nextInt();
		long y = scan.nextInt();
		long z = scan.nextInt();
		
		long requiredA = x * 2 + y;
		long requiredB = y + z * 3;
		
		long neededA = Math.max(0, requiredA - A);
		long neededB = Math.max(0, requiredB - B);
		System.out.print(neededA + neededB);
	}

}
