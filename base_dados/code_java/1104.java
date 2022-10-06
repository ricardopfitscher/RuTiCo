
import java.io.*;
import java.math.*;
import java.util.*;


// author @mdazmat9
public  class codeforces{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = 1;
        for (int ind = 0; ind < test; ind++) {
          int [] a=new int[3];
          a[0]=sc.nextInt();
          a[1]=sc.nextInt();
          a[2]=sc.nextInt();
          Arrays.sort(a);
          int k1=a[0];
          int k2=a[1];
          int k3=a[2];
          if(k1==1 || k2==1 || k3==1){
              out.println("YES");
          }
          else if((k1==2 && k2==2)||(k2==2 && k3==2)){
              out.println("YES");
            }
            else if(k1==3 && k2==3 && k3==3){
              out.println("YES");
          }
          else if(k1==2 && k2==4 && k3==4){
              out.println("YES");
          }
          else
              out.println("NO");

        }
        out.flush();
    }





    static   void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    static long gcd(long a , long b)
    {
        if(b == 0)
            return a;
        return gcd(b , a % b);
    }

}
class Scanner {
    public BufferedReader reader;
    public StringTokenizer st;

    public Scanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            } catch (Exception e) {
                throw (new RuntimeException());
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}

class OutputWriter {
    BufferedWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    public void print(int i) throws IOException {
        writer.write(i);
    }

    public void print(String s) throws IOException {
        writer.write(s);
    }

    public void print(char[] c) throws IOException {
        writer.write(c);
    }

    public void close() throws IOException {
        writer.close();
    }

}