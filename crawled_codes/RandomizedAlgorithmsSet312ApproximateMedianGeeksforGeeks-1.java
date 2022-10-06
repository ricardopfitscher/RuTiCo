//https://www.geeksforgeeks.org/randomized-algorithms-set-3-12-approximate-median/
//O(log n (log log n))
/* Java program to find Approximate Median using
1/2 Approximate Algorithm */
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;


class Test
{
	static int arr[] = new int[]{1, 3, 2, 4, 5, 6, 8, 7} ;
	
	// This function returns the Approximate Median
	static int randApproxMedian(int n)
	{
		// Declaration for the random number
		Random r = new Random();
		
		if (n==0)
			return 0;
		
		double k1 = 10*Math.log(n); // Taking c as 10
	
		int k = (int)k1;
		
		// A treeset stores unique elements in sorted order
		TreeSet s = new TreeSet<Integer>();
		for (int i=0; i<k; i++)
		{
			// Generating a random index
			// Random number generated will be in the range [0,n-1]
			int index = r.nextInt(n);
	
			//Inserting into the set
			s.add(arr[index]);
		}
	
		Iterator<Integer> itr = s.iterator();
		
		int temp = s.size()/2 - 1;
		
		for (int i = 0; i < temp; i++) {
			itr.next();
		}
	
		// Return the median
		return itr.next();
	}

	// Driver method to test the above function
	public static void main(String[] args) {
	
		System.out.println("Approximate Median is " + randApproxMedian(arr.length));
	
	}
}
