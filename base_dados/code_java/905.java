import java.io.*;
import java.math.BigInteger; 
import java.util.*;



//Mann Shah [ DAIICT ].
//fast io

public class Main {
	static int mod = (int) (1e9+7);
	static InputReader in;
    static PrintWriter out;
    
    		public static int n;
    		public static int m;
    
    		public static boolean valid(int i , int j) {
    			
    			return ( i<n && j<m && i>=0 && j>=0);
    		}
    		
   
		public static void main(String args[] )  {
			
		  in = new InputReader(System.in);
	      out = new PrintWriter(System.out);
	     
	     n = in.nextInt();
	    	 m = in.nextInt();
	    
	    	String[] s = new String[n];
	    	for(int i=0;i<n;i++) {
	    		s[i]= in.readString();
	    	}
	    	int f=0;
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<s[i].length();j++) {
	    			int val=-1;
	    			if(s[i].charAt(j)=='.') {
	    				val=0;
	    			}
	    			else if(s[i].charAt(j)=='*') {
	    				continue;
	    			}
	    			else {
	    				val = s[i].charAt(j)-'0';
	    			}
	    			int c=0;
	    			if(valid(i-1,j) && s[i-1].charAt(j)=='*'){
	    				c++;
	    			}
	    			if(valid(i-1,j-1) && s[i-1].charAt(j-1)=='*'){
	    				c++;
	    			}
	    			if(valid(i-1,j+1) && s[i-1].charAt(j+1)=='*'){
	    				c++;
	    			}
	    			if(valid(i,j-1) && s[i].charAt(j-1)=='*'){
	    				c++;
	    			}
	    			if(valid(i,j+1) && s[i].charAt(j+1)=='*'){
	    				c++;
	    			}
	    			if(valid(i+1,j) && s[i+1].charAt(j)=='*'){
	    				c++;
	    			}
	    			if(valid(i+1,j+1) && s[i+1].charAt(j+1)=='*'){
	    				c++;
	    			}
	    			if(valid(i+1,j-1) && s[i+1].charAt(j-1)=='*'){
	    				c++;
	    			}
	    			if(c!=val) {
	    				f=1;
	    				break;
	    			}
	    		}
	    	}
	    	if(f==0) {
	    		out.println("YES");
	    	}
	    	else {
	    		out.println("NO");
	    	}
	     
	     
	     out.close();
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
	                        } catch (IOException e)
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

	        public long[] nextLongArray(int n)
	        {
	                long a[] = new long[n];
	                for (int i = 0; i < n; i++)
	                {
	                        a[i] = nextLong();
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
		
}

//For Pair sorting

//Arrays.sort(arr,new Comparator<Pair>() {
//		@Override public int compare(Pair p1, Pair p2) 
//{ 
//    return p1.x - p2.x; 
//} 
//});



//Pair arr[] = new Pair[n]; 
//arr[0] = new Pair(10, 20); 
class Pair { 
    int x; 
    int y; 
  
    // Constructor 
public Pair(int x, int y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
} 
// class Compare { 
//	  //void return by default.
//     public  Pair[] compare(Pair arr[], int n) 
//    { 
//        // Comparator to sort the pair according to first element.
//        Arrays.sort(arr, new Comparator<Pair>() { 
//            @Override public int compare(Pair p1, Pair p2) 
//            { 
//                return p1.x - p2.x; 
//            } 
//        }); 
//        
//        
//        return arr;
//       /* for (int i = 0; i < n; i++) { 
//            System.out.print(arr[i].x + " " + arr[i].y + " "); 
//        } 
//        System.out.println(); */
//    } 
//} 
//



class couple implements Comparable<couple>
{ int x,y;
  public couple(int m,int f) {
 	 x=m;
 	 y=f;
  }
	public int compareTo(couple o) {
		
		 
		return x-o.x;
	}  
}
