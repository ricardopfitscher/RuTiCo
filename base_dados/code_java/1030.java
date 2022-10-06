import java.util.*;
import java.math.*;
public class Split {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int k= sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n-1];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
			if(i>0)
				d[i-1] = a[i-1] - a[i];
		}
		Arrays.sort(d);
		int t = 0;
		for(int i=0;i<k-1;i++)
			t += d[i];
		System.out.println(a[n-1]-a[0]+t);
	}

}
