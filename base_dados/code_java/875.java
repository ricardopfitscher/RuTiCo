import java.util.*;
 
public class Main{
    private static final int MAX_SIZE = 100005;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(((m + 1) / 60 < a) || ((m + 1) / 60 == a && (m + 1) % 60 <= b)) {
            out(0, 0);
            System.exit(0);
        }
        for(int i = 2; i <= n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int bb = b + 2 * m + 2;
            int aa = a + bb / 60;
            bb %= 60;

            if((aa < x) || (aa == x && bb <= y)) {
                b = b + m + 1;
                a = a + b / 60;
                b %= 60;
                out(a, b);
                System.exit(0);
            }
            a = x;
            b = y;
        }
        b = b + m + 1;
        a = a + b / 60;
        b = b % 60;        
        out(a, b);
    }

    private static void out(int a, int b) {
        cout(a);
        cout(" ");
        cout(b);
    }

    private static void cout(Object a) {
        System.out.print(a);
    }
}