//https://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
//O(log n)
// Java program for the above approach
import java.io.*;
import java.util.*;

class GFG
{

// function calculating power
static int pow(int a, int n){
	int ans = 1;
	while(n > 0)
	{
		
		// calculate last bit(right most) bit of n
		int last_bit = n&1;
			
		//if last bit is 1 then multiply ans and a
		if(last_bit != 0){
			ans = ans*a;
		}
		
	//make a equal to square of a as on every succeeding bit it got squared like a^0, a^1, a^2, a^4, a^8
	a = a*a;
	n = n >> 1;
	}
	return ans;
}

// Driver Code
public static void main(String[] args)
{
	System.out.print(pow(3,5));
}
}

// This code is contributed by code_hunt.
