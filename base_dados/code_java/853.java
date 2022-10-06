/*
 * Created on 17.05.2019
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Wolfgang Weck
 */
public class A01Medium {
	public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
			final String[] line = r.readLine().split(" ");
			final int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
			final char[][] m1 = readMatrix(r, N), m2 = readMatrix(r, M);
			final int[] h1 = rowHashes(m1), h2 = colHashes(m2);
			int i1 = 0, i2 = 0;
			while (i1 < h1.length && (h1[i1] != h2[i2]) || !matches(m1, i1, m2, i2)) {
				i2++;
				if (i2 == h2.length) {
					i2 = 0;
					i1++;
				}
			}
			System.out.println((i1 + 1) + " " + (i2 + 1));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static char[][] readMatrix(BufferedReader r, int n) throws IOException {
		char[][] m = new char[n][];
		for (int i = 0; i < n; i++) {
			m[i] = r.readLine().toCharArray();
		}
		return m;
	}

	private static int[] rowHashes(char[][] m) {
		int[] buf = new int[m[0].length];
		for (int i = 0; i < buf.length; i++) {
			int h = 0;
			for (int j = 0; j < buf.length; j++) {
				h = 29 * h + m[i][j];
			}
			buf[i] = h;
		}
		int[] hashes = new int[m.length - buf.length + 1];
		for (int i = 0; i < buf.length; i++) {
			hashes[0] = hashes[0] * 31 + buf[i];
		}
		int f = 1;
		for (int i = 1; i < buf.length; i++) {
			f = f * 31;
		}
		for (int i = 1; i < hashes.length; i++) {
			int b = (i - 1) % buf.length;
			hashes[i] = hashes[i - 1] - f * buf[b];
			int h = 0;
			for (int j = 0; j < buf.length; j++) {
				h = 29 * h + m[i + buf.length - 1][j];
			}
			buf[b] = h;
			hashes[i] = hashes[i] * 31 + h;
		}
		return hashes;
	}

	private static int[] colHashes(char[][] m) {
		int[] buf = new int[m.length];
		for (int i = 0; i < buf.length; i++) {
			int h = 0;
			for (int j = 0; j < buf.length; j++) {
				h = 31 * h + m[j][i];
			}
			buf[i] = h;
		}
		int[] hashes = new int[m[0].length - buf.length + 1];
		for (int i = 0; i < buf.length; i++) {
			hashes[0] = hashes[0] * 29 + buf[i];
		}
		int f = 1;
		for (int i = 1; i < buf.length; i++) {
			f = f * 29;
		}
		for (int i = 1; i < hashes.length; i++) {
			int b = (i - 1) % buf.length;
			hashes[i] = hashes[i - 1] - f * buf[b];
			int h = 0;
			for (int j = 0; j < buf.length; j++) {
				h = 31 * h + m[j][i + buf.length - 1];
			}
			buf[b] = h;
			hashes[i] = hashes[i] * 29 + h;
		}
		return hashes;
	}

	private static boolean matches(char[][] m1, int i1, char[][] m2, int i2) {
		int m = m2.length, i = 0, j = 0;
		while (i < m && m1[i1 + i][j] == m2[i][i2 + j]) {
			j++;
			if (j == m) {
				j = 0;
				i++;
			}
		}
		return i == m;
	}
}
