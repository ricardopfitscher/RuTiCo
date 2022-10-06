import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author zodiacLeo
 */
public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        FastPrinter out = new FastPrinter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
    
    static class TaskC
    {
        public void solve(int testNumber, FastScanner in, FastPrinter out)
        {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++)
            {
                b[i] = a[i] = in.nextInt();
                if (i > 0)
                {
                    a[i] += a[i - 1];
                }
            }
            for (int i = n - 2; i >= 0; i--)
            {
                b[i] += b[i + 1];
            }
            
            long sum1 = 0;
            long sum3 = 0;
            long result = 0;
            for (int i = 0, j = n - 1; i < j; )
            {
                sum1 = a[i];
                sum3 = b[j];
                if (sum1 == sum3)
                {
                    result = Math.max(result, sum1);
                    i++;
                    j--;
                }
                else if (sum1 < sum3)
                {
                    i++;
                }
                else
                {
                    j--;
                }
            }
            out.println(result);
            
            
        }
        
    }
    
    static class FastScanner
    {
        public BufferedReader br;
        public StringTokenizer st;
        
        public FastScanner(InputStream is)
        {
            br = new BufferedReader(new InputStreamReader(is));
        }
        
        public FastScanner(File f)
        {
            try
            {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        
        public String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                String s = null;
                try
                {
                    s = br.readLine();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                if (s == null)
                {
                    return null;
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }
        
        public int nextInt()
        {
            return Integer.parseInt(next());
        }
        
    }
    
    static class FastPrinter extends PrintWriter
    {
        public FastPrinter(OutputStream out)
        {
            super(out);
        }
        
        public FastPrinter(Writer out)
        {
            super(out);
        }
        
    }
}

