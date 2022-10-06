	import java.io.BufferedReader;
	
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.*;
	
	import javax.print.attribute.standard.QueuedJobCount;
	
	public class A {
		static int n;
		static TreeSet<Integer> Primes;
		static int[] arr;
		static int[] arr2;
	
		public static int[] copyOf(int[] arr) {
			for (int i = 0; i < arr.length; i++)
				arr2[i] += arr[i];
			return arr2;
		}
	
		public static long addEvens(int[] arr) {
			long r = 0;
			for (int i = 0; i < arr.length; i++)
				if (arr[i] % 2 == 0)
					r += arr[i];
			return r;
		}
	
		public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			PrintWriter pw = new PrintWriter(System.out);
			arr = new int[14];
			for (int i = 0; i < 14; i++) {
				arr[i] = sc.nextInt();
			}
			int x = 5535;
			int y = x;
			int s;
			long max = Integer.MIN_VALUE;
			for (int i = 0; i < 14; i++) {
				int a = arr[i];
				arr2 = new int[14];
				arr2 = copyOf(arr);
				arr2[i]=0;
				int j =0;
				int rem = arr[i] / 14;
				int steps = 0;
				int c = 0;
				for (  j = i+1;c<14; j++) {
					if (j >=14 )
						j = 0;
					arr2[c] += rem;
					c++;
				}
				steps = arr[i] % 14;
				j = i;
				c=0;
				int adasd;
				for ( j = i+1;c<steps; j++) {
					if (j >= 14)
						j = 0;
					arr2[j] += 1;
					c++;
				}
				max = Math.max(max, addEvens(arr2));
			}
			pw.print(max);
	
			pw.flush();
		}
	
	
	
	}
