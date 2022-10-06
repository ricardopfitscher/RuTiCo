import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int z=0;z<t;z++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int min=1;
            int max=1;
            for(int i=0;i<n;i++){
                int k = Integer.parseInt(st.nextToken());
                if(max<k){
                    min = max;
                    max = k;
                }else if(min<k){
                    min = k;
                }
            }
            int res = Math.min(n-2,min-1);
            System.out.println(res);
        }
    }
}

