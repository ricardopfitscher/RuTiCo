//https://www.geeksforgeeks.org/tug-of-war/
//O(2^n)
// Java program for Tug of war
import java.util.*;
import java.lang.*;
import java.io.*;

class TugOfWar
{
	public int min_diff;
	
	// function that tries every possible solution
	// by calling itself recursively
	void TOWUtil(int arr[], int n, boolean curr_elements[],
			int no_of_selected_elements, boolean soln[],
			int sum, int curr_sum, int curr_position)
	{
		// checks whether the it is going out of bound
		if (curr_position == n)
			return;

		// checks that the numbers of elements left
		// are not less than the number of elements
		// required to form the solution
		if ((n / 2 - no_of_selected_elements) >
				(n - curr_position))
			return;

		// consider the cases when current element
		// is not included in the solution
		TOWUtil(arr, n, curr_elements,
			no_of_selected_elements, soln, sum,
			curr_sum, curr_position+1);

		// add the current element to the solution
		no_of_selected_elements++;
		curr_sum = curr_sum + arr[curr_position];
		curr_elements[curr_position] = true;

		// checks if a solution is formed
		if (no_of_selected_elements == n / 2)
		{
			// checks if the solution formed is
			// better than the best solution so
			// far
			if (Math.abs(sum / 2 - curr_sum) <
								min_diff)
			{
				min_diff = Math.abs(sum / 2 -
								curr_sum);
				for (int i = 0; i < n; i++)
					soln[i] = curr_elements[i];
			}
		}
		else
		{
			// consider the cases where current
			// element is included in the
			// solution
			TOWUtil(arr, n, curr_elements,
					no_of_selected_elements,
					soln, sum, curr_sum,
					curr_position + 1);
		}

		// removes current element before
		// returning to the caller of this
		// function
		curr_elements[curr_position] = false;
	}

	// main function that generate an arr
	void tugOfWar(int arr[])
	{
		int n = arr.length;

		// the boolean array that contains the
		// inclusion and exclusion of an element
		// in current set. The number excluded
		// automatically form the other set
		boolean[] curr_elements = new boolean[n];
		
		// The inclusion/exclusion array for
		// final solution
		boolean[] soln = new boolean[n];

		min_diff = Integer.MAX_VALUE;

		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum += arr[i];
			curr_elements[i] = soln[i] = false;
		}

		// Find the solution using recursive
		// function TOWUtil()
		TOWUtil(arr, n, curr_elements, 0,
				soln, sum, 0, 0);

		// Print the solution
		System.out.print("The first subset is: ");
		for (int i = 0; i < n; i++)
		{
			if (soln[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.print("\nThe second subset is: ");
		for (int i = 0; i < n; i++)
		{
			if (soln[i] == false)
				System.out.print(arr[i] + " ");
		}
	}
	
	// Driver program to test above functions
	public static void main (String[] args)
	{
		int arr[] = {23, 45, -34, 12, 0, 98,
					-99, 4, 189, -1, 4};
		TugOfWar a = new TugOfWar();
		a.tugOfWar(arr);
	}
}

// This code is contributed by Chhavi
