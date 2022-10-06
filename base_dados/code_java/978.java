import java.util.Scanner;

public class codef8 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int beacon[] = new int[1000001];
		int pos[] = new int[num];
		for (int i = 0; i < num; i++) {
			int position = sc.nextInt();
			beacon[position] = sc.nextInt();
			pos[i] = position;
		}
		int dp[] = new int[1000001];
		int max = 1;
		if (beacon[0] != 0)
			dp[0] = 1;
		
		for (int i = 1; i <= 1000000; i++) {
			if (beacon[i] == 0) {
				dp[i] = dp[i-1];
			} 
			else {
				int j = i - beacon[i] - 1;
				if (j < 0) {
					dp[i] = 1;
				}
				else {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}		
		System.out.println(num-max);
	}

}
