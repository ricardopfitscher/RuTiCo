//https://www.geeksforgeeks.org/birthday-paradox/
//O(log n)
class GFG{
public static void main(String[] args){

	// Assuming non-leap year
	float num = 365;

	float denom = 365;
	double pr=0.7;
	int n = 0;


	float p = 1;
	while (p > pr){
	p *= (num/denom);
	num--;
	n++;
	}

	System.out.printf("\nTotal no. of people out of which there is ");
	System.out.printf( "%.1f probability that two of them "
					+ "have same birthdays is %d ", p, n);
}
}

// This code is contributed by Rajput-Ji
