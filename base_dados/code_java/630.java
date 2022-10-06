import java.util.*;
public class Main {
    public static int n, m;
    public static int[] vert, group;
    public static int[][] horiz;
    public static boolean ok(int a, int b, int g) {
        int start, end;
        if (g == 0) {
            start = 1;
            end = vert.length > 0 ? vert[0] : (int)Math.pow(10, 9);
        } else if (g == group.length - 1) {
            start = vert[g - 1];
            end = (int)Math.pow(10, 9);
        } else {
            start = vert[g - 1];
            end = vert[g];
        }
        return a <= start && b >= end;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        vert = new int[n];
        for (int i = 0; i < n; i++) {
            vert[i] = in.nextInt();
        }
        horiz = new int[m][3];
        for (int i = 0; i < m; i++) {
            horiz[i] = new int[]{in.nextInt(), in.nextInt(), in.nextInt()};
        }
        group = new int[n + 1];
        Arrays.fill(group, 0);
        for (int i = 0; i < m; i++) {
            int a = horiz[i][0];
            int b = horiz[i][1];
            for (int j = 0; j < group.length; j++) {
                if (ok(a, b, j)) {
                    group[j]++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < group.length; i++) {
            min = Math.min(min, group[i] + i);
        }
        System.out.println(min);
    }
}