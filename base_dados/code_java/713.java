import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cf1017A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;
        int thomasSum = 0;
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(stk.nextToken());
        int second = Integer.parseInt(stk.nextToken());
        int third = Integer.parseInt(stk.nextToken());
        int fourth = Integer.parseInt(stk.nextToken());
        thomasSum = first + second + third + fourth;
        int tmp;
        for (int i = 1; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            first = Integer.parseInt(stk.nextToken());
            second = Integer.parseInt(stk.nextToken());
            third = Integer.parseInt(stk.nextToken());
            fourth = Integer.parseInt(stk.nextToken());
            tmp = first + second + third + fourth;
            if (tmp > thomasSum)
                result++;
        }
        System.out.println(result);
    }
}