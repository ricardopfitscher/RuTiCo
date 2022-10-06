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
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<n;i++) {
            map.put(sc.next(), 1);
        }
        ArrayList<String> list=new ArrayList<String>();
        int count=0;
        if(!map.containsKey("purple")) {
            count++;
            list.add("Power");
        }
if(!map.containsKey("green")) {
    count++;
    list.add("Time");
        }

if(!map.containsKey("blue")) {
    count++;
    list.add("Space");
}

if(!map.containsKey("orange")) {
    count++;
    list.add("Soul");
}

if(!map.containsKey("red")) {
    count++;
    list.add("Reality");
}

if(!map.containsKey("yellow")) {
    count++;
    list.add("Mind");
}System.out.println(count);
    for(String s:list) {
        System.out.println(s);
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