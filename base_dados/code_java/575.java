import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        int c[] = new int[2 * n];
        c[0] = a[0];
        for (int i = 1; i < n; i++) {
            c[i * 2] = a[i];
            c[i * 2 - 1] = b[i];
            if (a[i] == 1 || b[i] == 1) {
                System.out.print(-1);
                System.exit(0);
            }
        }
        c[2 * n - 1] = b[0];
        if (a[0] == 1 || b[0] == 1) {
            System.out.print(-1);
            System.exit(0);
        }
        System.out.println(bin_search(c, m));
    }

    private static double bin_search(int[] c, int m) {
        double start = 0;
        double end = Integer.MAX_VALUE;
        double mid;
        while (start + 0.0000001 < end) {
            mid = (start + end) / 2;
            if (test(mid, m, c)) end = mid;
            else start = mid;
        }
        return end;
    }

    private static boolean test(double fuel, int m, int[] c) {
        for (int i = 0; i < c.length; i++) {
            fuel -= (m + fuel) / c[i];
            if (fuel < 0) {
                return false;
            }
        }
        return true;
    }
}
