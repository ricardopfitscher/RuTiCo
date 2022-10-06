import java.util.Scanner;

public class TreasureHunt {
	
	public static String Solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String kuro = sc.nextLine(), shiro = sc.nextLine(), katie = sc.nextLine();
		sc.close();
		String[] output = {"Kuro", "Shiro", "Katie", "Draw"};
		if(n >= kuro.length())
			return output[3];
		int[] maxArr = new int[3];		
		int[][] freq = new int[3][58];
		for(int i = 0; i < kuro.length(); i++) {
			maxArr[0] = ++freq[0][kuro.charAt(i) - 65] > maxArr[0]? freq[0][kuro.charAt(i) - 65] : maxArr[0];
			maxArr[1] = ++freq[1][shiro.charAt(i) - 65] > maxArr[1]? freq[1][shiro.charAt(i) - 65] : maxArr[1];
			maxArr[2] = ++freq[2][katie.charAt(i) - 65] > maxArr[2]? freq[2][katie.charAt(i) - 65] : maxArr[2];
		}
		int winner = 0, max = 0;
		for(int i = 0; i < 3; i++) {
			if(kuro.length() - maxArr[i] >= n)
				maxArr[i] += n;
			else 
				maxArr[i] = n == 1? kuro.length() - 1: kuro.length();
			if(max < maxArr[i]) {
				winner = i;
				max = maxArr[i];
			} else if(max == maxArr[i])
				winner = 3;
		}
		
		return output[winner];
	}
	public static void main(String[] args) {
		System.out.println(Solve());
	}
}
