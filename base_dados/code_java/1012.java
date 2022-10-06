

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {

    void solve(){
       int n = readInt();
       int q = readInt();
       int max = 0;
       int[] a = new int[n];
       Deque<Integer> deque = new ArrayDeque<>();
       for(int i = 0;i<n;i++){
           a[i] = readInt();
           deque.addLast(a[i]);
           max = Math.max(max, a[i]);
       }
        List<String> ans = new ArrayList<>();
        while(deque.peekFirst() != max){
           int one = deque.pollFirst();
           int two = deque.pollFirst();
           ans.add(one + " " + two);
           deque.addFirst(one > two ? one : two);
           deque.addLast(one > two ? two : one);
           if(one == max) break;
       }

       for(int i = 0;i<n;i++){
           a[i] = deque.pollFirst();
       }

       for(int i = 0;i<q;i++){
          long x = readLong();
           if(x <= ans.size()){
               out.println(ans.get((int)x - 1));
               continue;
           }
           x -= ans.size();
           int y =(int) (x%(n - 1) - 1%(n - 1) + (n - 1)) % (n - 1) + 1;
           out.println(max + " " + a[y]);
       }
    }

    public static void main(String[] args) {
        new C().run();
    }

    void run(){
        init();
        solve();
        out.close();
    }

    BufferedReader in;
    PrintWriter out;

    StringTokenizer tok = new StringTokenizer("");

    void init(){
        in = new BufferedReader(new InputStreamReader(System.in));
        out  = new PrintWriter(System.out);
    }

    String readLine(){
        try{
            return in.readLine();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    String readString(){
        while(!tok.hasMoreTokens()){
            String nextLine = readLine();
            if(nextLine == null) return null;
            tok = new StringTokenizer(nextLine);
        }
        return tok.nextToken();
    }

    int readInt(){
        return Integer.parseInt(readString());
    }

    long readLong(){
        return Long.parseLong(readString());
    }

    double readDouble(){
        return Double.parseDouble(readString());
    }
}
