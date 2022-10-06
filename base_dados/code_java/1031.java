import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		for(int i = n-1; i > 0; i--)
			arr[i] -= arr[i-1];
		arr[0] = 0;
		Arrays.sort(arr);
		long sum = 0;
		for(int i = n-k; i >= 0; i--)
			sum += arr[i];
		System.out.println(sum);
	}
}