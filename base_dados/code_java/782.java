import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

	static class Task {
		
		int NN = 500005;
		int MOD = 1000000007;
		int INF = 2000000000;
		long INFINITY = 2000000000000000000L;
		
		public void solve(InputReader in, PrintWriter out) {
			int t = in.nextInt();
			while(t-->0) {
				long n =in.nextLong();
				long m = in.nextLong();
				long x1 = in.nextLong();
				long y1 = in.nextLong();
				long x2 = in.nextLong();
				long y2 = in.nextLong();
				long x3 = in.nextLong();
				long y3 = in.nextLong();
				long x4 = in.nextLong();
				long y4 = in.nextLong();
				long w = white(1, 1, m, n);
				long b = black(1, 1, m, n);
				long whited = 0;
				if(x3 > x2 || x4 < x1 || y3 > y2 || y4 < y1) {
					whited = black(x1, y1, x2, y2);
				} else {
					whited = black(x1, y1, x2, y2);
					long xm1 = Math.max(x1, x3);
					long ym1 = Math.max(y1, y3);
					long xm2 = Math.min(x2, x4);
					long ym2 = Math.min(y2, y4);
					whited -= black(xm1, ym1, xm2, ym2);
				}
				b -= whited;w += whited;
				long blacked = white(x3, y3, x4, y4);
				w-= blacked;b += blacked;
				out.println(w + " " + b);
			}
		}
		
		long black(long x1, long y1, long x2, long y2) {
			long dx = (x2 - x1) + 1;
			long dy = (y2 - y1) + 1;
			if((x1+y1)%2!=0) {
				return ((dy+1)/2)*((dx+1)/2)+(dy/2)*(dx/2);
			}
			return ((dy+1)/2)*((dx)/2)+(dy/2)*((dx+1)/2);
		}
		
		long white(long x1, long y1, long x2, long y2) {
			long dx = (x2 - x1) + 1;
			long dy = (y2 - y1) + 1;
			if((x1+y1)%2==0) {
				return ((dy+1)/2)*((dx+1)/2)+(dy/2)*(dx/2);
			}
			return ((dy+1)/2)*(dx/2)+(dy/2)*((dx+1)/2);
		}
		
	}
	
	static void prepareIO(boolean isFileIO) {
		//long t1 = System.currentTimeMillis();
		Task solver = new Task();
		// Standard IO
		if(!isFileIO) { 
			InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        solver.solve(in, out);
	        //out.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        out.close();
		}
        // File IO
		else {
			String IPfilePath = System.getProperty("user.home") + "/Downloads/ip.in";
	        String OPfilePath = System.getProperty("user.home") + "/Downloads/op.out";
	        InputReader fin = new InputReader(IPfilePath);
	        PrintWriter fout = null;
	        try {
				fout = new PrintWriter(new File(OPfilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	        solver.solve(fin, fout);
	        //fout.println("time(s): " + (1.0*(System.currentTimeMillis()-t1))/1000.0);
	        fout.close();
		}
	}
	
	public static void main(String[] args) {
        prepareIO(false);
	}
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        
        public InputReader(String filePath) {
        	File file = new File(filePath);
            try {
				reader = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            tokenizer = null;
        }
        
        public String nextLine() {
        	String str = "";
        	try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return str;
        }
        
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
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

}