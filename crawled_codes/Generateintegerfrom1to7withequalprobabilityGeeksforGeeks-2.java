//https://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-probability/
//O(1)
// Java program to Generate integer from
// 1 to 5 with equal probability
class GfG
{

// given method that returns 1 to 5 with equal probability
static int foo()
{
	// some code here
	return 0;
}

// returns 1 to 7 with equal probability
public static int my_rand()
{
	int i;
	i = 5*foo() + foo() - 5;
	if (i < 22)
		return i%7 + 1;
	return my_rand();
}

// Driver code
public static void main (String[] args) {

	System.out.println(my_rand());
}
}
