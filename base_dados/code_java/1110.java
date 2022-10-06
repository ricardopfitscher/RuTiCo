import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
		int n = sc.nextInt();
		int pos = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		/*if(l==r) {
			System.out.print(Math.abs(r-pos)+1);
		}*/
		if(l==1&&r==n) {
			System.out.println(0);
		}
		else if(l==1&&r<n) {
			System.out.println(Math.abs(r-pos)+1);
		}
		else if(l>1&&r==n) {
			System.out.println(Math.abs(l-pos)+1);
		}
		else if(l>1&&r<n) {
			int c = Math.min(Math.abs(r-pos), Math.abs(l-pos));//Math.abs(r-pos)>Math.abs(l-pos)?Math.abs(l-pos):Math.abs(r-pos);
			System.out.println(c+2+r-l);
		}
		}
	}	
}





