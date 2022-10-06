
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
744444444747477777774
44444447474747777777
 */

/**
 *
 * @author Andy Phan
 */
public class b {
    public static void main(String[] args) {
        FS in = new FS(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        int numZ = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            if(arr[i] == 0) numZ++;
        }
        
        Arrays.sort(arr);
        
        
        if(numZ > 1) {
            System.out.println("cslnb");
            return;
        }
        int numDup = 0;
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr2[i] = arr[i];
            if(i != 0) {
                if(arr2[i] == arr2[i-1]) {
                    arr2[i-1]--;
                    numDup++;
                }
            }
        }
        
        if(numDup > 1) {
            System.out.println("cslnb");
            return;
        }
        
        
        for(int i = 0; i < n; i++) {
            if(i != 0) {
                if(arr2[i] == arr2[i-1]) {
                    System.out.println("cslnb");
                    return;
                }
            }
        }
        long num = 0;
        if(numDup == 1) num++;
        for(int i = 0; i < n; i++) {
            num += arr2[i]-i;
        }
        
        if(num%2 == 0) {
            System.out.println("cslnb");
        } else {
            System.out.println("sjfnb");
        }
        

        out.close();
    }
    
    static class FS {

        BufferedReader in;
        StringTokenizer token;
        
        public FS(InputStream str) {
            in = new BufferedReader(new InputStreamReader(str));
        }
        
        public String next() {
            if (token == null || !token.hasMoreElements()) {
                try {
                    token = new StringTokenizer(in.readLine());
                } catch (IOException ex) {
                }
                return next();
            }
            return token.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
