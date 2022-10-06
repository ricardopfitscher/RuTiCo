import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

		public class codeforces
		{	
			public static void main(String[] args)
			{
				InputReader in = new InputReader(System.in);
				PrintWriter pw = new PrintWriter(System.out);

				int n = in.nextInt();
				long U = in.nextLong();
				long[] E = new long[n];
				double max = -1;
				
				for(int i=0;i<n;i++)
					E[i] = in.nextLong();
				
				for(int k=1;k<n-1;k++)
				{
					int i = k + 1, j = n - 1, mid = 0;
					double T = 0;
					
					while(i < j)
					{
						mid = (int)Math.ceil((double)(i+j)/2);
						
						if(E[mid] - E[k-1] <= U)
							i = mid;
						else
							j = mid - 1;
					}
					
					j = k;
					k = i;
					i = j - 1;
					
					T = E[k] - E[j];
					T /= E[k] - E[i];
					
					if(E[k] - E[i] <= U)
						max = Math.max(max, T);
					
					k = j;
				}	
				
				pw.println(max);
				
				pw.flush();
				pw.close();
			}
			
		/*	public static void DFS(int sourse)
			{
				int count = 0;
				visited[sourse] = true;
				
				for(int u : adj[sourse])
				{
					if(!visited[u])
					{
						DFS(u);
					}
				}
				
				
			}*/
			
			public static ArrayList Divisors(long n)
			{
			    ArrayList<Long> div = new ArrayList<>();
			    
			    for (long i=1; i<=Math.sqrt(n); i++)
			    {
			        if (n%i == 0)
			        {
			        	div.add(i);
			                
			            if(n/i != i)
			            	div.add(n/i);
			        }
			    }
			    return div;
			}
		
			public static int BinarySearch(long[] a, long k)
			{
				int n = a.length;
				int i = 0, j = n-1;
				int mid = 0;
				
				if(k < a[0])
					return 0;
				else if(k >= a[n-1])
					return n;
				else
				{
					while(j - i > 1)
					{
						mid = (i+j)/2;
						
						if(k >= a[mid])
							i = mid;
						else
							j = mid;
					}
				}
				
				return i+1;
			}
			public static long GCD(long a,long b)
			{
				if(b==0)
					return a;
				else
					return GCD(b,a%b);
			}
			
			static class pair implements Comparable<pair>
			{
				Integer x, y;
				pair(int x,int y)
				{
					this.x=x;
					this.y=y;
				}
				
				public int compareTo(pair o) {
					int result = x.compareTo(o.x);
					if(result==0)
						result = y.compareTo(o.y);
					
					return result;
				}  
				
				public String toString()
				{
					return x+" "+y;
				}
				
				public boolean equals(Object o)
				{
					if (o instanceof pair)
				    {
						pair p = (pair)o;
						return p.x - x == 0 && p.y - y == 0 ;
					}
					return false;
				}
				
				public int hashCode()
				{
					return new Long(x).hashCode()*31 + new Long(y).hashCode();
				}
			}
			
			static class InputReader 
			{
				 
				private final InputStream stream;
				private final byte[] buf = new byte[8192];
				private int curChar, snumChars;
				private SpaceCharFilter filter;
		 
				public InputReader(InputStream stream) 
				{
					this.stream = stream;
				}
		 
				public int snext() 
				{
					if (snumChars == -1)
						throw new InputMismatchException();
					if (curChar >= snumChars) 
					{
						curChar = 0;
						try 
						{
							snumChars = stream.read(buf);
						} 
						catch (IOException e) 
						{
							throw new InputMismatchException();
						}
						if (snumChars <= 0)
							return -1;
					}
					return buf[curChar++];
				}
		 
				public int nextInt() 
			    {
					int c = snext();
					while (isSpaceChar(c)) 
					{
						c = snext();
					}
					int sgn = 1;
					if (c == '-')
				    {
						sgn = -1;
						c = snext();
					}
					int res = 0;
					do 
					{
						if (c < '0' || c > '9')
							throw new InputMismatchException();
						res *= 10;
						res += c - '0';
						c = snext();
					} while (!isSpaceChar(c));
					return res * sgn;
				}
		 
				public long nextLong()
			    {
					int c = snext();
					while (isSpaceChar(c)) 
					{
						c = snext();
					}
					int sgn = 1;
					if (c == '-') 
					{
						sgn = -1;
						c = snext();
					}
					long res = 0;
					do 
					{
						if (c < '0' || c > '9')
							throw new InputMismatchException();
						res *= 10;
						res += c - '0';
						c = snext();
					} while (!isSpaceChar(c));
					return res * sgn;
				}
		 
				public int[] nextIntArray(int n) 
				{
					int a[] = new int[n];
					for (int i = 0; i < n; i++) 
					{
						a[i] = nextInt();
					}
					return a;
				}
		 
				public String readString()
			    {
					int c = snext();
					while (isSpaceChar(c)) 
					{
						c = snext();
					}
					StringBuilder res = new StringBuilder();
					do 
					{
						res.appendCodePoint(c);
						c = snext();
					} while (!isSpaceChar(c));
					return res.toString();
				}
		 
				public String nextLine() 
				{
					int c = snext();
					while (isSpaceChar(c))
						c = snext();
					StringBuilder res = new StringBuilder();
					do 
					{
						res.appendCodePoint(c);
						c = snext();
					} while (!isEndOfLine(c));
					return res.toString();
				}
		 
				public boolean isSpaceChar(int c) 
				{
					if (filter != null)
						return filter.isSpaceChar(c);
					return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
				}
		 
				private boolean isEndOfLine(int c) 
				{
					return c == '\n' || c == '\r' || c == -1;
				}
		 
				public interface SpaceCharFilter
			    {
					public boolean isSpaceChar(int ch);
				}
			}
			
			static class CodeX {
	        public static void sort(long arr[]) {
	            merge_sort(arr, 0, arr.length - 1);
	        }
	
	        private static void merge_sort(long A[], long start, long end) {
	            if (start < end) {
	                long mid = (start + end) / 2;
	                merge_sort(A, start, mid);
	                merge_sort(A, mid + 1, end);
	                merge(A, start, mid, end);
	            }
	
	        }
	
	        private static void merge(long A[], long start,long mid, long end) {
	            long p = start, q = mid + 1;
	            long Arr[] = new long[(int)(end - start + 1)];
	            long k = 0;
	
	            for (int i = (int)start; i <= end; i++) {
	                if (p > mid)
	                    Arr[(int)k++] = A[(int)q++];
	
	                else if (q > end)
	                    Arr[(int)k++] = A[(int)p++];
	
	                else if (A[(int)p] < A[(int)q])
	                    Arr[(int)k++] = A[(int)p++];
	
	                else
	                    Arr[(int)k++] = A[(int)q++];
	            }
	            for (int i = 0; i < k; i++) {
	                A[(int)start++] = Arr[i];
	            }
	
	        }
	
	    }
		}	
		

			