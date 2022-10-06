import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arrB = new long[n];
        long[] arrG = new long[m];
        st=new StringTokenizer(f.readLine());
        for(int i=0;i<n;i++){
            arrB[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(f.readLine());
        for(int j=0;j<m;j++){
            arrG[j]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arrB);
        Arrays.sort(arrG);
        long ans = 0;
//        for (int i = 0; i < n; i++) ans += arrB[i] * m;
//        for (int i = 0; i < m - 1; i++) ans += arrG[i] - arrB[0];
//        if (arrB[m - 1] != arrB[0]) {
//            if (arrB.length == 1) {
//                ans=-1;
//            }
//            else ans += arrG[m - 1] - arrB[1];
//        }
//        if (arrG[m-1] < arrB[0]) {
//            ans=-1;
//        }
        for(int i=0;i<n;i++){
            ans+=arrB[i]*(long)m;
        }
        for(int i=1;i<m;i++){
            ans+=arrG[i]-arrB[n-1];
        }
        if(arrB[n-1]!=arrG[0]){
            if(n==1){
                ans=-1;
            }
            else{
                //smallest g goes to second to last
                ans+=arrG[0]-arrB[n-2];
            }
        }
        if(arrB[n-1]>arrG[0]){
            ans=-1;
        }
        System.out.println(ans);
        f.close();
        out.close();
    }
}