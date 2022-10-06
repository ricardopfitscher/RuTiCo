//https://www.geeksforgeeks.org/program-to-find-parity/
//O(1)
// C++ program to find parity
// of an integer
# include<bits/stdc++.h>
# define bool int
using namespace std;

// Function to get parity of number n. It returns 1
// if n has odd parity, and returns 0 if n has even
// parity
bool getParity(unsigned int n)
{
	return __builtin_parity(n);
}

// Driver code
int main()
{
	unsigned int n = 7;
	cout<<"Parity of no "<<n<<" = "<<(getParity(n)? "odd": "even");
	
	getchar();
	return 0;
}

// This code is contributed by Kasina Dheeraj
