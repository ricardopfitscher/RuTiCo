//https://www.geeksforgeeks.org/rotate-bits-of-an-integer/
//O(1)
/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int N=28;
		int D=2;
		rotate(N,D);
	}

static void rotate(int N, int D)
	{
		// your code here
		int t=16;
		int left= ((N<<D) | N>>(t-D)) & 0xFFFF;
		int right=((N>>D) | N<<(t-D)) & 0xFFFF;
		System.out.println(left);
		System.out.println(right);
	}

}
