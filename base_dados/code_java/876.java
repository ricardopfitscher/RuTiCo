import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int s1 = scanner.nextInt();
		List<Integer> s = new ArrayList<>();
		for(int i = 0; i < n-1; i++) {
			s.add(scanner.nextInt());
		}
		Collections.sort(s, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		int imax = 0;
		int p = (int) Math.floor(((double) s1*(A - B))/B);
		while(imax < n-1 && s.get(imax) > p) imax++;
		int result = imax;
		int sum = 0;
		int t = n-1;
		do {
			t--;
			if(t == imax-1) break;
			sum += s.get(t);
		} while(sum <= p);
		if(sum > p) {
			result += (t+1) - imax;
		} 
		System.out.println(result);
	}
}