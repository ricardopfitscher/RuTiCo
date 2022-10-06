import java.awt.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long x = scanner.nextLong(), y = scanner.nextLong();
        long whiteSteps, blackSteps;

        if(x == 1 || y == 1){
            whiteSteps = (x - 1) + (y - 1);
        } else {
            whiteSteps = Math.min((x - 1) + Math.abs(y - x), (y - 1) + Math.abs(y - x));
        }

        if(x == n || y == n){
            blackSteps = (n - x) + (n - y);
        } else {
            blackSteps = Math.min((n - x) + Math.abs(y - x), (n - y) + Math.abs(y - x));
        }

        if (whiteSteps <= blackSteps){
            System.out.println("White");
        } else {
            System.out.println("Black");
        }

    }
}
