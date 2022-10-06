import java.util.*;

public class CoinsTask {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int S = in.nextInt();
		int mCoins = 0;
		while(S/n != 0) {
			mCoins+=1;
			S-=n;
		}
		mCoins = S == 0? mCoins : mCoins+1;
		System.out.print(mCoins);
	}

}
