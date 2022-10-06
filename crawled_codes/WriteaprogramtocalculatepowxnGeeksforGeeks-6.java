//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
//O(log(n)
// Java program for above approach
class GFG{

static int power(int x, int y)
{
	int result = 1;
	
	while (y > 0)
	{
		
		// y is even
		if (y % 2 == 0)
		{
			x = x * x;
			y = y / 2;
		}
		
		// y isn't even
		else
		{
			result = result * x;
			y = y - 1;
		}
	}
	return result;
}

// Driver Code
public static void main(String[] args)
{
	int x = 2;
	int y = 3;
	
	System.out.println(power(x, y));
}
}

// This code is contributed by hritikrommie
