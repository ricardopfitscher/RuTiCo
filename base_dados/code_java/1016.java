
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class E1180D {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Move from both ends, Time limit exceeded on test 6
        for (int i= 1; i<= m/2; i++) {
            // String s = "";
            int i2 = m -i + 1; // the other end of i
            // i is left row, i2 is right row
            for (int j = 1; j <= n ; j++) {
                int j2 = n - j + 1;
                // start with (i,j), then go thru all the cell with (,i) and (,i2)
                pw.println(j + " " + i);
                pw.println(j2+ " " + i2);
                // s += j + " " + i + "\n" + j2+ " " + i2 + "\n";
            }
            // out.print(s);
        }
        
        // if n is odd, there is one line in the middle
        if (m % 2 == 1) {
            int i2 = m /2 + 1; // this is the middle column
            for (int j = 1; j <= n/2 ; j++) {
                int j2 = n - j + 1;
                // start with (i,j), then go thru all the cell with (,i) and (,i2)
                pw.println(j + " " + i2);
                pw.println(j2+ " " + i2);
            }
            if (n %2 == 1) {
                int j = n /2 + 1;
                pw.println(j + " " + i2);
            }
        }
        pw.flush();
        pw.close();
    }    
}
