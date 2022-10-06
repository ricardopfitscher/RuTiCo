//https://www.geeksforgeeks.org/average-of-a-stream-of-numbers/
//O(n)
// Java program to find average
// of a stream of numbers
class GFG {

	// Returns the new average after including x
	static float getAvg(float prev_avg, float x, int n)
	{
		return (prev_avg * n + x) / (n + 1);
	}

	// Prints average of a stream of numbers
	static void streamAvg(float arr[], int n)
	{
		float avg = 0;
		for (int i = 0; i < n; i++)
		{
			avg = getAvg(avg, arr[i], i);
			System.out.printf("Average of %d numbers is %f \n",
												i + 1, avg);
		}
		return;
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		float arr[] = { 10, 20, 30, 40, 50, 60 };
		int n = arr.length;
		streamAvg(arr, n);
	}
}

// This code is contributed by Smitha Dinesh Semwal
