//https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
//O(mn)
// memoization Java program to check
// if a string is subsequence
// of another string
class GFG {

public static int[][] dp = new int[1001][1001];

// returns the length of longest common subsequence
public static int isSubSequence(String s1, String s2,
								int i, int j)
{
	if (i == 0 || j == 0) {
	return 0;
	}
	if (dp[i][j] != -1) {
	return dp[i][j];
	}
	if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
	return dp[i][j]
		= 1 + isSubSequence(s1, s2, i - 1, j - 1);
	}
	else {
	return dp[i][j]
		= isSubSequence(s1, s2, i, j - 1);
	}
}

/* Driver program to test above function */
public static void main(String[] args)
{
	String str1 = "gksrek";
	String str2 = "geeksforgeeks";
	int m = str1.length();
	int n = str2.length();
	if (m > n) {
	System.out.println("NO");
	}
	for (int i = 0; i <= 1000; i++) {
	for (int j = 0; j <= 1000; j++)
		dp[i][j] = -1;
	}
	if (isSubSequence(str1, str2, m, n) == m) {
	System.out.println("YES");
	}

	else {
	System.out.println("NO");
	}
}
}

// This code is contributed by phasing17
