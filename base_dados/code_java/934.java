import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.SecureRandom;

public class WCS {
	
	public static class Vector implements Comparable <Vector>  {
		long x, y;
		int position;
		Vector first, second;
		boolean toReverse;
		
		public Vector(long xx, long yy, int p) {
			x = xx;
			y = yy;
			position = p;
			first = null;
			second = null;
			toReverse = false;
		}
		
		public Vector negate() {
			Vector vv = new Vector(-x, -y, position);
			vv.first = first;
			vv.second = second;
			vv.toReverse = !toReverse;
			return vv;
		}
		
		public Vector add(Vector v) {
			Vector sum = new Vector(this.x + v.x, this.y + v.y, position);
			sum.first = this;
			sum.second = v;
			return sum;
		}
		
		public Vector subtract(Vector v) {
			return this.add(v.negate());
		}
		
		public double euclideanNorm() {
			return Math.sqrt(x * x + y * y);
		}
		
		@Override
		public int compareTo(Vector v) {
			double thisa = Math.atan2(this.y, this.x);
			double va = Math.atan2(v.y, v.x);
			if(thisa < 0)
				thisa += 2 * Math.PI;
			if(va < 0)
				va += 2 * Math.PI;
			if(thisa < va)
				return -1;
			if(thisa > va)
				return 1;
			return Integer.compare(this.position, v.position);
		}
		
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	
	public static void dfs(Vector curr, int[] ans) {
		if(curr.first == null) {
			ans[curr.position] = curr.toReverse ? -1 : 1;
			return;
		}
		curr.first.toReverse ^= curr.toReverse;
		curr.second.toReverse ^= curr.toReverse;
		dfs(curr.first, ans);
		dfs(curr.second, ans);
	}
	
	public static boolean ok(Vector v1, Vector v2) {
		return v1.add(v2).euclideanNorm() <= Math.max(v1.euclideanNorm(), v2.euclideanNorm());
	}
	
	public static void stop(long k) {
		long time = System.currentTimeMillis();
		while(System.currentTimeMillis() - time < k);
	}
	
	public static void main(String[] args) throws IOException {
		int n = in.nextInt();
		TreeSet <Vector> vectors = new TreeSet <> ();
		for(int i = 0; i < n; i ++) {
			Vector v = new Vector(in.nextLong(), in.nextLong(), i);
			vectors.add(v);
		}
		while(vectors.size() > 2) {
			//System.out.println(vectors);
			//stop(500);
			
			TreeSet <Vector> support = new TreeSet <> ();
			
			while(vectors.size() > 0) {
				Vector curr = vectors.pollFirst();
				Vector next1 = vectors.higher(curr);
				Vector next2 = vectors.lower(curr.negate());
				Vector next3 = vectors.higher(curr.negate());
				Vector next4 = vectors.lower(curr);
				
				//System.out.println("CURR: " + curr + "\n" + next1 + "\n" + next2);
				
				if(next1 != null) {
					if(ok(curr, next1)) {
						support.add(curr.add(next1));
						vectors.remove(next1);
						continue;
					}
				}
				if(next1 != null) {
					if(ok(curr, next1.negate())) {
						support.add(curr.subtract(next1));
						vectors.remove(next1);
						continue;
					}
				}
				if(next2 != null) {
					if(ok(curr, next2)) {
						support.add(curr.add(next2));
						vectors.remove(next2);
						continue;
					}
				}
				if(next2 != null) {
					if(ok(curr, next2.negate())) {
						support.add(curr.subtract(next2));
						vectors.remove(next2);
						continue;
					}
				}
				if(next3 != null) {
					if(ok(curr, next3)) {
						support.add(curr.add(next3));
						vectors.remove(next3);
						continue;
					}
				}
				if(next3 != null) {
					if(ok(curr, next3.negate())) {
						support.add(curr.subtract(next3));
						vectors.remove(next3);
						continue;
					}
				}
				if(next4 != null) {
					if(ok(curr, next4)) {
						support.add(curr.add(next4));
						vectors.remove(next4);
						continue;
					}
				}
				if(next4 != null) {
					if(ok(curr, next4.negate())) {
						support.add(curr.subtract(next4));
						vectors.remove(next4);
						continue;
					}
				}
				
				support.add(curr);
			}
			
			vectors = support;
		}
		
		if(vectors.size() == 2) {
			Vector curr = vectors.pollFirst();
			Vector next = vectors.pollFirst();
			Vector add = curr.add(next);
			Vector sub = curr.subtract(next);
			if(sub.euclideanNorm() <= add.euclideanNorm())
				vectors.add(sub);
			else
				vectors.add(add);
		}
		
		//System.out.println(vectors.first().euclideanNorm());
		
		StringBuilder buffer = new StringBuilder();
		int[] ans = new int[n];
		dfs(vectors.pollFirst(), ans);
		for(int i = 0; i < n; i ++)
			buffer.append(ans[i] + " ");
		System.out.println(buffer);
	}
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        BigInteger nextBigInteger() {
        	return new BigInteger(in.next());
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        char nextChar() {
            return in.next().charAt(0);
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    static FastReader in = new FastReader();
    static OutputStream out = new BufferedOutputStream(System.out);
    
    public static byte[] toByte(Object o) {
        return String.valueOf(o).getBytes();
    }
    
    public static void sop(Object o) {
        System.out.print(o);
    }
}