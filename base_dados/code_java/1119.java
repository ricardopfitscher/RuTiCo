import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder ans1 = new StringBuilder();
        StringBuilder ans2 = new StringBuilder();
        for(int i=0; i<2229; i++) ans1.append('5');
        ans1.append('6');
        for(int i=0; i<2230; i++) ans2.append('4');
        out.println(ans1.toString());
        out.println(ans2.toString());
        out.close(); System.exit(0);
    }
}
