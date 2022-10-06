import java.util.*;
import java.lang.*;
import java.io.*;
public class TestClass {
    // function for finding size of set
    public static int set_size(int[] a, int N){
        HashSet <Integer> newset = new HashSet <Integer>();
        int i=0;
        while(i<N){
            newset.add(a[i++]);
        }
        int v = newset.size();
        return v;
    }
    public static void main(String args[] ) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int x = Integer.parseInt(tk.nextToken());
            
            int[] a = new int[N];
            int[] b = new int[N];
            StringTokenizer tb = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                a[i] = Integer.parseInt(tb.nextToken());
            }
            if(set_size(a, N) < N){
                System.out.print("0");
                System.exit(0);
            }
            int num=0;
        while(num++<4){
            for(int i=0; i<N; i++){
                if((a[i]&x) == a[i])
                    continue;
                else{
                    for(int j=0; j<N; j++){
                        if(i==j){
                            b[i] = (a[i]&x);
                        }
                        else{
                            b[j] = a[j];
                        }
                    }
                    int s = set_size(b, N);
                    if(s<N){
                        System.out.print(num);
                        System.exit(0);
                    }
                }
            }
            for(int i=0; i<N; i++)
                a[i] = b[i];
        }
        System.out.print("-1");
        System.exit(0);
    }
}