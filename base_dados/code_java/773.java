import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int counter = 0;
        for(int i=0; i<2*n/3; i++) System.out.println("0 " + i);
        for(int i=0; i<n-2*n/3; i++) System.out.println("3 " + (2*i+1));

    }
}
