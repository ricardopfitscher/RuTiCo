import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lyft {
    private static FastScanner scan = new FastScanner(System.in);
    private static PrintWriter pr = new PrintWriter(System.out);
    private static int n, m, taxistNumber, noTaxistNumber = 0;
    static people peoples[], taxist[], noTaxist[];
    public static void main(String[] args) throws IOException {
        n = scan.nextInt();
        m = scan.nextInt();
        peoples = new people[n + m];
        noTaxist = new people[n];
        taxist = new people[m];
        for(int i = 0; i < peoples.length; i++){
            peoples[i] = new people(scan.nextInt());
        }
        for (people i : peoples){
            if(scan.nextInt() == 1){
                i.taxi = true;
                i.passangers = 0;
                taxist[taxistNumber] = i;
                taxistNumber++;
            }else{
                noTaxist[noTaxistNumber] = i;
                noTaxistNumber++;
            }
        }
        for (people i : noTaxist){
                for (people ii: taxist){
                    if(ii.taxi){
                       if(i.nearestTaxist == null){
                           i.nearestTaxist = ii;
                           ii.passangers++;
                       }else if(i.coord - i.nearestTaxist.coord > ii.coord - i.coord){
                           i.nearestTaxist.passangers--;
                           i.nearestTaxist = ii;
                           i.nearestTaxist.passangers++;
                       }
                    }
                }
        }
        for (people i : taxist){
                pr.print(i.passangers + " ");
        }
        pr.close();
    }
}
class FastScanner
{
    private static final int bufferSize = 64 * 1024;
    private final BufferedReader reader;
    private StringTokenizer tokenizer;

    FastScanner(InputStream inputStream)
    {
        this.reader = new BufferedReader(new InputStreamReader(inputStream), bufferSize);
    }

    String nextToken() throws IOException
    {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
        {
            String line = reader.readLine();
            if (line == null)
            {
                tokenizer = null;
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int[] readIntArray(int n) throws IOException
    {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = nextInt();
        }
        return a;
    }

    long[] readLongArray(int n) throws IOException
    {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = nextLong();
        }
        return a;
    }

    int nextInt() throws NumberFormatException, IOException
    {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws NumberFormatException, IOException
    {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws NumberFormatException, IOException
    {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException
    {
        tokenizer = null;
        return reader.readLine();
    }
}
class people{
    int coord = 0;
    boolean taxi = false;
    people nearestTaxist = null;
    int passangers = -1;
    people(int coord){
        this.coord = coord;
    }
}
