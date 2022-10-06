import java.io.*;


public class First {
    StreamTokenizer in;
    PrintWriter out;

    int nextInt() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }

    long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }



    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    void solve() throws IOException {
        int n = nextInt(), k = nextInt(), sum = 0, count = 0;
        String str = nextString();
        char[] arr = str.toCharArray();
        boolean[] bool = new boolean[26];
        for(char ch: arr){
            bool[((int)ch)-97] = true;
        }
        for(int i = 0; i < 26; i++){
            if(bool[i]){
                sum += i+1;
                count++;
                i += 1;
            }
            if(count == k) break;
        }
        if(count == k) out.println(sum);
        else out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        new First().run();
    }
}