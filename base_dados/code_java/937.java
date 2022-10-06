import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();
        String s = in.next();
        int zero = 0;
        if( s.charAt(0) == '0' ) zero++;
        for( int i = 1 ; i < n ; i++){
            if( s.charAt(i) == '0' && s.charAt(i-1) == '1' ) zero++;
        }
        long num = 0;
        if( zero == 0 ) num = 0;
        else if( x > y ) num = zero*y;
        else num = y + ( zero-1 )*x;
        System.out.println(num);
    }
}
