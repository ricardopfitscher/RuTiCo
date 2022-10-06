import java.util.*;

public class ErrorCorrectSystem
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String a = scan.next();
		String b = scan.next();
		
		int[][] mismatch = new int[26][26];
		for(int i = 0; i < 26; i++) Arrays.fill(mismatch[i], -1);
		int[][] pair = new int[2][26];
		for(int i = 0; i < 2; i++) Arrays.fill(pair[i], -1);
		int hd = 0;
		for(int i = 0; i < n; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				hd++;
				mismatch[a.charAt(i)-'a'][b.charAt(i)-'a'] = i;
				pair[0][a.charAt(i)-'a'] = i;
				pair[1][b.charAt(i)-'a'] = i;
			}
		}
		for(int i = 0; i < 26; i++) {
			for(int j = i+1; j < 26; j++) {
				if(mismatch[i][j] > -1 && mismatch[j][i] > -1) {
					System.out.println(hd-2);
					System.out.println((mismatch[i][j]+1)+" "+(mismatch[j][i]+1));
					return;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				//try a gets b's letter
				if(pair[0][b.charAt(i)-'a'] > -1) {
					System.out.println(hd-1);
					System.out.println((i+1)+" "+(pair[0][b.charAt(i)-'a']+1));
					return;
				}
			}
		}
		
		System.out.println(hd);
		System.out.println("-1 -1");
	}

}
