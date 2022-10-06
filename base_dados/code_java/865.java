import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sumit
 */
public class Main {
      public static void main(String[] args) {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            OutputWriter out = new OutputWriter(outputStream);
            CChessboard solver = new CChessboard();
            solver.solve(1, in, out);
            out.close();
      }

      static class CChessboard {
            int[] nextPermutation(int[] array) {
                  int i = array.length - 1;
                  while (i > 0 && array[i - 1] >= array[i]) {
                        i--;
                  }

                  if (i <= 0) {
                        return null;
                  }

                  int j = array.length - 1;

                  while (array[j] <= array[i - 1]) {
                        j--;
                  }

                  int temp = array[i - 1];
                  array[i - 1] = array[j];
                  array[j] = temp;

                  j = array.length - 1;

                  while (i < j) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        i++;
                        j--;
                  }

                  return array;
            }

            public void solve(int testNumber, InputReader in, OutputWriter out) {
                  int n = in.nextInt();
                  int arr[][][] = new int[4][n][n];
                  int sum[] = new int[4];

                  for (int k = 0; k < 4; k++) {
                        for (int i = 0; i < n; i++) {
                              String str = in.next();
                              for (int j = 0; j < n; j++) {
                                    arr[k][i][j] = (str.charAt(j) - '0');
                              }
                        }
                  }

                  for (int k = 0; k < 4; k++) {
                        for (int i = 0; i < n; i++) {
                              for (int j = 0; j < n; j++) {
                                    if ((i + j) % 2 == arr[k][i][j])
                                          sum[k]++;
                              }
                        }
                  }

                  int perm[] = new int[4];
                  for (int i = 0; i < 4; i++)
                        perm[i] = i;


                  int min = Integer.MAX_VALUE;
                  while (true) {
                        perm = nextPermutation(perm);

                        if (perm == null)
                              break;

                        int sm = 0;
                        for (int j = 0; j < 4; j++) {
                              if (j % 2 == 0) {
                                    sm += (sum[perm[j]]);
                              } else {
                                    sm += (n * n - sum[perm[j]]);
                              }
                        }
                        min = Math.min(min, sm);

                        sm = 0;
                        for (int j = 0; j < 4; j++) {
                              if (j % 2 == 0) {
                                    sm += (n * n - sum[perm[j]]);
                              } else {
                                    sm += (sum[perm[j]]);
                              }
                        }
                        min = Math.min(sm, min);


                  }
                  out.printLine(min);


            }

      }

      static class OutputWriter {
            private final PrintWriter writer;

            public OutputWriter(OutputStream outputStream) {
                  writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            }

            public OutputWriter(Writer writer) {
                  this.writer = new PrintWriter(writer);
            }

            public void close() {
                  writer.close();
            }

            public void printLine(int i) {
                  writer.println(i);
            }

      }

      static class InputReader {
            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;

            public InputReader(InputStream stream) {
                  this.stream = stream;
            }

            public int read() {
                  if (numChars == -1)
                        throw new InputMismatchException();

                  if (curChar >= numChars) {
                        curChar = 0;
                        try {
                              numChars = stream.read(buf);
                        } catch (IOException e) {
                              throw new InputMismatchException();
                        }
                        if (numChars <= 0)
                              return -1;
                  }

                  return buf[curChar++];
            }

            public int nextInt() {
                  int c = read();

                  while (isSpaceChar(c))
                        c = read();

                  int sgn = 1;

                  if (c == '-') {
                        sgn = -1;
                        c = read();
                  }

                  int res = 0;

                  do {
                        if (c < '0' || c > '9')
                              throw new InputMismatchException();

                        res *= 10;
                        res += c & 15;

                        c = read();
                  } while (!isSpaceChar(c));

                  return res * sgn;
            }

            public String next() {
                  int c = read();

                  while (isSpaceChar(c))
                        c = read();

                  StringBuilder res = new StringBuilder();

                  do {
                        res.appendCodePoint(c);

                        c = read();
                  } while (!isSpaceChar(c));

                  return res.toString();
            }

            public boolean isSpaceChar(int c) {
                  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

      }
}

