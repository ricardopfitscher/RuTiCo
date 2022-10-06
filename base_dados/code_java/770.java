import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author MaxHeap
 */
public class Main {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    CBanhMi solver = new CBanhMi();
    solver.solve(1, in, out);
    out.close();
  }

  static class CBanhMi {

    long mod = (long) (1e9 + 7);

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int q = in.nextInt();
      long[] two = new long[n + 1];
      two[0] = 1;
      for (int i = 1; i <= n; ++i) {
        two[i] = (two[i - 1] * 2L);
        two[i] %= mod;
      }

      char[] s = in.nextCharArray();
      int[] acc = new int[n + 1];
      for (int i = 1; i <= n; ++i) {
        acc[i] = s[i - 1] == '0' ? 0 : 1;
        acc[i] += acc[i - 1];
      }
      // 0 0 1 1 | 1: 1 1 2| 2: 2 3| 4: 5| 9
      // 0 1 1 1| 1: 1 2 2| 2: 3 3| 5: 6| 11
      // 0 1 1 wwqwq| 1: 1 2 2| 3: 5 3| 8: 8| 16
      // 0 0 1 1| 1: 1 1 2| 3: 3 3| 6: 6| 12
      // 0 0 0 1| 1: 1 1 1| 2: 2 2| 4: 4| 8
      while (q-- > 0) {
        int f = in.nextInt();
        int t = in.nextInt();
        int ones = acc[t] - acc[f - 1];
        int zeros = (t - f + 1) - ones;
        if (ones == 0) {
          out.println(0);
        } else {
          long ans = two[t - f + 1] - (zeros > 0 ? two[zeros] : 0);
          if (zeros == 0) {
            --ans;
          }
          ans = (ans + mod) % mod;
          out.println(ans);
        }
      }
    }

  }

  static class InputReader implements FastIO {

    private InputStream stream;
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int EOF = -1;
    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == EOF) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return EOF;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public String next() {
      int c;
      while (isSpaceChar(c = this.read())) {
      }

      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);

      while (!isSpaceChar(c = this.read())) {
        result.appendCodePoint(c);
      }

      return result.toString();
    }

    public static boolean isSpaceChar(int c) {
      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
    }

    public char[] nextCharArray() {
      return next().toCharArray();
    }

  }

  static interface FastIO {

  }
}

