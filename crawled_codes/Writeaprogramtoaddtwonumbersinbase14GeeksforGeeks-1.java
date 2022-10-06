//https://www.geeksforgeeks.org/write-a-program-to-add-two-numbers-in-base-14/
//O(|num1|)
// Java program for the
// above approach
import java.util.*;
class GFG{

// Function to add two
// numbers in base 14
static String sumBase14(char num1[],
						char num2[])
{
int l1 = num1.length;
int l2 = num2.length;
char []res;
int i;
int nml1, nml2, res_nml;
int carry = 0;

if(l1 != l2)
{
	System.out.print("Function doesn't support " +
					"numbers of different " +
					"lengths. If you want to " +
					"dd such numbers then " +
					"prefix smaller number " +
					"with required no. of zeroes");
}

// Note the size of the allocated
// memory is one more than i/p
// lengths for the cases where we
// have carry at the last like
// adding D1 and A1
res = new char[(4 * (l1 + 1))];

// Add all numerals from
// right to left
for(i = l1 - 1; i >= 0; i--)
{
	// Get decimal values of the
	// numerals of i/p numbers
	nml1 = getNumeralValue(num1[i]);
	nml2 = getNumeralValue(num2[i]);

	// Add decimal values of
	// numerals and carry
	res_nml = carry + nml1 + nml2;

	// Check if we have carry for
	// next addition of numerals
	if(res_nml >= 14)
	{
	carry = 1;
	res_nml -= 14;
	}
	else
	{
	carry = 0;
	}
	res[i + 1] = getNumeral(res_nml);
}

// If there is no carry after
// last iteration then result
// should not include 0th
// character of the resultant
// String
if(carry == 0)
	return String.valueOf(res);

// If we have carry after last
// iteration then result should
// include 0th character
res[0] = '1';
return String.valueOf(res);
}

// Function to get value of a numeral
// For example it returns 10 for input
// 'A' 1 for '1', etc
static int getNumeralValue(char num)
{
if(num >= '0' && num <= '9')
	return (num - '0');
if(num >= 'A' && num <= 'D')
	return (num - 'A' + 10);

// If we reach this line
// caller is giving invalid
// character so we assert
// and fail
// assert(0);
return 0;
}

// Function to get numeral
// for a value. For example
// it returns 'A' for input 10
// '1' for 1, etc
static char getNumeral(int val)
{
if(val >= 0 && val <= 9)
	return (char)(val + '0');
if(val >= 10 && val <= 14)
	return (char)(val + 'A' - 10);

// If we reach this line
// caller is giving invalid
// no. so we assert and fail
// assert(0);
return '0';
}

// Driver code
public static void main(String[] args)
{
char num1[] = {'D','C','2'};
char num2[] = {'0','A','3'};
System.out.print("Result is " +
					sumBase14(num1,
							num2));
}
}

// This code is contributed by 29AjayKumar
