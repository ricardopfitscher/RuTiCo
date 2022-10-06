    import java.io.*;
    import java.util.*;
    import java.util.LinkedList;

    public class Main {

        public static void main(String[] args) throws IOException
        {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);

            int k = in.nextInt();
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int list = n%s == 0 ? n/s : n/s + 1;
            int totalList = list*k;
            int pack = totalList%p == 0 ? totalList/p : totalList/p + 1;
            out.println(pack);
            out.println();

            out.flush();
        }
        static boolean isPrime(int n) {
            for (int i = 2; i*i <=n; i++) {
                if(n%i==0) return false;
            }
            return true;
        }
    }
    class Point {
        int index;
        int value;

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
        public Point(int value,int index) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return index + " " + value;
        }
    }

    class InputReader extends BufferedReader {
        StringTokenizer tokenizer;

        public InputReader(InputStream inputStream) {
            super(new InputStreamReader(inputStream), 32768);
        }

        public InputReader(String filename) {
            super(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }
        public Long nextLong() {
            return  Long.valueOf(next());
        }
        public Double nextDouble () {
            return Double.valueOf(next());
        }


        static class OutputWriter extends PrintWriter {
            public OutputWriter(OutputStream outputStream) {
                super(outputStream);
            }

            public OutputWriter(Writer writer) {
                super(writer);
            }

            public OutputWriter(String filename) throws FileNotFoundException {
                super(filename);
            }

            public void close() {
                super.close();
            }
        }
    }
