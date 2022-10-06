import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        InputReader.OutputWriter out = new InputReader.OutputWriter(outputStream);


        int n = in.nextInt();
        int s = in.nextInt();
        Lift [] lifts = new Lift[n];
        for (int i = 0; i < n; i++) {
            lifts[i] = new Lift(in.nextInt(),in.nextInt());
        }
        Arrays.sort(lifts,(x,y)->y.getLevel() - x.getLevel());
        
        int ans = 0;
        for (int i = 0; i < lifts.length; i++) {
            Lift current = lifts[i];
            ans+=s-current.getLevel();
            if(current.getTime()>ans) {
                ans+=current.getTime() - ans;
            }
            s = current.getLevel();
        }
        ans+=s;
        out.println(ans);
        out.flush();
    }
}

class Lift {

    int level;
    int time;

    public int getLevel() {
        return level;
    }

    public int getTime() {
        return time;
    }

    public Lift(int level, int time) {
        this.level = level;
        this.time = time;
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
    public Long nextLong() {return  Long.valueOf(next());}

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