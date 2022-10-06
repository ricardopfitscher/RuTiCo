import java.io.PrintWriter;
import java.util.Scanner;

public class pr902A {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        out.println(solve(n, m));
        out.flush();
        out.close();
    }

    private static String solve(int n, int m) {
        int[] grid = new int[m+1];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            grid[start]++;
            grid[end]--;

        }
        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += grid[i];
            if(sum == 0) return "NO";
        }

        return "YES";
    }
}
