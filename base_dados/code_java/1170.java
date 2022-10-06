/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in=new Scanner(System.in);
		long x=in.nextLong();
		long k=in.nextLong();
		
		long mod=1000000007;
		long get=power(2,k,mod);
		long ans=((get%mod)*((2*x)%mod))%mod-get+1;
		if(ans<0)
		ans+=mod;
		if(x==0)
		ans=0;
		System.out.println(ans);
		
	}
	static long power(long x, long y, long p)
    {
        // Initialize result
        long res = 1;     
        
        // Update x if it is more  
        // than or equal to p
        x = x % p; 
     
        while (y > 0)
        {
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res * x) % p;
     
            // y must be even now
            // y = y / 2
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }
}
