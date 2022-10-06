import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int tc = in.nextInt();
        for(int i = 0; i < tc; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int k = in.nextInt();
            int[] s = getArray(in.nextToken());
            int[] a = getArray(in.nextToken());
            int[] b = getArray(in.nextToken());

            int[] per = new int[k];
            boolean[] used = new boolean[k];
            Arrays.fill(per , -1);

            if(!check(s , a, per.clone(), k, used)){
                out.println("NO");
                return;
            }

            for(int i = 0; i < s.length; i++){
                if(per[s[i]] != -1){
                    continue;
                }
                for(int j = 0; j < k; j++){
                    if(used[j]){
                        continue;
                    }
                    per[s[i]] = j;
                    used[j] = true;
                    if(check(s , a , per.clone() , k, used)){
                        break;
                    }
                    per[s[i]] = -1;
                    used[j] = false;
                }
            }

            for(int i = 0; i < s.length; i++){
                if(per[s[i]] == -1){
                    out.println("NO");
                    return;
                }
                s[i] = per[s[i]];
            }

            if(cmp(s , b) > 0){
                out.println("NO");
                return;
            }


            int last = 0;
            for(int i = 0; i < k; i++){
                if(per[i] == -1) {
                    while(used[last])last++;
                    per[i] = last;
                    used[last] = true;
                }
            }

            char[] result = new char[k];

            for(int i = 0; i < k; i++){
                result[i] = (char)('a' + per[i]);
            }
            out.println("YES");
            out.println(new String(result));
        }

        private int cmp(int[] a, int[] b){
            for(int i = 0; i < a.length; i++){
                if(a[i] != b[i]){
                    return a[i] < b[i] ? -1 : 1;
                }
            }
            return 0;
        }


        private boolean check(int[] s, int[] a, int[] per, int k, boolean[] used) {
            int res[] = new int[s.length];
            int last = k - 1;
            for(int i = 0; i < res.length; ++i){

                if(per[s[i]] == -1){

                    while(last >= 0 && used[last]){
                        last--;
                    }

                    if(last < 0){
                        return false;
                    }

                    per[s[i]] = last;
                    last--;
                }
                res[i] = per[s[i]];
            }
            return cmp(a , res) <= 0;
        }

        private int[] getArray(String nextToken) {
            int result[] = new int[nextToken.length()];
            for(int i = 0; i < nextToken.length(); i++){
                result[i] = nextToken.charAt(i) - 'a';
            }
            return result;
        }
    }

    static class InputReader {

        BufferedReader in;
        StringTokenizer tok;

        public InputReader(InputStream stream){
            in = new BufferedReader(new InputStreamReader(stream), 32768);
            tok = null;
        }

        String nextToken()
        {
            String line = "";
            while(tok == null || !tok.hasMoreTokens()) {
                try {
                    if((line = in.readLine()) != null)
                        tok = new StringTokenizer(line);
                    else
                        return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return tok.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(nextToken());
        }
        long nextLong()	{
            return Long.parseLong(nextToken());
        }
        double nextDouble()	{
            return Double.parseDouble(nextToken());
        }

    }

}