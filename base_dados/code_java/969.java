import java.util.Scanner;

public class HammingDistancesSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String  a = sc.nextLine(), b = sc.nextLine();
		long sum = 0;
		int frequency[][] = new int[200010][2];
		for (int i = 1; i <= b.length(); i++) {
	        for (int j = 0; j < 2; j++)
	            frequency[i][j] = frequency[i - 1][j];
	        frequency[i][Character.getNumericValue((b.charAt(i - 1)))]++;
	    }
	   
	    for (int i = 0; i < a.length(); i++) {
	        int c = Character.getNumericValue(a.charAt(i));
	        for (int j = 0; j < 2; j++) {
	        	int flippingTerm = Math.abs(c - j);
	        	int endOfWindowValue = frequency[b.length() - a.length() + i + 1][j];
	        	int startOfWindowOffset = frequency[i][j];
	            sum += flippingTerm * (endOfWindowValue - startOfWindowOffset);
	        }
	    }
		System.out.println(sum);
		sc.close();
	}
}
