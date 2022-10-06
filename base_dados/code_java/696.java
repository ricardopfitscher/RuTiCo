import java.util.Scanner;

public class Piles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = new int[2]; int x = scan.nextInt();
		for(int i = 0; i < 2; i++) for(int j = 0; j < x; j++) a[i] += scan.nextInt();
		System.out.println(a[1] <= a[0] ? "Yes" : "No");

	}

}
