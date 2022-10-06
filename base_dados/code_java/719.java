import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();

		StringBuilder ans = new StringBuilder();
		int count = 0;
		int open = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				ans.append("(");
				count++;
				open++;
			} else {
				ans.append(")");
				open--;
			}
			if (count == k / 2) {
				break;
			}
		}

		while (open > 0) {
			ans.append(")");
			open--;
		}
		System.out.println(ans.toString());
	}
}