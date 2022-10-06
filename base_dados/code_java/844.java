// discussed with rainboy
import java.io.*;
import java.util.*;

public class CF915E {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int q = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> mp = new TreeMap<>();
		int ans = 0;
		while (q-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			Map.Entry<Integer, Integer> e;
			int l_, r_;
			if (t == 1) {
				if ((e = mp.floorEntry(l)) != null && (r_ = e.getValue()) >= l) {
					l_ = e.getKey();
					ans -= r_ - l_;
					l = l_;
					r = Math.max(r, r_);
				}
				while ((e = mp.higherEntry(l)) != null && (l_ = e.getKey()) <= r) {
					r_ = e.getValue();
					ans -= r_ - l_;
					r = Math.max(r, r_);
					mp.remove(l_);
				}
				ans += r - l;
				mp.put(l, r);
			} else {
				r_ = l;
				if ((e = mp.floorEntry(l)) != null && (r_ = e.getValue()) > l) {
					l_ = e.getKey();
					if (l_ < l)
						mp.put(l_, l);
					else
						mp.remove(l_);
					ans -= r_ - l;
				}
				while ((e = mp.higherEntry(l)) != null && (l_ = e.getKey()) < r) {
					r_ = e.getValue();
					mp.remove(l_);
					ans -= r_ - l_;
				}
				if (r_ > r) {
					mp.put(r, r_);
					ans += r_ - r;
				}
			}
			pw.println(n - ans);
		}
		pw.close();
	}
}
