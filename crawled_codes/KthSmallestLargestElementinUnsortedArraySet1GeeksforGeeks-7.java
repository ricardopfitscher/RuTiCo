//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
//O(n log k)
// Java code to implement the approach
import java.util.*;

//Custom comparator class to form the Max heap
class MinHeapComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer number1, Integer number2) {
		int value = number1.compareTo(number2);
	
		// Elements are sorted in reverse order
		if (value > 0) {
			return -1;
		}
		else if (value < 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
class GFG{

// Function to find kth smallest array element
static int kthSmallest(int []v, int N, int K)
{
	//For finding min element we need (Max heap)priority queue
	PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new MinHeapComparator());
	
	for (int i = 0; i < N; ++i) {

		// Insert elements into
		// the priority queue
		heap1.add(v[i]);

		//If current element is less than top, that means there are
		//other k-1 lesser elements are present at bottom
		// thus pop that element and add kth largest element into the heap till curr
		// at last all the greater element than kth element will get pop off
		// and at the top of heap there will be kth smallest element
		if (heap1.size() > K) {
			heap1.remove();
		}
	}

	//Return the top of the heap as kth smallest element
	return heap1.peek();
}

// Driver code
public static void main(String[] args)
{
	// Given array
	int []vec = {10, 5, 4 , 3 ,48, 15, 6 , 2 , 33, 53, 10};

	// Size of array
	int N = vec.length;

	// Given K
	int K = 4;

	// Function Call
	System.out.println("Kth Smallest Element: " + kthSmallest(vec, N, K)) ;
}
}
