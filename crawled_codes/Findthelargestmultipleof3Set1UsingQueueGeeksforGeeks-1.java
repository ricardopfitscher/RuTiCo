//https://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
//O(n)
/* Java program to find the largest multiple
of 3 that can be formed from an array
of elements */
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Geeks {

	// This function puts all elements of 3 queues in the
	// array auxiliary
	public static int populateAux(int aux[], Queue<Integer> queue0,
						Queue<Integer> queue1, Queue<Integer> queue2)
	{
		int top=0;
		// Put all items of first queue in aux[]
		while(!queue0.isEmpty())
		{
			aux[top++]=queue0.remove();
		}

		// Put all items of second queue in aux[]
		while(!queue1.isEmpty())
		{
			aux[top++]=queue1.remove();
		}

		// Put all items of third queue in aux[]
		while(!queue2.isEmpty())
		{
			aux[top++]=queue2.remove();
		}

		//Return number of integer added to aux[]
		return top;
	}

	// The main function that finds the largest possible multiple of
	// 3 that can be formed by arr[] elements
	public static boolean findMaxMultupleOf3(int arr[])
	{
		// Step 1: sort the array in non-decreasing order
		Arrays.sort(arr);

		// Create 3 queues to store numbers with remainder 0, 1
		// and 2 respectively
		Queue<Integer> queue0=new LinkedList<>();
		Queue<Integer> queue1=new LinkedList<>();
		Queue<Integer> queue2=new LinkedList<>();

		// Step 2 and 3 get the sum of numbers and place them in
		// corresponding queues
		int sum=0;
		for (int i = 0; i < arr.length; ++i)
		{
			sum += arr[i];
			if ((arr[i] % 3) == 0)
				queue0.add(arr[i]);
			else if ((arr[i] % 3) == 1)
				queue1.add(arr[i]);
			else
				queue2.add(arr[i]);
		}

		// Step 4.2: The sum produces remainder 1
		if ((sum % 3) == 1)
		{
			// either remove one item from queue1
			if (!queue1.isEmpty())
				queue1.remove();

			// or remove two items from queue2
			else
			{
				if (!queue2.isEmpty())
					queue2.remove();
				else
					return false;

				if (!queue2.isEmpty())
					queue2.remove();
				else
					return false;
			}
		}
		// Step 4.3: The sum produces remainder 2
		else if ((sum % 3) == 2)
		{
			// either remove one item from queue2
			if (!queue2.isEmpty())
				queue2.remove();
			// or remove two items from queue1
			else
			{
				if (!queue1.isEmpty())
					queue1.remove();
				else
					return false;

				if (!queue1.isEmpty())
					queue1.remove();
				else
					return false;
			}
		}
		
		int aux[]=new int[arr.length];
		// Empty all the queues into an auxiliary array
		// and get the number of integers added to aux[]
		int top=populateAux(aux,queue0,queue1,queue2);

		// sort the array in non-increasing order
		Arrays.sort(aux,0,top);

		// print the result
		for (int i = top-1; i>=0; i--)
			System.out.print(aux[i]+" ") ;

		return true;
	}

	public static void main(String args[])
	{
		int arr[] = { 8, 1, 7, 6, 0 };
		if (!findMaxMultupleOf3(arr))
		System.out.println("Not possible") ;
	}
}

// This code is contributed by Gaurav Tiwari
