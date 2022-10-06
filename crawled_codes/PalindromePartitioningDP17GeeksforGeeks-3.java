//https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
//O(n^2)
import java.io.*;

class GFG {

	public static int minCut(String a)
	{
		int[] cut = new int[a.length()];
		boolean[][] palindrome = new boolean[a.length()][a.length()];

		for (int i = 0; i < a.length(); i++) {
			int minCut = i;
			for (int j = 0; j <= i; j++) {
				if (a.charAt(i) == a.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) {
					palindrome[j][i] = true;
					minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1));
				}
			}
			cut[i] = minCut;
		}

		return cut[a.length() - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(minCut("aab"));
		System.out.println(minCut("aabababaxx"));
	}
}
