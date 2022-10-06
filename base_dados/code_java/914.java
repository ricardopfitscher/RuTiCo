import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class pr988B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(br.readLine());
        }

        if(solve(n, a)){
            out.println("YES");
            for (String s : a) {
                out.println(s);
            }
        }
        else
            out.println("NO");

        out.flush();
        out.close();
    }

    private static boolean solve(int n, ArrayList<String> a) {
        a.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < n - 1; i++) {
            if(!a.get(i+1).contains(a.get(i))) return false;
        }
        return true;
    }
}
