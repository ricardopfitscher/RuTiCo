import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        OutputStream output = System.out;
        PrintWriter out = new PrintWriter(output);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int m = scan.nextInt();
        String[] arr = new String[n];
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++){
            arr[i]  = scan.next();
            map.put(arr[i],i+1);
        }
        int[] cost = new int[n];
        for (int i=0;i<n;i++){
            cost[i] = scan.nextInt();
        }
        Dsu set = new Dsu(n+1);
        for (int i=0;i<k;i++){
            int N = scan.nextInt();
            int[] arr1 = new int[N];
            for (int j=0;j<N;j++){
                int M = scan.nextInt();
                arr1[j] = M;
            }
            for (int j=1;j<N;j++){
                set.Union(arr1[j-1],arr1[j],cost);
            }
        }
        // System.out.println(Arrays.toString(set.arr));
        long ans = 0;
        for (int i=0;i<m;i++){
            String S = scan.next();
            int I = map.get(S);
            int A = set.find(I);
            ans += cost[A-1];
        }
        out.println(ans);
        out.close();
    }
}

class Dsu{
    int[] arr;
    Dsu(int N){
        arr = new int[N+1];
        for (int i=0;i<=N;i++){
            arr[i] = i;
        }
    }
    public int find(int A){
        while(arr[A]!=A){
            A = arr[A];
        }
        return A;
    }
    public void Union(int A,int B,int[] Arr){
        int a = find(A);
        int b =find(B);
        if (Arr[a-1]<Arr[b-1]){
            arr[b] = a;
        }
        else{
            arr[a] = b;
        }
    }
}