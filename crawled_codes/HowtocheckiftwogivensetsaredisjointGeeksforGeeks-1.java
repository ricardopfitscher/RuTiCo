//https://www.geeksforgeeks.org/check-two-given-sets-disjoint/
//O(mn)
// Java program to check if two sets are disjoint

public class disjoint1
{
	// Returns true if set1[] and set2[] are
	// disjoint, else false
	boolean aredisjoint(int set1[], int set2[])
	{
		// Take every element of set1[] and
		// search it in set2
		for (int i = 0; i < set1.length; i++)
		{
			for (int j = 0; j < set2.length; j++)
			{
				if (set1[i] == set2[j])
					return false;
			}
		}
		// If no element of set1 is present in set2
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
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by Rishabh Mahrsee
