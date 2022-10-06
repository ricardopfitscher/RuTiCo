import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class C {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int n = sc.nextInt();
		int[] counts = new int[60];
		ArrayList<ArrayDeque<Long>> nums = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			nums.add(new ArrayDeque<>());
		}
		for (int i = 0; i < n; i++) {
			long num = sc.nextLong();
			for (int j = 1; j <= 60; ++j) {
				if (num < (1L<<j)) {
					nums.get(j-1).add(num);
					++counts[j-1];
					break;
				}
			}
		}
		long curr = 0;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 60; ++j) {
				if (j==60) {
					System.out.println("No");
					return;
				}
				if (counts[j]==0||(curr&(1L<<j))!=0)
					continue;
				long num = nums.get(j).removeFirst();
				--counts[j];
				curr ^= num;
				if (i>0)
					ans.append(" ");
				ans.append(num);
				break;
			}
		}
		System.out.println("Yes");
		System.out.println(ans);
	}
}
