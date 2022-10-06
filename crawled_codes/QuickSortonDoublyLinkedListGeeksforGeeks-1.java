//https://www.geeksforgeeks.org/quicksort-for-linked-list/
//O(nlogn)
/* A typical recursive implementation of
Quicksort for array*/

/* This function takes last element as pivot,
places the pivot element at its correct
position in sorted array, and places all
smaller (smaller than pivot) to left of
pivot and all greater elements to right
of pivot */
static int partition (int []arr, int l, int h)
{
	int x = arr[h];
	int i = (l - 1);
	
	for(int j = l; j <= h - 1; j++)
	{
		if (arr[j] <= x)
		{
			i++;
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	int tmp = arr[i + 1];
	arr[i + 1] = arr[h];
	arr[h] = tmp;
	return(i + 1);
}

/* A[] --> Array to be sorted,
	l --> Starting index,
	h --> Ending index */
static void quickSort(int []A, int l,
					int h)
{
	if (l < h)
	{
	
		// Partitioning index
		int p = partition(A, l, h);
		quickSort(A, l, p - 1);
		quickSort(A, p + 1, h);
	}
}

// This code is contributed by pratham76.
