import java.util.*;
import java.io.*;

public class MinimumDiameterTree{
    public static void main(String[] args) {
	InputReader in = new InputReader (System.in);
	PrintWriter out = new PrintWriter (System.out);

	int n = in.nextInt();
	int s = in.nextInt();
	int deg[] = new int [n];
	
	for (int i = 1; i < n; ++i) {
	    deg[in.nextInt() - 1] ++;
	    deg[in.nextInt() - 1] ++;
	}

	int l = 0;
	for (int i = 0; i < n; ++i)
	    if (deg[i] == 1) l ++;

	out.println((double) 2 * s / l);
	out.close();
    }

    public static class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
	    reader = new BufferedReader(new InputStreamReader(stream), 32768);
	    tokenizer = null;
	}

	public String next() {
	    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
		try {
		    tokenizer = new StringTokenizer(reader.readLine());
		} catch(IOException e) {
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
    }
}
