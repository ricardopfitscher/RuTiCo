import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] a = new long[n];
        for(int i=0;i<n;i++) a[i] = Long.parseLong(st.nextToken());
        Queue<Long> ts = new PriorityQueue<Long>();
        for(int i=1;i<n;i++) ts.add(a[i]-a[i-1]);
        long sum = 0;
        for(int i=0;i<n-k;i++){
            sum += ts.poll();
        }
        System.out.println(sum);
    }
}

