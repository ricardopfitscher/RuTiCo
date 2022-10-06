import java.util.*;
import java.math.*;
import java.io.*;

public class programA {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t1 = (int)Math.ceil((double)n*2/k);
		int t2 = (int)Math.ceil((double)n*5/k);
		int t3 = (int)Math.ceil((double)n*8/k);
		System.out.println(t1+t2+t3);
	}
}