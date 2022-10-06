//https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
//O(n^2)
// Using memoizatoin to solve the partition problem.
#include <bits/stdc++.h>
using namespace std;
// Function to check if input string is palindrome or not
bool ispalindrome(string input, int start, int end)
{
	// Using two pointer technique to check palindrome
	while (start < end) {
		if (input[start] != input[end])
			return false;
		start++;
		end--;
	}
	return true;
}

// Function to find keys for the Hashmap
string convert(int a, int b)
{
	return to_string(a) + "" + to_string(b);
}

// Returns the minimum number of cuts needed to partition a string
// such that every part is a palindrome
int minpalparti_memo(string input, int i, int j, unordered_map<string, int>& memo)
{
	if (i > j)
		return 0;
	// Key for the Input String
	string ij = convert(i, j);

	// If the no of partitions for string "ij" is already calculated
	// then return the calculated value using the Hashmap
	if (memo.find(ij) != memo.end()) {
		return memo[ij];
	}
	// Every String of length 1 is a palindrome
	if (i == j) {
		memo[ij] = 0;
		return 0;
	}
	if (ispalindrome(input, i, j)) {
		memo[ij] = 0;
		return 0;
	}
	int minimum = INT_MAX;
	// Make a cut at every possible location starting from i to j
	for (int k = i; k < j; k++) {
		int left_min = INT_MAX;
		int right_min = INT_MAX;
		string left = convert(i, k);
		string right = convert(k + 1, j);

		// If left cut is found already
		if (memo.find(left) != memo.end()) {
			left_min = memo[left];
		}
		// If right cut is found already
		if (memo.find(right) != memo.end()) {
			right_min = memo[right];
		}

		// Recursively calculating for left and right strings
		if (left_min == INT_MAX)
			left_min = minpalparti_memo(input, i, k, memo);
		if (right_min == INT_MAX)
			right_min = minpalparti_memo(input, k + 1, j, memo);

		// Taking minimum of all k possible cuts
		minimum = min(minimum, left_min + 1 + right_min);
	}

	memo[ij] = minimum;
	// Return the min cut value for complete string.
	return memo[ij];
}
int main()
{
	string input = "ababbbabbababa";
	unordered_map<string, int> memo;
	cout << minpalparti_memo(input, 0, input.length() - 1, memo) << endl;
	return 0;
}
