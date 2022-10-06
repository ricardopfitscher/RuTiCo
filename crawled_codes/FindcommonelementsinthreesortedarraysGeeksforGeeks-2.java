//https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
//O(n1 + n2 + n3)
// Java program to find common
// elements in three arrays
class FindCommon {

	// This function prints common elements in ar1
	void findCommon(int ar1[], int ar2[], int ar3[])
	{

		// Initialize starting indexes for ar1[],
		// ar2[] and ar3[]
		int i = 0, j = 0, k = 0;
		int n1 = ar1.length;
		int n2 = ar2.length;
		int n3 = ar3.length;

		// Declare three variables prev1,
		// prev2, prev3 to track previous
		// element
		int prev1, prev2, prev3;

		// Initialize prev1, prev2,
		// prev3 with INT_MIN
		prev1 = prev2 = prev3 = Integer.MIN_VALUE;

		while (i < n1 && j < n2 && k < n3) {

			// If ar1[i] = prev1 and i < n1,
			// keep incrementing i
			while (i < n1 && ar1[i] == prev1)
				i++;

			// If ar2[j] = prev2 and j < n2,
			// keep incrementing j
			while (j < n2 && ar2[j] == prev2)
				j++;

			// If ar3[k] = prev3 and k < n3,
			// keep incrementing k
			while (k < n3 && ar3[k] == prev3)
				k++;

			if (i < n1 && j < n2 && k < n3) {

				// If x = y and y = z, print any of
				// them, update prev1 prev2, prev3
				// and move ahead in each array
				if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
					System.out.print(ar1[i] + " ");
					prev1 = ar1[i];
					prev2 = ar2[j];
					prev3 = ar3[k];
					i++;
					j++;
					k++;
				}

				// If x < y, update prev1
				// and increment i
				else if (ar1[i] < ar2[j]) {
					prev1 = ar1[i];
					i++;
				}

				// If y < z, update prev2
				// and increment j
				else if (ar2[j] < ar3[k]) {
					prev2 = ar2[j];
					j++;
				}

				// We reach here when x > y
				// and z < y, i.e., z is
				// smallest update prev3
				// and imcrement k
				else {
					prev3 = ar3[k];
					k++;
				}
			}
		}
	}

	// Driver code
	public static void main(String args[])
	{
		FindCommon ob = new FindCommon();

		int ar1[] = { 1, 5, 10, 20, 40, 80, 80 };
		int ar2[] = { 6, 7, 20, 80, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 80, 120 };

		System.out.print("Common elements are ");

		ob.findCommon(ar1, ar2, ar3);
	}
}

// This code is contributed by rajsanghavi9.
