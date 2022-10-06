import java.util.*;
public class TestClass
{
   public static void main(String args[])
   {
   	Scanner in = new Scanner(System.in);
   	int n = in.nextInt();
   	int m = in.nextInt();
   	int k = in.nextInt();
   	int arr[] = new int[n+1];
   	for(int i =0;i<n;i++)
   	 arr[i+1]= in.nextInt();
   	
   	long sum[] = new long [n+1];
   	
   	for(int i=1;i<=n;i++)
   	 sum[i]=sum[i-1]+arr[i];
   	
    long dp[] = new long[n+1];

    for(int i =1;i<=n;i++)
    {
      for(int j=i;j>i-m&&j>=1;j--)
      {
        long val = sum[i]-sum[j-1]+dp[j-1]-k;
        dp[i]= Math.max(dp[i],val);
      }	
    }
    long max =0;
    for(int i =1;i<=n;i++)
     max=Math.max(max,dp[i]);
    
    System.out.println(max);
     
   }	
}