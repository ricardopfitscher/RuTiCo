import java.util.Scanner;

public class codef8 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int beacon[] = new int[1000001];
		for (int i = 0; i < num; i++) {
			beacon[sc.nextInt()] = sc.nextInt();
		}
		int dp[] = new int[1000001];
		int max = 1;
		if (beacon[0] > 0) {
			dp[0] = 1;
		}
		
		for (int i = 1; i <= 1000000; i++) {
			if (beacon[i] == 0) {
				dp[i] = dp[i-1];
			} 
			else {
				int b = beacon[i];
				if (i <= b) {
					dp[i] = 1;
				}
				else {
					dp[i] = dp[i-b-1] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}		
		System.out.println(num-max);
		sc.close();
	}

}
