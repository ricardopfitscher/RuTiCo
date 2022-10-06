import java.util.*;
import java.io.*;
public class vasyaarray{
public static void main(String[] args)throws IOException {
    FastReader in=new FastReader(System.in);
        int n=in.nextInt();
        long arr1[]=new long[n];
        long pre1[]=new long[n];
        int i,j;
        arr1[0]=in.nextLong();
        pre1[0]=arr1[0];
        for(i=1;i<n;i++)
        {
            arr1[i]=in.nextLong();
            pre1[i]=pre1[i-1]+arr1[i];
        }
        int m=in.nextInt();
        long arr2[]=new long[m];
        long pre2[]=new long[m];
        arr2[0]=in.nextInt();
        pre2[0]=arr2[0];
        for(i=1;i<m;i++)
        {
            arr2[i]=in.nextInt();
            pre2[i]=pre2[i-1]+arr2[i];
        }
        //System.out.println(Arrays.toString(pre1));
         //System.out.println(Arrays.toString(pre2));
        if(pre1[n-1]!=pre2[m-1])
        System.out.println("-1");
        else
        {
            long s1=0,s2=0;
            i=j=0;
            int k=0;
            while(true)
            {
                if(s1==s2)
                {
                    if(s1==0)
                    {
                        s1=arr1[i++];
                        s2=arr2[j++];
                        // System.out.println(s1+" "+s2+" "+i+" "+j);
                    }
                    else
                    {
                        k++;
                        s1=s2=0;
                        //System.out.println(k+" "+i+" "+j);
                        if(i==n && j==m)
                        break;
                    }
                }
                else if(s1>s2)
                {
                    s2+=arr2[j++];
                    //System.out.println("1"+" "+s1+" "+s2+" "+i+" "+j);
                }
                else
                {
                    s1+=arr1[i++];
                    //System.out.println("2 "+s1+" "+s2+" "+i+" "+j);
                }
            }
            System.out.println(k);
        }
    }
}
class FastReader {
 
    byte[] buf = new byte[2048];
    int index, total;
    InputStream in;
 
    FastReader(InputStream is) {
        in = is;
    }
 
    int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }
 
    String next() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan());
        StringBuilder sb = new StringBuilder();
        for (; c > 32; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }
    String nextLine() throws IOException {
        int c;
        for (c = scan(); c <= 32; c = scan());
        StringBuilder sb = new StringBuilder();
        for (; c !=10; c = scan()) {
            sb.append((char) c);
        }
        return sb.toString();
    }
    char nextChar() throws IOException{
        int c;
         for (c = scan(); c <= 32; c = scan());
         return (char)c;
        }
 
    int nextInt() throws IOException {
        int c, val = 0;
        for (c = scan(); c <= 32; c = scan());
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
 
    long nextLong() throws IOException {
        int c;
        long val = 0;
        for (c = scan(); c <= 32; c = scan());
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        for (; c >= '0' && c <= '9'; c = scan()) {
            val = (val << 3) + (val << 1) + (c & 15);
        }
        return neg ? -val : val;
    }
}