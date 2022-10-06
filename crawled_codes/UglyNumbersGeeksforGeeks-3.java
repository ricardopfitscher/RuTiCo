//https://www.geeksforgeeks.org/ugly-numbers/
//O(n)
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {

	static long nthUglyNumber(int n)
	{

		TreeSet<Long> t = new TreeSet<>();
		// Ugly number sequence starts with 1
		t.add(1L);
		int i = 1;
		// when i==n we have the nth ugly number
		while (i < n) {
			// remove the ith ugly number and add back its
			// multiples of 2,3 and 5 back to the set
			long temp = t.pollFirst();
			t.add(temp * 2);
			t.add(temp * 3);
			t.add(temp * 5);
			i++;
			// the first element of set is always the ith
			// ugly number
		}

		return t.pollFirst();
	}

	public static void main(String[] args)
	{
		int n = 150;
		System.out.println(nthUglyNumber(n));
	}
}
// Contributed by:- Saswata Halder
