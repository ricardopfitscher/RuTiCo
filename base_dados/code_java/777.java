import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class pr1073B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        solve(n, a, b, out);
        out.flush();
        out.close();
    }

    private static void solve(int n, int[] a, int[] b, PrintWriter out) {
        boolean[] book = new boolean[n+1];
        boolean f;
        int j1 = 0, j2 = 0;
        for (int i = 0; i < n; i++) {
            f = false;
            int num = b[i];
            if(!book[num]) {
                f = true;
                j1 = j2;
                for (;j2 < n; j2++) {
                    book[a[j2]] = true;
                    if (a[j2] == num) {
                        j2++;
                        break;
                    }
                }
            }
            out.print(f ? j2-j1 + " ": 0 + " ");
        }
    }
}
