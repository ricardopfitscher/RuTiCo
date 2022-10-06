import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        final long MOD = 1000000007;
        Scanner scan = new Scanner(System.in);
        int now = 1;
        int maxStatements = scan.nextInt();
        long[] dp = new long[maxStatements + 1];
        dp[now] = 1;
        while(maxStatements > 0)
        {
            String add = scan.next();
            if (add.equals("f"))
            {
                now++;
            }
            else
            {
                for (int k = 1; k <= now; k++)
                {
                    dp[k] = ((dp[k] + dp[k-1]) % MOD);
                }
            }
            maxStatements--;
        }
        System.out.println(dp[now]);
     }
}