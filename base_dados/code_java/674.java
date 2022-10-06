import java.math.BigInteger;
import java.util.Scanner;


public class RelativelyPrimeGraph {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		getResult(n, m);
		sc.close();
	}

	static void getResult(int n, int m) {
		if(m<n-1) {
			System.out.println("Impossible");
			System.exit(0);
		}
		int numEdges = 0;
		StringBuilder res = new StringBuilder("");
		BigInteger curNum = BigInteger.ONE;
		for(int i = 1; i<n; i++) {
			for(int j = i + 1; j<=n; j++) {
				if(gcd(j, i)==1) {
					res.append(i + " " + j + "\n");
					numEdges++;
					if(numEdges==m) {
						System.out.println("Possible");
						System.out.println(res);
						System.exit(0);
					}
				}
			}
			curNum = curNum.add(BigInteger.ONE);
		}
		System.out.println("Impossible");
	}

	//assumes a>b
	static int gcd(int a, int b) {
		if(b==1) {
			return 1;
		}
		if(b==0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}

	static boolean isPrime(BigInteger x) {
		if(x.equals(BigInteger.ONE)) {
			return true;
		}
		return x.isProbablePrime(20);
	}
}
