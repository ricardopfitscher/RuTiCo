/*
 * Created on 17.05.2019
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Wolfgang Weck
 */
public class A01Easy {
	private static interface Matrix {
		boolean get(int i, int j);

		int size();
	}

	private static class MData implements Matrix {
		private final boolean[][] m;

		MData(boolean[][] m) {
			this.m = m;
		}

		@Override
		public boolean get(int i, int j) {
			return m[i][j];
		}

		@Override
		public int size() {
			return m.length;
		}
	}

	private static abstract class MDecorator implements Matrix {
		protected final Matrix inner;

		MDecorator(Matrix inner) {
			this.inner = inner;
		}

		@Override
		public int size() {
			return inner.size();
		}
	}

	private static class MHFlip extends MDecorator {
		MHFlip(Matrix inner) {
			super(inner);
		}

		@Override
		public boolean get(int i, int j) {
			return inner.get(size() - 1 - i, j);
		}
	}

	private static class MVFlip extends MDecorator {
		MVFlip(Matrix inner) {
			super(inner);
		}

		@Override
		public boolean get(int i, int j) {
			return inner.get(i, size() - 1 - j);
		}
	}

	private static class MRot extends MDecorator {
		MRot(Matrix inner) {
			super(inner);
		}

		@Override
		public boolean get(int i, int j) {
			return inner.get(j, size() - 1 - i);
		}
	}

	public static void main(String[] args) {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
			final int N = Integer.parseInt(r.readLine());
			Matrix m1 = readMatrix(r, N), m2 = readMatrix(r, N);
			boolean matched = matchesFlipped(m1, m2);
			int i = 0;
			while (i < 3 && !matched) {
				m1 = new MRot(m1);
				matched = matchesFlipped(m1, m2);
				i++;
			}
			System.out.println(matched ? "Yes" : "No");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Matrix readMatrix(BufferedReader r, int n) throws IOException {
		boolean[][] m = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = r.readLine();
			for (int j = 0; j < n; j++) {
				m[i][j] = line.charAt(j) == 'X';
			}
		}
		return new MData(m);
	}

	private static boolean matches(Matrix m1, Matrix m2) {
		int i = 0, j = 0, n = m1.size();
		while (i < n && m1.get(i, j) == m2.get(i, j)) {
			j++;
			if (j == n) {
				j = 0;
				i++;
			}
		}
		return i == n;
	}

	private static boolean matchesFlipped(Matrix m1, Matrix m2) {
		return matches(m1, m2) || matches(new MHFlip(m1), m2) || matches(new MVFlip(m1), m2);
	}
}
