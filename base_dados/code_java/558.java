
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int tmp;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			tmp=sc.nextInt();
			if(i>n-1-i) {
				tmp=tmp/i;
			}else {
				tmp=tmp/(n-1-i);
			}
			if(tmp<min) {
				min=tmp;
			}
		}
		System.out.println(min);
	}
}
