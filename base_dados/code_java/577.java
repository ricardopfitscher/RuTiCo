import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class BigInteger7 {
    public static void main(String[] args) {
        //https://codeforces.com/contest/1011/problem/A
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger k = scanner.nextBigInteger();
        scanner.nextLine();
        String string = scanner.nextLine();
        char ch[] = string.toCharArray();
        BigInteger ans = BigInteger.ZERO;
        BigInteger number = BigInteger.ZERO;
        Arrays.sort(ch);
        int prev = 0;
        for (int i = 0; BigInteger.valueOf(i).subtract(n).compareTo(BigInteger.ZERO) < 0; i++) {
            if (i == 0) {
                ans = ans.add(BigInteger.valueOf(ch[i] - 'a' + 1));
                prev = i;
                number = number.add(BigInteger.ONE);
            } else {
                if (ch[i] - ch[prev] > 1) {
                    ans = ans.add(BigInteger.valueOf(ch[i] - 'a' + 1));
                    prev = i;
                    number = number.add(BigInteger.ONE);
                }
            }
            if (number.equals(k)) {
                break;
            }
        }
        if (number.subtract(k).compareTo(BigInteger.ZERO) < 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
