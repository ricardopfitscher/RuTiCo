import java.util.Scanner;

public class ChainReaction {
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		
		int[] beacons = new int[1000002];
		for (int i=0; i<num; i++) {
			beacons[kb.nextInt()] = kb.nextInt();
		}
		
		int [] dp = new int[1000002];
		int max = 0;
		if (beacons[0] != 0)
			dp[0] = 1;
		
		for (int i=1; i<dp.length; i++) {
			if (beacons[i] == 0) {
				dp[i] = dp[i-1];
			} else {
				int index = i-1-beacons[i];
				if (index<0)
					dp[i] = 1;
				else
					dp[i] = 1 + dp[index];
			}
			max = Math.max(max, dp[i]);
			//if (i<11)
				//System.out.println(i +" is "+dp[i]);
		}
		
		System.out.println(num-max);
	}

}
