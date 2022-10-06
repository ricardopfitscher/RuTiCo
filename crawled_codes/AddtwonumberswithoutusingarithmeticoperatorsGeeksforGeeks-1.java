//https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
//O(log n)
import java.util.*;

class GFG {

	static int add(int a, int b)
	{
		// for loop will start from 1 and move till the
		// value of second number , first number(a) is
		// incremented in for loop
		for (int i = 1; i <= b; i++)
			a++;
		return a;
	}

	public static void main(String[] args)
	{
		// first number is 10 and second number is 32 , for
		// loop will start from 1 and move till 32 and the
		// value of a is incremented 32 times which will
		// give us the total sum of two numbers
		int a = add(10, 32);
		System.out.print(a);
	}
}

// This code is contributed by Aditya Kumar (adityakumar129)
