//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
//O(k) + O((m) * log(k))
// A java program to sort a nearly sorted array
import java.util.Iterator;
import java.util.PriorityQueue;

class GFG {
	private static void kSort(int[] arr, int n, int k)
	{

		// min heap
		PriorityQueue<Integer> priorityQueue
			= new PriorityQueue<>();

		// add first k + 1 items to the min heap
		for (int i = 0; i < k + 1; i++) {
			priorityQueue.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < n; i++) {
			arr[index++] = priorityQueue.peek();
			priorityQueue.poll();
			priorityQueue.add(arr[i]);
		}

		Iterator<Integer> itr = priorityQueue.iterator();

		while (itr.hasNext()) {
			arr[index++] = priorityQueue.peek();
			priorityQueue.poll();
		}
	}

	// A utility function to print the array
	private static void printArray(int[] arr, int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver Code
	public static void main(String[] args)
	{
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);
	}
}

// This code is contributed by
// Manpreet Singh(manpreetsngh294)
