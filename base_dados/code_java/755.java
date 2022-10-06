import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

public class gambling {
    public static void main(String[] args) throws IOException{
        Reader rd = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int n = rd.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = rd.nextInt();
        }
        solve(n, a, b, out);
        out.flush();
        out.close();
    }

    private static void solve(int n, Integer[] a, Integer[] b, PrintWriter out) {
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());
        int aP = 0, bP = 0;
        long aScore = 0, bScore = 0;
        for (int i = 0; i < n * 2; i++) {
                if(i % 2 == 0) {
                    if(bP ==  n || (aP < n && a[aP] > b[bP])){
                        aScore += a[aP];
                        aP++;
                    }
                    else bP++;
                }
                else{
                    if(aP == n || (bP < n && b[bP] > a[aP])) {
                        bScore += b[bP];
                        bP++;
                    }
                    else aP++;
                }
        }
        out.println(aScore-bScore);
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
