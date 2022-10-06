import java.util.*;

public class ehab3 {
    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
	int n = in.nextInt();
	int[] a = new int[n];
	for ( int i = 0; i < n; i++ )
	    a[i] = in.nextInt();
	System.out.println( ( n + 1 ) );
	int c = 0;
	for ( int i = n - 1; i >= 0; i-- ) {
	    int cd = n + i - ( ( a[i] + c ) % n );
	    System.out.println( "1 " + ( i + 1 ) + " " + cd );
	    c += cd;
	}
	System.out.println( "2 " + n + " " + n );
    }
}
