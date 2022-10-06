import java.util.*;
import java.io.*;
public class Piles {
	static int summation(int arr[]) {
		int k, sum=0;
		for(k=0;k<arr.length;k++) {
			sum = sum + arr[k];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>=1 && n<=50) {
			int x[] = new int[n];
			int y[] = new int[n];
			
			for(int i=0;i<n;i++) {
				x[i] = sc.nextInt();
			}
			for(int j=0;j<n;j++) {
				y[j] = sc.nextInt();
			}
			int xsum = summation(x);
			int ysum = summation(y);
			if(xsum>=ysum) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		

	}

}
