import java.util.*;

public class vas2 {
    public static void main( String[] args ) {
	Scanner in = new Scanner( System.in );
	int n = in.nextInt();
	String st = in.next();
	int[] a = new int[n];
	for ( int i = 0; i < n; i++ )
	    a[i] = st.charAt( i ) - 48;
	boolean c = false;
	for ( int i = 1; !c && i < n; i++ ) {
	    int s = 0;
	    for ( int j = 0; j < i; j++ )
		s += a[j];
	    int t = 0;
	    for ( int j = i; j < n; j++ ) {
		t += a[j];
		if ( t > s )
		    if ( t - a[j] != s )
			break;
		    else
			t = a[j];
	    }
	    if ( t == s )
		c = true;
	}
	System.out.println( c ? "YES" : "NO" );
    }
}
