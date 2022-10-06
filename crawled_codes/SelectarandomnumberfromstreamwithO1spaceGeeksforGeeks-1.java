//https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
//O(1)
//An efficient Java program to randomly select a number from stream of numbers.

import java.util.Random;

public class GFG
{
	static int res = 0; // The resultant random number
	static int count = 0; //Count of numbers visited so far in stream
	
	//A method to randomly select a item from stream[0], stream[1], .. stream[i-1]
	static int selectRandom(int x)
	{
		count++; // increment count of numbers seen so far
		
		// If this is the first element from stream, return it
		if (count == 1)
			res = x;
		else
		{
			// Generate a random number from 0 to count - 1
			Random r = new Random();
			int i = r.nextInt(count);
			
			// Replace the prev random number with new number with 1/count probability
			if(i == count - 1)
				res = x;
		}
		return res;
	}
	
	// Driver program to test above function.
	public static void main(String[] args)
	{
		int stream[] = {1, 2, 3, 4};
		int n = stream.length;
		for(int i = 0; i < n; i++)
			System.out.println("Random number from first " + (i+1) +
							" numbers is " + selectRandom(stream[i]));
	}
}
//This code is contributed by Sumit Ghosh
