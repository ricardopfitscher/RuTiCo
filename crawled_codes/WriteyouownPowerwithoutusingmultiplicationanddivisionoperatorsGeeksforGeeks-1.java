//https://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
//O(a * b)
import java.io.*;

class GFG {
	
	/* Works only if a >= 0 and b >= 0 */
	static int pow(int a, int b)
	{
		if (b == 0)
			return 1;
			
		int answer = a;
		int increment = a;
		int i, j;
		
		for (i = 1; i < b; i++) {
			for (j = 1; j < a; j++) {
				answer += increment;
			}
			increment = answer;
		}
		
		return answer;
	}

	// driver program to test above function
	public static void main(String[] args)
	{
		System.out.println(pow(5, 3));
	}
}

// This code is contributed by vt_m.
