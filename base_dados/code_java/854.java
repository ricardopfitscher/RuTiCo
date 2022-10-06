import java.util.Scanner;
public class Codeforces {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, f[], c=0;
		n = in.nextInt();
		f = new int[n];
		while (--n>0){
			f[in.nextInt()-1] ++;
			f[in.nextInt()-1]++;
			in.nextLine();
		}
		for(int i=0; i<f.length; i++) if (f[i] == 1) c++;
		System.out.println(c);
	}

}
