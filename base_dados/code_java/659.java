import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cf1005A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int numberOfStairs = 0;
        StringBuilder result = new StringBuilder("");
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int previousNum = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(stk.nextToken());
            if (tmp == 1){
                ++numberOfStairs;
                if (previousNum != 0)
                    result.append(previousNum + " ");
            }
            previousNum = tmp;
        }
        result.append(previousNum);
        System.out.println(numberOfStairs);
        System.out.println(result);
    }
}
