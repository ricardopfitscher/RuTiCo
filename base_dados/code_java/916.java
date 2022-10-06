import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        String s=io.nextLine();
        if (s.length()<3)io.println("No");
        else {
            int[]b=new int[200];
            for (int i=2;i<s.length();i++){
                b['.']=b['A']=b['B']=b['C']=0;
                b[s.charAt(i-2)]=1;
                b[s.charAt(i-1)]=1;
                b[s.charAt(i)]=1;
                if (b['A']+b['B']+b['C']==3){io.println("Yes");return;}
            }
            io.println("No");
        }
    }


    static class IO {

        BufferedInputStream din;
        final int BUFFER_SIZE = 1 << 16;
        byte[] buffer;
        int byteRead, bufferPoint;

        StringBuilder builder;
        PrintWriter pw;

        public IO() {
            din = new BufferedInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPoint = byteRead = 0;

            builder = new StringBuilder();
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    System.out
            )), true);
        }

        int read() {
            if (bufferPoint >= byteRead) {
                try {
                    byteRead = din.read(buffer, bufferPoint = 0, BUFFER_SIZE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (byteRead == -1) buffer[0] = -1;
            }
            return buffer[bufferPoint++];
        }

        int peek() {
            if (byteRead == -1) return -1;
            if (bufferPoint >= byteRead) {
                try {
                    byteRead = din.read(buffer, bufferPoint = 0, BUFFER_SIZE);
                } catch (IOException e) {
                    return -1;
                }
                if (byteRead <= 0) return -1;
            }
            return buffer[bufferPoint];
        }

        boolean hasNext() {
            int c = peek();
            while (c != -1 && c <= ' ') {
                read();
                c = peek();
            }
            return c != -1;
        }

        char nextChar() {
            int c = read();
            while (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1) {
                c = read();
            }
            return (char) c;
        }

        double nextDouble() {
            double ret = 0, div = 1;
            int c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        String nextLine() {
            byte[] strBuf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (strBuf.length == cnt) {
                    strBuf = Arrays.copyOf(strBuf, strBuf.length * 2);
                }
                strBuf[cnt++] = (byte) c;
            }
            return new String(strBuf, 0, cnt);
        }


        String next() {
            byte[] strBuf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (Character.isWhitespace(c)) {
                    if (cnt == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (strBuf.length == cnt) {
                    strBuf = Arrays.copyOf(strBuf, strBuf.length * 2);
                }
                strBuf[cnt++] = (byte) c;
            }
            return new String(strBuf, 0, cnt);
        }

        int nextInt() {
            int ans = 0;
            int c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ans = ans * 10 + c - '0';
            } while ('0' <= (c = read()) && c <= '9');
            bufferPoint--;
            return neg ? -ans : ans;
        }

        long nextLong() {
            long ans = 0;
            int c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ans = ans * 10 + c - '0';
            } while ('0' <= (c = read()) && c <= '9');
            bufferPoint--;
            return neg ? -ans : ans;
        }

        void println(Object o) {
            pw.println(o);
        }

        void print(Object o) {
            pw.print(o);
        }

        void printf(String format, Object... objects) {
            pw.printf(format, objects);
        }

        void close() {
            pw.close();
        }

        void done(Object o) {
            print(o);
            close();
        }

    }
}