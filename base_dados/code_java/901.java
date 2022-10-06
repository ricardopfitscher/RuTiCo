import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wide = new int[n], sta = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
        	wide[i] = sc.nextInt();
        	hm.put(wide[i], i + 1);
        }
        Util.sort(wide);
        sc.nextLine();
        String s = sc.nextLine();
        int tp = 0, pos = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	int t;
        	if (s.charAt(i) == '0') {
        		t = wide[pos++];
        		sta[tp++] = t;
        	} else t = sta[--tp];
        	out.append(hm.get(t) + " ");
        }
        System.out.println(out.toString());
        sc.close();
    }
    public static class Util {
    	
    	public static <T extends Comparable<T> > void merge_sort(T[] a) {
    		Object[] aux = new Object[a.length];
    		merge_sort0(a, aux, 0, a.length);
    	}
    	
    	public static <T extends Comparable<T> > void merge_sort(T[] a, int l, int r) {
    		Object[] aux = new Object[a.length];
    		merge_sort0(a, aux, l, r);
    	}
    	
    	@SuppressWarnings("unchecked")
    	private static <T extends Comparable<T> > void merge_sort0(T[] a, Object[] temp, int l, int r) {
    		if (l + 1 == r) return;
    		int mid = (l + r) >> 1;
    		merge_sort0(a, temp, l, mid);
    		merge_sort0(a, temp, mid, r);
    		int x = l, y = mid, c = l;
    		while (x < mid || y < r) {
    			if (y == r || (x < mid && a[x].compareTo(a[y]) <= 0)) temp[c++] = a[x++];
    			else temp[c++] = a[y++];
    		}
    		for (int i = l; i < r; i++) a[i] = (T)temp[i];
    	}
    	
    	static final Random RAN = new Random();
    	
    	public static <T extends Comparable<T> > void quick_sort(T[] a) {
    		quick_sort0(a, 0, a.length);
    	}
    	
    	public static <T extends Comparable<T> > void quick_sort(T[] a, int l, int r) {
    		quick_sort0(a, l, r);
    	}
    	
    	private static <T extends Comparable<T> > void quick_sort0(T[] a, int l, int r) {
    		if (l + 1 >= r) return;
    		int p = l + RAN.nextInt(r - l);
    		T t = a[p]; a[p] = a[l]; a[l] = t;
    		int x = l, y = r - 1;
    		while (x < y) {
    			while (x < y && a[y].compareTo(t) > 0) --y;
    			while (x < y && a[x].compareTo(t) < 0) ++x;
    			if (x < y) {
    				T b = a[x]; a[x] = a[y]; a[y] = b;
    				++x; --y;
    			}
    		}
    		quick_sort0(a, l, y + 1);
    		quick_sort0(a, x, r);
    	}
    	
    	static final int BOUND = 8;
    	
    	public static void bucket_sort(int[] a) {
    		bucket_sort(a, 0, a.length);
    	}
    	
    	public static void bucket_sort(int[] a, int l, int r) {
    		int[] cnt = new int[1 << BOUND], b = new int[r - l + 1];
    		int y = 0;
    		for (int i = l; i < r; i++) ++cnt[a[i] & (1 << BOUND) - 1];
    		while (y < Integer.SIZE) {
    			for (int i = 1; i < 1 << BOUND; i++) cnt[i] += cnt[i - 1];
    			for (int i = r - 1; i >= l; i--) b[--cnt[a[i] >> y & (1 << BOUND) - 1]] = a[i];
    			y += BOUND;
    			Arrays.fill(cnt, 0);
    			for (int i = l; i < r; i++) {
    				a[i] = b[i - l];
    				++cnt[a[i] >> y & (1 << BOUND) - 1];
    			}
    		}
    	}
    	
    	public static void bucket_sort(long[] a) {
    		bucket_sort(a, 0, a.length);
    	}
    	
    	public static void bucket_sort(long[] a, int l, int r) {
    		int[] cnt = new int[1 << BOUND];
    		long[] b = new long[r - l + 1];
    		int y = 0;
    		while (y < Long.SIZE) {
    			Arrays.fill(cnt, 0);
    			for (int i = l; i < r; i++) ++cnt[(int) (a[i] >> y & (1 << BOUND) - 1)];
    			for (int i = 1; i < 1 << BOUND; i++) cnt[i] += cnt[i - 1];
    			for (int i = r - 1; i >= l; i--) b[--cnt[(int) (a[i] >> y & (1 << BOUND) - 1)]] = a[i];
    			for (int i = l; i < r; i++) a[i] = b[i - l];
    			y += BOUND;
    		}
    	}
    	
    	public static void sort(int[] a) {
    		if (a.length <= 1 << BOUND) {
    			Integer[] b = new Integer[a.length];
    			for (int i = 0; i < a.length; i++) b[i] = a[i];
    			quick_sort(b);
    			for (int i = 0; i < a.length; i++) a[i] = b[i];
    		} else bucket_sort(a);
    	}

    	public static void sort(long[] a) {
    		if (a.length <= 1 << BOUND) {
    			Long[] b = new Long[a.length];
    			for (int i = 0; i < a.length; i++) b[i] = a[i];
    			quick_sort(b);
    			for (int i = 0; i < a.length; i++) a[i] = b[i];
    		} else bucket_sort(a);
    	}
    	
    	public static <T extends Comparable<T> > void sort(T[] a) {
    		quick_sort(a);
    	}
    	
    	public static void shuffle(int[] a) {
    		Random ran = new Random();
    		for (int i = 0; i < a.length; i++) {
    			int p = ran.nextInt(i + 1);
    			int q = a[p]; a[p] = a[i]; a[i] = q; 
    		}
    	}
    	
    	public static void shuffle(long[] a) {
    		Random ran = new Random();
    		for (int i = 0; i < a.length; i++) {
    			int p = ran.nextInt(i + 1);
    			long q = a[p]; a[p] = a[i]; a[i] = q; 
    		}
    	}
    	
    	public static <T> void shuffle(T[] a) {
    		Random ran = new Random();
    		for (int i = 0; i < a.length; i++) {
    			int p = ran.nextInt(i + 1);
    			T q = a[p]; a[p] = a[i]; a[i] = q; 
    		}
    	}
    	
    }
}