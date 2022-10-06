//https://www.geeksforgeeks.org/average-of-a-stream-of-numbers/
//O(n)
// Java program to return
// Average of a stream of numbers
class GFG
{
static int sum, n;
	
// Returns the new average
// after including x
static float getAvg(int x)
{
	sum += x;
	return (((float)sum) / ++n);
}

// Prints average of a
// stream of numbers
static void streamAvg(float[] arr,
					int n)
{
	float avg = 0;
	for (int i = 0; i < n; i++)
	{
		avg = getAvg((int)arr[i]);
		System.out.println("Average of "+ (i + 1) +
						" numbers is " + avg);
	}
	return;
}

// Driver Code
public static void main(String[] args)
{
	float[] arr = new float[]{ 10, 20, 30,
							40, 50, 60 };
	int n = arr.length;
	streamAvg(arr, n);
}
}

// This code is contributed by mits
