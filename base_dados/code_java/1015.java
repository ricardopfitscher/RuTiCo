

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    int[][] fast(int n, int m){

        int[][] ans = new int[2][n * m];
        int c = 0;

        for (int left = 1, right = m; left < right; left++, right--) {
            for (int l = 1, r = n; l <= n && r >= 1; l++, r--) {
                ans[0][c] = l;
                ans[1][c++] = left;

                ans[0][c] = r;
                ans[1][c++] = right;
            }
        }

        if (m % 2 == 1) {
            int x = m/2 + 1;
            for(int l = 1, r = n;l < r;l++, r--){
                ans[0][c] = l;
                ans[1][c++] = x;

                ans[0][c] = r;
                ans[1][c++] = x;
                    if(n % 2 == 1 && l + 2 == r){
                        ans[0][c] = l+1;
                        ans[1][c++] = x;
                    }
            }
        }

        if(n == 1 && m % 2 == 1){
            ans[0][c] = 1;
            ans[1][c] = m/2 + 1;
        }

        return ans;
    }

    void stress(){

        for(int i = 3;i<=5;i++){
            for(int j = 2;j<=5;j++){
                int[][] ans = new int[2][];
                try{
                    ans = fast(i, j);
                }catch(Exception e){
                    out.println("ошибка");
                    out.print(i + " " + j);
                    return;
                }

                boolean[][] check = new boolean[i][j];
                for(int c = 0;c<ans[0].length;c++){
                    int x = ans[0][c] - 1;
                    int y = ans[1][c] - 1;
                    check[x][y] = true;
                }

                for(int c = 0;c<i;c++){
                    for(int q = 0;q<j;q++){
                        if(!check[c][q]){
                            out.println(i + " " + j);
                            out.println("точки");
                            for(int w = 0;w<ans[0].length;w++){
                                out.println(ans[0][w] + " " + ans[1][w]);
                            }
                            return;
                        }
                    }
                }

                HashSet<String> set = new HashSet<>();
                for(int c = 1;c<ans[0].length;c++){
                    int x = ans[0][c] - ans[0][c- 1];
                    int y = ans[1][c] - ans[1][c - 1];
                    set.add(x + " " + y);
                }

                if(set.size() < i * j - 1){
                    out.println(i + " " + j);
                    out.println("вектора");
                    for(int w = 0;w<ans[0].length;w++){
                        out.println(ans[0][w] + " " + ans[1][w]);
                    }
                    return;
                }
            }
        }
    }

    void normal(){
        int n =readInt();
        int m = readInt();
        int[][] ans = fast(n, m);
        for(int i = 0;i<ans[0].length;i++){
            out.println(ans[0][i] + " " + ans[1][i]);
        }
    }

    boolean stress = false;
    void solve(){
        if(stress) stress();
        else normal();
    }

    public static void main(String[] args) {
        new D().run();
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
