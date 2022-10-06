import java.util.Scanner;

public class MargariteBestPresent_1080B {

	private static int f(int x) {
		return (x%2==0)?x/2:(x-1)/2-x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,r,l;
		n = sc.nextInt();
		while(n-->0) {
			l = sc.nextInt();
			r = sc.nextInt();

			System.out.println(f(r)-f(l-1));
		}
		sc.close();
	}

}
