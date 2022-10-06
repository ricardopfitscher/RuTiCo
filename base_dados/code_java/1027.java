import java.util.*;
import java.io.*;
import java.math.*;
public class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = Integer.parseInt(st.nextToken());
        int ind = 0;
        for(int i=0;i<n;i++){
            if(a[i]==n){
                ind = i;
                break;
            }
        }
        boolean ok = true;
        for(int i=ind+1;i<n;i++) if(a[i]>a[i-1]) ok = false;
        for(int i=ind-1;i>=0;i--) if(a[i]>a[i+1]) ok = false;
        if(ok) System.out.println("YES");
        else System.out.println("NO");
        
    }
}

