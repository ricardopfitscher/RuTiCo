import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.*;

import static java.lang.System.gc;
import static java.lang.System.out;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().solve();
    }


    void solve() {

        int n = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();


        int ans = 0;
        boolean a[] = new boolean[30];
        boolean b[] = new boolean[30];

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans ++;
                a[s1.charAt(i)  - 'a'] = true;
                b[s2.charAt(i)  - 'a'] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i) && a[s2.charAt(i) - 'a'] && b[s1.charAt(i) - 'a']) {
                for (int j = i + 1; j < n; j ++) {
                    if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {
                        out.println(ans - 2);
                        out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i) && (a[s2.charAt(i) - 'a'] || b[s1.charAt(i) - 'a'])) {
                for (int j = i + 1; j < n; j ++) {
                    if (s1.charAt(j) != s2.charAt(j) && (s1.charAt(i) == s2.charAt(j) || s1.charAt(j) == s2.charAt(i))) {
                        out.println(ans - 1);
                        out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

        out.println(ans);
        out.println(-1 + " " + -1);
    }
}