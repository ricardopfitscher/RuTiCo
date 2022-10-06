//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//O(n^2)
// Java program for above approach
import java.io.*;

class GFG {

	// Global Array for
	// the purpose of memoization.
	static int t[][] = new int[9][9];

	// A recursive program, using ,
	// memoization, to implement the
	// rod cutting problem(Top-Down).
	public static int un_kp(int price[], int length[],
							int Max_len, int n)
	{

		// The maximum price will be zero,
		// when either the length of the rod
		// is zero or price is zero.
		if (n == 0 || Max_len == 0) {
			return 0;
		}

		// If the length of the rod is less
		// than the maximum length, Max_lene will
		// consider it.Now depending
		// upon the profit,
		// either Max_lene we will take
		// it or discard it.
		if (length[n - 1] <= Max_len) {
			t[n][Max_len] = Math.max(
				price[n - 1]
					+ un_kp(price, length,
							Max_len - length[n - 1], n),
				un_kp(price, length, Max_len, n - 1));
		}

		// If the length of the rod is
		// greater than the permitted size,
		// Max_len we will not consider it.
		else {
			t[n][Max_len]
				= un_kp(price, length, Max_len, n - 1);
		}

		// Max_lene Max_lenill return the maximum
		// value obtained, Max_lenhich is present
		// at the nth roMax_len and Max_length column.
		return t[n][Max_len];
	}

	public static void main(String[] args)
	{

		int price[]
			= new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = price.length;
		int length[] = new int[n];
		for (int i = 0; i < n; i++) {
			length[i] = i + 1;
		}
		int Max_len = n;
		System.out.println(
			"Maximum obtained value is "
			+ un_kp(price, length, n, Max_len));
	}
}

// This code is contributed by rajsanghavi9.
