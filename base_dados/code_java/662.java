import java.util.*;

//201920181

public class Polycarp{

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
        int rem[] = new int[3];
		
		Arrays.fill(rem,-1);
		rem[0] = 0;
        char ch[] = s.next().toCharArray();
		int n = ch.length;
 		long dp[] = new long[n];

        int sum = 0;
		
        for(int i=0;i<ch.length;i++){
		   sum = sum + (ch[i]-48);
		   if(rem[sum%3] != -1)
			    if(i>0){
					dp[i] = Math.max(dp[i-1],dp[rem[sum%3]]+1);}
				else
					dp[i] = 1;
	       else
			   if(i>0)
				   dp[i] = dp[i-1];
			   
		   
		   rem[sum%3] = i;
		   sum = sum%3;
		   
		}		
		 

            System.out.println(dp[n-1]);			
		
		
	}
}
