import java.util.Arrays;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution ss = new Solution();
		ss.test(sc);
	}
	
	void test(Scanner sc){
		int LEN = sc.nextInt();
		int[] a = new int[LEN];
		int[] b = new int[LEN];
		for (int i = 0; i < b.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		
		int ia=0, ib=0;
		while(ia<LEN && a[ia]==0) ia++;
		while(ib<LEN && b[ib]==0) ib++;
		if(ib==LEN){
			System.out.println("Yes");
			return;
		}
		if(ia==LEN){
			System.out.println("No");
			return;
		}		
		boolean out = true;
		while(ia<LEN && ib<LEN){
			if(a[ia]==b[ib]){
				ia++;
				ib++;
			}else{
				if(a[ia]>b[ib]){
					while(ib<LEN && b[ib]!=a[ia]){
						ib++;
					}
					if(ib==LEN){
						out=false;
						break;
					}
				}
			}
		}
		
		if(out){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}

}
