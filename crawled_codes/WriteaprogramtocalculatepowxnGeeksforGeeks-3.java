//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//O(logn)
/* Java code for extended version of power function
that can work for float x and negative y */
class GFG {
	
	static float power(float x, int y)
	{
		float temp;
		if( y == 0)
			return 1;
		temp = power(x, y/2);
		
		if (y%2 == 0)
			return temp*temp;
		else
		{
			if(y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
	
	/* Program to test function power */
	public static void main(String[] args)
	{
		float x = 2;
		int y = -3;
		System.out.printf("%f", power(x, y));
	}
}

// This code is contributed by Smitha Dinesh Semwal.
