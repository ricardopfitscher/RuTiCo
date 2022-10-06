//https://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/
//O(1)
class GFG{
static boolean oppositeSigns(int x, int y)
{
	return (x < 0)? (y >= 0): (y < 0);
}
}

// This code contributed by umadevi9616
