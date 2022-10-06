//https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
//O(n^2)
// A O(n^2) time and O(1) extra space solution

class GFG {

	static int findLength(String str, int n) {
		int ans = 0; // Initialize result

		// Consider all possible midpoints one by one
		for (int i = 0; i <= n - 2; i++) {
			/* For current midpoint 'i', keep expanding substring on
		both sides, if sum of both sides becomes equal update
		ans */
			int l = i, r = i + 1;

			/* initialize left and right sum */
			int lsum = 0, rsum = 0;

			/* move on both sides till indexes go out of bounds */
			while (r < n && l >= 0) {
				lsum += str.charAt(l) - '0';
				rsum += str.charAt(r) - '0';
				if (lsum == rsum) {
					ans = Math.max(ans, r - l + 1);
				}
				l--;
				r++;
			}
		}
		return ans;
	}

// Driver program to test above function
	static public void main(String[] args) {
		String str = "123123";
		System.out.println("Length of the substring is "
				+ findLength(str, str.length()));
	}
}

// This code is contributed by Rajput-Ji
