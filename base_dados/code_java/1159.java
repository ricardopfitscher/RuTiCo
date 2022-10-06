import java.util.*;

public class ehab4 {
    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
	int a = 0, b = 0;
	System.out.println( "? 0 0 " );
	System.out.flush();
	int c = in.nextInt();
	for ( int i = 29; i >= 0; i-- ) {
	    System.out.println( "? " + ( a + ( 1 << i ) ) + " " + b );
	    System.out.flush();
	    int q1 = in.nextInt();
	    System.out.println( "? " + a + " " + ( b + ( 1 << i ) ) );
	    System.out.flush();
	    int q2 = in.nextInt();
	    if ( q1 == q2 ) {
		if ( c == 1 )
		    a += ( 1 << i );
		else if ( c == -1 )
		    b += ( 1 << i );
		c = q1;
	    }
	    else if ( q1 == -1 ) {
		a += ( 1 << i );
		b += ( 1 << i );
	    }
	    else if ( q1 == -2 )
		return;
	}
	System.out.println( "! " + a + " " + b );
	System.out.flush();
    }
}
