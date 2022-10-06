    import java.util.*;
    import java.io.*;
    import java.lang.*;
    import java.math.*;
    public class B {
        public static void main(String[] args) throws Exception {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Integer[] a = new Integer[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            int[] b = new int[n];
            for(int i=0; i<n; i++) b[i] = a[i].intValue();
            boolean diff = false;
            boolean diff2 = false;
            Set<Integer> vals = new HashSet<Integer>();
            vals.add(b[0]);
            int valval = 0;
            for(int i=1; i<n; i++) {
                vals.add(b[i]);
                if(b[i] == b[i-1]) {
                    if(!diff) {
                        diff = true;
                        valval = b[i];
                    }
                    else diff2 = true;
                }
            } 
            long sum = 0;
            for(int i : b) sum += i;
            sum -= 1L*n*(n-1)/2;

            if(diff && !diff2) {
                if(!vals.contains((valval-1)) && (valval > 0)) {
                    if(sum%2 == 0) out.println("cslnb"); else out.println("sjfnb");
                }
                else out.println("cslnb");
            }
            else if(diff2) out.println("cslnb");
            else if(sum%2 == 0) out.println("cslnb"); else out.println("sjfnb");
            // int n = Integer.parseInt(st.nextToken());
     
            
            out.close(); System.exit(0);
        }
    }