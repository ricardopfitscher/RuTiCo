//https://www.geeksforgeeks.org/check-two-given-sets-disjoint/
//O(m+n)
// Java program to check if two sets are disjoint

import java.util.Arrays;

public class disjoint1
{
	// Returns true if set1[] and set2[] are
	// disjoint, else false
	boolean aredisjoint(int set1[], int set2[])
	{
		int i=0,j=0;
		
		// Sort the given two sets
		Arrays.sort(set1);
		Arrays.sort(set2);
		
		// Check for same elements using
		// merge like process
		while(i<set1.length && j<set2.length)
		{
			if(set1[i]<set2[j])
				i++;
			else if(set1[i]>set2[j])
				j++;
			else
				return false;
			
		}
		return true;
	}

	// Driver program to test above function
	public static void main(String[] args)
	{
		disjoint1 dis = new disjoint1();
		int set1[] = { 12, 34, 11, 9, 3 };
		int set2[] = { 7, 2, 1, 5 };

		boolean result = dis.aredisjoint(set1, set2);
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}

// This code is contributed by Rishabh Mahrsee
