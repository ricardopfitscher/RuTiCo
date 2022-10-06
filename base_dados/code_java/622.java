

import java.util.Scanner;

public class TaxiDriversAndLyft2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		long[] people = new long[(int) (n+m)];
		int[] taxiDrivers = new int[(int) (n+m)];
		
		for(int i = 0;i< (n+m); i++) {
			people[i] = scanner.nextLong();
		}
		
		for(int i = 0;i< (n+m); i++) {
			taxiDrivers[i] = scanner.nextInt();
		}
		
		int lastTaxiDriverIndex = -1;
		long[] riderCountArray = new long[(int) (m)];
		long[] a1 = new long[(int)n];
		long[] b1 = new long[(int)m];
		
		int j=0, k=0;
		for(int i = 0;i< (n+m); i++) {	
			if(taxiDrivers[i] == 0) {
				a1[j] = people[i];
				j++;
			}
			else  {
				b1[k] = people[i];
				k++;
			}
		}
		
		int l = 0, q=0;
		for(int i=0;i<j;i++) {
			while ((l<m-1 && m>1) && Math.abs(a1[i] - b1[l]) > Math.abs(a1[i] - b1[l+1])) {
				l++; 
			}
			
			riderCountArray[l]++;	
		}
		
		for(int i = 0;i< (m); i++) {
			System.out.print(riderCountArray[i]+" ");
		}
	} 
}
