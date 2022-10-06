/*
 * Created on 17.05.2019
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Wolfgang Weck
 */
public class C01Easy {
	public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
			final String[] line = r.readLine().split(" ");
			final int N = Integer.parseInt(line[0]), P = Integer.parseInt(line[1]);
			final String[] numS = r.readLine().split(" ");
			if (numS.length != N) throw new IllegalArgumentException();
			final int[] n = new int[N];
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < N; i++) {
				n[i] = Integer.parseInt(numS[i]) % P;
				sum2 += n[i];
				if (sum2 >= P) sum2 -= P;
			}
			int max = sum2;
			for (int i = 0; i < N; i++) {
				sum1 += n[i];
				if (sum1 >= P) sum1 -= P;
				sum2 -= n[i];
				if (sum2 < 0) sum2 += P;
				final int s = sum1 + sum2;
				if (s > max) max = s;
			}
			System.out.println(max);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
