//https://www.geeksforgeeks.org/find-the-element-that-appears-once/
//O(n log n)
// Java program for the above approach

import java.io.*;
import java.util.*;

class GFG {
	
	// function which find number
	static int singlenumber(int a[],int N)
	{
		// umap for finding frequency
		Map<Integer, Integer> fmap
			= new HashMap<Integer, Integer>();
			
		
		// traverse the array for frequency
		for(int i = 0; i < N;i++)
		{
			if(!fmap.containsKey(a[i]))
				fmap.put(a[i],0);
			
			fmap.put(a[i],fmap.get(a[i])+1);
		}
		
		// iterate over the map
		for(Map.Entry<Integer, Integer> me : fmap.entrySet())
		{
			
			// check frequency whether it is one or not.
			if(me.getValue()==1)
			{
				
				// return it as we got the answer
				return me.getKey();
			}
		}
		return -1;
		
	}
	
	// Driver code
	public static void main (String[] args) {
		
		
		// given array
	int a[]={12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
	
	// size of the array
	int N= a.length;
	
	
		// printing the returned value
		System.out.println("The element with single occurrence is "+singlenumber(a,N));
	}
}

// This code is contributed by avanitrachhadiya2155
