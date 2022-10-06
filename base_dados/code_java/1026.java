import java.util.Scanner;
 
public class pillar {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[200005];
		for (int i=1;i<=n;i++) 
		a[i]=sc.nextInt();
		for (int i=2;i<n;i++) 
		if (a[i-1]>a[i]&&a[i]<a[i+1]) {
			System.out.println("NO");
			return;
		}
		System.out.println("YES");
	}
}

