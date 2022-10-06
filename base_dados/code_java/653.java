import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cf1003A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[100];
        int max = 0;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(stk.nextToken()) - 1;
           max = max < ++arr[tmp] ? arr[tmp] : max;
        }
        System.out.println(max);
    }
}