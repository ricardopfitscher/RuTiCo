import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class And {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        OutputStream ob = System.out;
        PrintWriter out = new PrintWriter(ob);
        int n = input.nextInt();
        int x = input.nextInt();
        int[] arr = new int[n];
        int[] count = new int[2000000];
        int[] count2 = new int[2000000];
        int[] arr2 = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
            count[arr[i]]++;
            if(count[arr[i]] > 1){
                out.print(0);
                out.flush();
                return;
            }
            int val = arr[i] & x;
            arr2[i] = val;
            count2[val]++;
        }

        for(int i = 0;i < n;i++){
            if(i == 0){
                int[] temparr = Arrays.copyOfRange(arr,1,n);
                Arrays.sort(temparr);
                int a = Arrays.binarySearch(temparr,arr2[i]);
                if(a >= 0){
                    out.print(1);
                    out.flush();
                    return;
                }
            }
            else if(i == n-1){
                int[] temparr2 = Arrays.copyOfRange(arr,0,n-1);
                Arrays.sort(temparr2);
                int b = Arrays.binarySearch(temparr2,arr2[i]);
                //  System.out.println("b = " + b + " arr2[i] = " + arr2[i]);
                if(b >= 0){
                    out.print(1);
                    out.flush();
                    return;
                }
            }
            else{
                int[] temparr3 = Arrays.copyOfRange(arr,0,i);
                Arrays.sort(temparr3);
                int[] temparr4 = Arrays.copyOfRange(arr,i+1,n);
                Arrays.sort(temparr4);
                int c = Arrays.binarySearch(temparr3,arr2[i]);
                int d = Arrays.binarySearch(temparr4,arr2[i]);
                if(c >= 0 || d >= 0){
                    out.print(1);
                    out.flush();
                    return;
                }
            }
        }
        for(int i : count2){
            if(i > 1){
                out.print(2);
                out.flush();
                return;
            }
        }
        out.print(-1);
        out.flush();
    }
    static class FastReader
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
}