import java.io.*;
import java.util.*;

public class Main {

    private static void solve(InputReader in, OutputWriter out) {
        int n = in.nextInt();

        List<List<Integer>> g = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            g.add(new LinkedList<>());
        }

        int degree1 = 0, degree2 = 0, root = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            g.get(a).add(b);
            g.get(b).add(a);

            if (g.get(a).size() > degree1) {

                if (a == root) {
                    degree1 = g.get(a).size();
                } else {
                    degree2 = degree1;
                    degree1 = g.get(a).size();
                    root = a;
                }

            } else if (g.get(a).size() > degree2) {
                degree2 = g.get(a).size();
            }

            if (g.get(b).size() > degree1) {

                if (b == root) {
                    degree1 = g.get(b).size();
                } else {
                    degree2 = degree1;
                    degree1 = g.get(b).size();
                    root = b;
                }

            } else if (g.get(b).size() > degree2) {
                degree2 = g.get(b).size();
            }
        }

        if (degree2 > 2) {
            out.print("No");
        } else {
            out.println("Yes");

            List<Integer> leaves = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (i != root) {
                    if (g.get(i).size() == 1) {
                        leaves.add(i);
                    }
                }
            }

            out.println(leaves.size());
            for (int i : leaves) {
                out.println(root + " " + i);
            }
        }
    }

    private static void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        solve(in, out);
        in.close();
        out.close();
    }

    private static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        InputReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
            st = null;
        }

        String nextLine() {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String line = nextLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        byte nextByte() {
            return Byte.parseByte(next());
        }

        short nextShort() {
            return Short.parseShort(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class OutputWriter {
        BufferedWriter bw;

        OutputWriter(OutputStream os) {
            bw = new BufferedWriter(new OutputStreamWriter(os));
        }

        void print(int i) {
            print(Integer.toString(i));
        }

        void println(int i) {
            println(Integer.toString(i));
        }

        void print(long l) {
            print(Long.toString(l));
        }

        void println(long l) {
            println(Long.toString(l));
        }

        void print(double d) {
            print(Double.toString(d));
        }

        void println(double d) {
            println(Double.toString(d));
        }

        void print(boolean b) {
            print(Boolean.toString(b));
        }

        void println(boolean b) {
            println(Boolean.toString(b));
        }

        void print(char c) {
            try {
                bw.write(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(char c) {
            println(Character.toString(c));
        }

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            print(s);
            print('\n');
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
