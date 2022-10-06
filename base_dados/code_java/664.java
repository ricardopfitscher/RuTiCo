//package fourninetysixDiv3;
import java.util.HashMap;
import java.util.Scanner;
public class Median_Segments_general {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(func(n, m, arr)-func(n, m+1, arr));
	}
	public static long func(int n,int m,int[] arr) {
		HashMap<Long, Integer> map = new HashMap<>();
		map.put((long) 0, 1);
		long sum = 0;
		long res = 0;
		long add=0;
		for(int i=0;i<n;i++) {
			if(arr[i]<m) {
				sum--;
				if(map.containsKey(sum)) {
					add-=map.get(sum);
				}
			}
			else {
				if(map.containsKey(sum)) {
					add+=map.get(sum);
				}
				sum++;
			}
			res+=add;
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum)+1);
			}
			else {
				map.put(sum,1);
			}
		}
		return res;
	}
}
