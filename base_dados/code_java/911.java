import java.util.*;

import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
 
public class Main {
        
    public static void main(String[] args) throws Exception{
        FastReader sc=new FastReader(); 
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        int n=sc.nextInt();
        int[] font=new int[n];
        int[] cost=new int[n];
        for(int i=0;i<n;i++) {
            font[i]=sc.nextInt();
        
        }
        for(int i=0;i<n;i++) {
            cost[i]=sc.nextInt();
        }
        int[] dou= new int[n];
        for(int i=0;i<n;i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                if(font[j]<font[i]) {
                    if(min>cost[i]+cost[j]) {
                        min=cost[i]+cost[j];
                    }
                }
            }
            dou[i]=min;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                if(dou[j]!=Integer.MAX_VALUE && font[j]<font[i]) {
                    if(min>dou[j]+cost[i]) {
                        min=dou[j]+cost[i];
                    }
                }
            }
            if(min<ans) {
                ans=min;
            }
        }
        if(ans==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }
}

class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 
 
    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 
 
    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 
 
    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 
 
    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 
 
    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 
 
    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 