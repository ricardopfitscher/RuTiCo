
import java.io.*;
import java.util.StringTokenizer;

/**
 * CodeForces Round 5D. Follow Traffic Rules
 * Created by Darren on 14-9-14.
 */
public class Main {
    Reader in = new Reader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    int a, v;
    int l, d, w;

    void run() throws IOException {
        a = in.nextInt();
        v = in.nextInt();
        l = in.nextInt();
        d = in.nextInt();
        w = in.nextInt();

        double totalTime = 0.0;
        if (v >= w) {
            if (w*w >= 2*a*d) {
                double x = Math.sqrt(2*a*d);
                totalTime = x / a;
                if ((v*v-x*x) >= 2*a*(l-d))
                    totalTime += (-2*x+Math.sqrt(4*x*x+8*a*(l-d))) / (2*a);
                else
                    totalTime += (v-x)/(1.0*a) + (l-d-(v*v-x*x)/(2.0*a))/v;
            } else {
//                totalTime = (-2*w+Math.sqrt(4*w*w+8*a*(l-d))) / (2*a);
                if (2*v*v-w*w <= 2*a*d) {
                    totalTime = v / (1.0*a) + (v-w) / (1.0*a) + (d-(2*v*v-w*w)/(2.0*a)) / v;
                } else {
                    double x = Math.sqrt((2*a*d+w*w)/2.0);
                    totalTime = x / a + (x-w) / a;
                }
                if ((v*v-w*w) >= 2*a*(l-d))
                    totalTime += (-2*w+Math.sqrt(4*w*w+8*a*(l-d))) / (2*a);
                else
                    totalTime += (v-w)/(1.0*a) + (l-d-(v*v-w*w)/(2.0*a))/v;
            }
        } else {
            if (v*v >= 2*a*l)
                totalTime = Math.sqrt(l*2.0/a);
            else
                totalTime = v / (1.0*a) + (l-v*v/(2.0*a)) / v;
        }

        out.printf("%.10f", totalTime);
        out.flush();
    }

    void solve() throws IOException {

    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        String nextToken() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer( reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        String readLine() throws IOException {
            return reader.readLine();
        }

        char nextChar() throws IOException {
            return (char)reader.read();
        }

        int nextInt() throws IOException {
            return Integer.parseInt( nextToken() );
        }

        long nextLong() throws IOException {
            return Long.parseLong( nextToken() );
        }

        double nextDouble() throws IOException {
            return Double.parseDouble( nextToken() );
        }
    }
}
