import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] a = new int[m];
		for (int i = 0; i < m; ++i) a[i] = in.nextInt();

		if (n > m) return 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int k: a) map.put(k, map.getOrDefault(k, 0) + 1);

		List<Integer> keySet = new ArrayList<>(map.keySet());
		int end = m / n;

		keySet.sort((u, v) -> -Integer.compare(u, v));
		do {
			int count = 0;
			for (int k: keySet) {
				count += map.get(k) / end;
				if (count >= n) return end;
			}
		} while (--end > 0);

		return 0;
	}
}
