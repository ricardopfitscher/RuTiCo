import javax.print.DocFlavor;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.nio.Buffer;
import java.nio.charset.IllegalCharsetNameException;
import java.sql.BatchUpdateException;
import java.util.*;
import java.util.stream.Stream;
import java.util.Vector;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.Math.*;
import java.util.*;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.PriorityQueue;

public class icpc
{
    public static void main(String[] args)throws IOException
    {
//        Reader in = new Reader();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s1[] = in.readLine().split(" ");
        int  n = Integer.parseInt(s1[0]);
        int p = Integer.parseInt(s1[1]);
        String s = in.readLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        boolean flag = false;
        for(int i=0;i<n;i++)
        {
            if(i + p < n)
            {
                if(s.charAt(i) != '.' && s.charAt(i + p) != '.' && s.charAt(i) != s.charAt(i + p))
                {
                    flag = true;
                    break;
                }
                else if(s.charAt(i) == '.' && s.charAt(i + p) != '.')
                {
                    int x = s.charAt(i + p) - '0';
                    char ch = (char)((x + 1) % 2 + 48);
                    stringBuilder.setCharAt(i, ch);
                    flag = true;
                    break;
                }
                else if(s.charAt(i) != '.' && s.charAt(i + p) == '.')
                {
                    int x = s.charAt(i) - '0';
                    char ch = (char)((x + 1) % 2 + 48);
                    stringBuilder.setCharAt(i + p, ch);
                    flag = true;
                    break;
                }
                else if(s.charAt(i) == '.' && s.charAt(i + p) == '.')
                {
                    stringBuilder.setCharAt(i, '1');
                    stringBuilder.setCharAt(i + p, '0');
                    flag = true;
                    break;
                }
            }
        }
        if(flag)
        {
            for(int i=0;i<stringBuilder.length();i++)
            {
                if(stringBuilder.charAt(i) == '.')
                {
                    stringBuilder.setCharAt(i, '0');
                }
            }
            System.out.println(stringBuilder);
        }
        else
            System.out.println("No");


    }
}
class StringAlgorithms
{
    public int[] calculateZ(char input[]) {
        int Z[] = new int[input.length];
        int left = 0;
        int right = 0;
        for(int k = 1; k < input.length; k++) {
            if(k > right) {
                left = right = k;
                while(right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                Z[k] = right - left;
                right--;
            } else {
                //we are operating inside box
                int k1 = k - left;
                //if value does not stretches till right bound then just copy it.
                if(Z[k1] < right - k + 1) {
                    Z[k] = Z[k1];
                } else { //otherwise try to see if there are more matches.
                    left = k;
                    while(right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }
    public ArrayList<Integer> matchPattern(char text[], char pattern[]) {
        char newString[] = new char[text.length + pattern.length + 1];
        int i = 0;
        for(char ch : pattern) {
            newString[i] = ch;
            i++;
        }
        newString[i] = '$';
        i++;
        for(char ch : text) {
            newString[i] = ch;
            i++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int Z[] = calculateZ(newString);

        for(i = 0; i < Z.length ; i++) {
            if(Z[i] == pattern.length) {
                result.add(i - pattern.length - 1);
            }
        }
        return result;
    }
}
class BasicFunctions
{
    public long min(long[] A)
    {
        long min = Long.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            min = Math.min(min, A[i]);
        }
        return min;
    }
    public long max(long[] A)
    {
        long max = Long.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            max = Math.max(max, A[i]);
        }
        return max;
    }
}
class Name implements Comparable<Name>
{
    int x;
    int y;

    public Name(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Name ob)
    {
        if(this.x < ob.x)
            return -1;
        else if(this.x > ob.x)
            return 1;
        return 0;
    }
}
class Matrix
{
    long a;
    long b;
    long c;
    long d;

    public Matrix(long a, long b, long c, long d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
class Game implements Comparable<Game>
{
    long x;
    long y;

    public Game(long x, long y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Game ob)
    {
        if(this.x < ob.x)
            return -1;
        else if(this.x > ob.x)
            return 1;
        else
        {
            if(this.y < ob.y)
                return -1;
            else if(this.y > ob.y)
                return 1;
            else
                return 0;
        }
    }
}
class MergeSortInt
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}
class MergeSortLong
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(long arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        long L[] = new long[n1];
        long R[] = new long[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(long arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
class Node
{
    String a;
    String b;
    Node(String s1,String s2)
    {
        this.a = s1;
        this.b = s2;
    }
    @Override
    public boolean equals(Object ob)
    {
        if(ob == null)
            return false;
        if(!(ob instanceof Node))
            return false;
        if(ob == this)
            return true;
        Node obj = (Node)ob;
        if(this.a.equals(obj.a) && this.b.equals(obj.b))
            return true;
        return false;
    }

    @Override
    public int hashCode()
    {
        return (int)this.a.length();
    }
}
class Reader
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
        }  while ((c = read()) >= '0' && c <= '9');

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
class FenwickTree
{
    public void update(long[] fenwickTree,long delta,int index)
    {
        index += 1;
        while(index < fenwickTree.length)
        {
            fenwickTree[index] += delta;
            index = index + (index & (-index));
        }
    }
    public long prefixSum(long[] fenwickTree,int index)
    {
        long sum = 0L;
        index += 1;
        while(index > 0)
        {
            sum += fenwickTree[index];
            index -= (index & (-index));
        }
        return sum;
    }
}
class SegmentTree
{
    public int nextPowerOfTwo(int num)
    {
        if(num == 0)
            return 1;
        if(num > 0 && (num & (num - 1)) == 0)
            return num;
        while((num &(num - 1)) > 0)
        {
            num = num & (num - 1);
        }
        return num << 1;
    }
    public int[] createSegmentTree(int[] input)
    {
        int np2 = nextPowerOfTwo(input.length);
        int[] segmentTree = new int[np2 * 2 - 1];

        for(int i=0;i<segmentTree.length;i++)
            segmentTree[i] = Integer.MIN_VALUE;

        constructSegmentTree(segmentTree,input,0,input.length-1,0);
        return segmentTree;

    }
    private void constructSegmentTree(int[] segmentTree,int[] input,int low,int high,int pos)
    {
        if(low == high)
        {
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high)/ 2;
        constructSegmentTree(segmentTree,input,low,mid,2*pos + 1);
        constructSegmentTree(segmentTree,input,mid+1,high,2*pos + 2);
        segmentTree[pos] = Math.max(segmentTree[2*pos + 1],segmentTree[2*pos + 2]);
    }
    public int rangeMinimumQuery(int []segmentTree,int qlow,int qhigh,int len)
    {
        return rangeMinimumQuery(segmentTree,0,len-1,qlow,qhigh,0);
    }
    private int rangeMinimumQuery(int segmentTree[],int low,int high,int qlow,int qhigh,int pos)
    {
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return Integer.MIN_VALUE;
        }
        int mid = (low+high)/2;
        return Math.max(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
    }
}