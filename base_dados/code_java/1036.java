import java.util.*;
import java.math.*;
public class Solution{
    private long [] sums;
    private void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        this.sums = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sums[i] = arr[i] + (i == 0 ? 0 : sums[i - 1]);
        }
        long ans = 0;
        for(int i = 1; i <= n && i <= m; i++){
            ans = Math.max(ans, sum(0, i - 1) - k);
        }
        long [] dp = new long[n];
        for(int i = 0; i < n; i++){
            if(i + 1 >= m){
                long cur = sum(i - m + 1, i) - k;
                if(i - m >= 0){
                    cur += dp[i - m];
                }
                dp[i] = Math.max(dp[i], cur);
            }
            for(int j = 0; j <= m && i + j < n; j++){
                ans = Math.max(ans, dp[i] + sum(i + 1, i + j) - k * (j > 0 ? 1 : 0));
            }
        }
        System.out.println(ans);
    }
    private long sum(int l, int r){
        if(l <= 0){
            return sums[r];
        }else{
            return sums[r] - sums[l - 1];
        }
    }
    public static void main(String [] args){
        new Solution().solve();
    }
}