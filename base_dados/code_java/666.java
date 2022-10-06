import java.io.*;
import java.util.*;

public class Solution {
    static class Data{
        int x,i;
        Data(int x,int i){
            this.x = x;
            this.i = i;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        s = br.readLine().split("\\s");
        int[] arr = new int[N];
        for(int i=0;i<N;++i) arr[i] = Integer.parseInt(s[i]);
        solve(N,K,arr);   
    }
    
    private static void solve(int N,int K,int[] arr){
       PriorityQueue<Data> pq = new PriorityQueue<Data>(2000,(a,b) -> a.x - b.x == 0 ? b.i - a.i : b.x - a.x);
       for(int i=0;i<arr.length;++i){
           pq.offer(new Data(arr[i],i));
       }
       
       int tot_sum = 0;
       List<Integer> ls = new ArrayList<>();
       Set<Integer> set = new HashSet<>();
       
       for(int i=1;i<=K;++i){
           Data t = pq.poll();
           tot_sum += t.x;
           set.add(t.i);
       }
       int last = -1;
       for(int i =0;i<arr.length;++i){
           if(set.contains(i)){
               K--;
               //System.out.println(i);
               if(K == 0) ls.add(arr.length-last-1);
               else ls.add(i-last);
               last = i;
           }
       }
       
       System.out.println(tot_sum);
       int size = ls.size();
       for(int i=0;i<size;++i){
           System.out.print(ls.get(i) + " ");
       }
    }
}