
import java.util.*;
import java.io.*;

public class TokitsukazeAndEnhancement {
	
	static char check(int n) {
		if(n%4 == 0)
			return 'D';
		if(n%4 == 1)
			return 'A';
		if(n%4 == 2)
			return 'C';
		return 'B';
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int a = n + 1;
		int b = n + 2;
		char n1 = check(n);
		char a1 = check(a);
		char b1 = check(b);
		char sol = (char) Math.min(Math.min(a1, b1),n1);
		if(sol == n1)
			pw.println(0 + " " + sol);
		else if(sol == a1)
			pw.println(1 + " " + sol);
		else if(sol == b1)
			pw.println(2 + " " + sol);
		pw.close();
	}
}
